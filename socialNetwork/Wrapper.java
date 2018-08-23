package socialNetwork;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This is the wrapper class for the Graph, it allows the UI to run simple queries
 * on the graph without having to worry about algorithms.
 */
public class Wrapper {
  /** The network containing all people and their friends */
  private Graph network;

  /** A string that contains the computed popular people in the network */
  private String popular;

  /** Contains the calculated integer of the number of people not connected to each other in the network */
  private int notConnected;

  /**
   * Create the network based on the input file. This file must be organized with each
   * person's name in lines at the top of the file, then after a $ on one line,
   * it lists the relationships between the people.
   * @param in The input file containing info about network construction
   */
  private void createNetwork( File in ) {
    /**
     1) Go up to $ and add each person to the graph
     2) Go through end and update the friends state of each person in graph
     - add both ways ('b a' in file would need b to be added to a.friends and a added to b.friends)
     */
    Scanner input = null;
    try {
      input = new Scanner( in );
    } catch( FileNotFoundException e ) {
      System.out.println( "File cannot be opened." );
      System.exit( 1 );
    }

    boolean addMore = true;
    while ( input.hasNextLine() ) {
      String line = input.nextLine();
      if ( line.equals("$") ) {
        addMore = false;
        continue;
      }
      Scanner n = new Scanner( line );
      if ( addMore ) {
        // Add more people to the graph
        Person p = new Person( n.next() );
        network.add( p );
        p.setAdded( network.numPeople() );
      } else {
        // Add relations between people in the graph
        if ( n.hasNext() ) {
          Person p1 = network.find( n.next() );
          Person p2 = network.find( n.next() );

          p1.addFriend( p2 );
          p2.addFriend( p1 );
        }
      }
    }
  }

  /**
   * Determine whether or not two people are friends in the network.
   * @param a The first person to check
   * @param b The other person to check
   * @return true if the people are friends, false if not
   */
  public boolean isFriend( String a, String b ) {
    Person p1 = network.find( a );
    Person p2 = network.find( b );

    LinkedList<Person> friends = p1.getFriends();
    for ( int i = 0; i < friends.size(); i++ ) {
      if ( friends.get( i ).getName().equals( p2.getName() ) ) return true;
    }

    return false;
  }

  /**
   * Finds the mutual friends of two people in the network.
   * @param a The first person to check the friends of
   * @param b The other person to check the friends of
   * @return The mutual friends of both people
   */
  public String mutualFriends( String a, String b ) {
    Person p1 = network.find( a );
    Person p2 = network.find( b );

    String toReturn = "";
    LinkedList<Person> listMain = p1.getFriends();
    LinkedList<Person> listPass = p2.getFriends();
    for ( int i = 0; i < listMain.size(); i++ ) {
      String name = listMain.get( i ).getName();
      for ( int k = 0; k < listPass.size(); k++ ) {
        if ( listPass.get( k ).getName().equals( name ) ) toReturn += name + "\n";
      }
    }

    return toReturn;
  }

  /**
   * Finds the relation between two people using the lowest number of indirect/direct friends
   * to create the relation.
   * @param a The person to begin the relation at
   * @param b The person to end the relation at
   * @return The shortest path between both people in the network
   */
  public String relation( String a, String b ) {
    LinkedList<Person> path = network.diJakestra( network.find( a ), network.find( b ) );

    String toReturn = "";
    for( int i = 0; i < path.size(); i++ ) {
      toReturn += path.get( i ).getName() + "\n";
    }

    return toReturn;
  }

  /**
   * Computes the number of people that aren't connected in the network
   * @return The number of people that are not connected in the network
   */
  public int notConnected() {
    if( notConnected != -1 ) return notConnected;

    String[] people = network.getPeople();

    int num = 0;
    LinkedList<Integer> comps = new LinkedList<Integer>();
    for ( int i = 0; i < people.length; i++ ) {
      Person p = network.find( people[ i ] );
      if ( p.getVisited() == -1 ) comps.addToRear( network.lizFirstSearch( p, 0, false ).size() );
    }

    for ( int i = 0; i < comps.size(); i++ ) {
      int base = comps.get( i );
      for ( int k = i + 1; k < comps.size(); k++ ) {
        num += ( base * comps.get( k ) );
      }
    }

    for ( int i = 0; i < people.length; i++ ) {
      Person p = network.find( people[ i ] );
      if ( p.getVisited() != -1 ) network.resetVisited( p );
    }

    notConnected = num;
    return num;
  }

  /**
   * Determine the most popular people in the network. This is found by dividing the
   * number of direct/indirect friends by the length of the paths to get to each of
   * those people.
   * @return The most popular people in the network
   */
  public String computePopular() {
    if ( !popular.isEmpty() ) return popular;

    String[] people = network.getPeople();

    Person pi;
    for ( int i = 0; i < people.length; i++ ) {
      pi = network.find( people[ i ] );
      if ( !pi.isInComponent() ) {
        LinkedList<Person> connected = network.lizFirstSearch( pi, 0, true );
        int num = connected.size() - 1;
        for ( int k = 0; k < connected.size(); k++ ) {
          int denom = 0;
          Person pk = connected.get( k );
          if( k != 0 ) network.lizFirstSearch( pk, 0, true );

          for ( int l = 0; l < connected.size(); l++ ) {
            if( l == k ) continue;
            LinkedList<Person> path = network.jakeReverseSearch( connected.get( l ), new LinkedList<Person>() );
            if( path.size() > 0 ) denom += path.size() - 1;
          }
          if( denom != 0 ) pk.setPopularity( (double) num / denom );
          network.resetVisited( pk );
        }
      }
    }

    highestPopular();

    return popular;
  }

  /**
   * Go through each person in the network and set the ones
   * with the highest popularity to the field popular
   */
  private void highestPopular() {
    double high = 0;
    String[] people = network.getPeople();
    LinkedList<Person> mostPopular = new LinkedList<Person>();
    for ( int i = 0; i < people.length; i++ ) {
      Person pi = network.find( people[ i ] );
      if ( pi.getPopularity() == high ) {
        addSorted( mostPopular, pi );
      } else if ( pi.getPopularity() > high ) {
        mostPopular = new LinkedList<Person>();
        mostPopular.addToRear( pi );
        high = pi.getPopularity();
      }
    }

    for ( int i = 0; i < mostPopular.size(); i++ ) {
      popular += mostPopular.get( i ).getName() + "\n";
    }
  }

  /**
   * Add a person to a linked list in sorted order by when they were added
   * to the network.
   * @param list the list to add to
   * @param p the person to add
   */
  private void addSorted( LinkedList<Person> list, Person p ) {
    int sortSize = list.size();
    int k = 0;
    while( k < sortSize && list.get( k ).getAdded() < p.getAdded() ) k++;
    if ( k == sortSize ) {
      list.addToRear( p );
    } else {
      list.add( p, k );
    }
  }

  /**
   * The constructor for the class. It creates a new instance of a Graph for
   * the network and initializes other fields to how they should start. Also
   * calls createNetwork method to create the network based on the input file.
   * @param input The file to create the network from.
   */
  public Wrapper( File input ) {
    network = new Graph();
    popular = "";
    notConnected = -1;
    createNetwork( input );
  }
}