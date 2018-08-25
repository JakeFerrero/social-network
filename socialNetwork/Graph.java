package socialNetwork;

import java.util.HashMap;

/**
 * Graph class used by the socialNetwork.  Contains a list of all of the people within the social
 * network using a hash map.  The keys of the hash map are the names of the people in the network
 * and each key points to the contents of a person with that name.
 */
public class Graph {
  /**
   * Hash map of People used within Graph to keep track of people in the Social Network.
   */
  private HashMap<String, Person> people;
  
  /**
   * Constructor for the class. Creates a hash map of type Person.
   */
  public Graph() {
    this.people = new HashMap<String, Person>();
  }
  
  /**
   * Method that adds a Person to the hash map.
   * @param p the Person to add.
   */
  public void add(Person p) {
    people.put(p.getName(), p);
  }
  
  /**
   * Finds the person with the given name in the hash map and returns that person.
   * @param name Name of person to find.
   * @return Found person.
   */
  public Person find(String name) {
    return people.get(name);
  }
  
  /**
   * Returns a list of all people in the hash map.
   * @return List of everyone in the hash map.
   */
  public String[] getPeople() {
    return people.keySet().toArray(new String[people.size()]);
  }

  public int numPeople() { return people.size(); }
  
  /**
   * Using two helper methods, lizFirstSearch and jakeReverseSearch, this method finds the shortest
   * path between two people and returns that path (list of vertices/people along the way) as a
   * string.  Afterwards, resets all "visited" values of everyone in the graph to -1 (unvisited).
   * @param start Person to start the path at.
   * @param end Person to end the path at.
   * @return Shortest path between the two parameters.
   */
  public LinkedList<Person> diJakestra(Person start, Person end) {
    int initLevel = 0;
    lizFirstSearch(start, initLevel, false );
    LinkedList<Person> toReturn = jakeReverseSearch(end, new LinkedList<Person>());
    resetVisited(start);
    return toReturn;
  }
  
  /**
   * Helper method for diJakestra.  Returns the shortest path from the starting Person (which would
   * be one that has level 0 in this case) to the end Person.
   * @param end Person to start the search of shortest path from.
   * @param people Path string.
   * @return shortest path from a Person with level 0 to end Person.
   */
  public LinkedList<Person> jakeReverseSearch(Person end, LinkedList<Person> people) {
    if (end.getVisited() == 0) {
      people.add(end, 0);
      return people;
    }

    Person p;
    LinkedList<Person> friends = end.getFriends();
    for (int i = 0; i < friends.size(); i++) {
      p = friends.get(i);
      if (p.getVisited() < end.getVisited()) {
        for (int k = i + 1; k < friends.size(); k++) {
          Person other = friends.get(k);
          if (p.getOrderVisited() > other.getOrderVisited()) {
            p = other;
          }
        }
        people.add(end, 0);
        people = jakeReverseSearch(p, people);
        break;
      }
    }
    return people;
  }
  
  /**
   * Helper method for diJakestra.  Implementation of BFS that marks people as visited with an int
   * that represents what level that person is in.
   * @param start Person to start BFS at.
   * @param level Level to start at.
   * @return the number of people in the connected component
   */
  public LinkedList<Person> lizFirstSearch(Person start, int level, boolean markConnected ) {
    int orderLevel = 0;
    start.setVisited(level);
    start.setOrderVisited(orderLevel);
    LinkedList<Person> peeps = new LinkedList<Person>();
    peeps.addToRear(start);
    
    level++;
    orderLevel++;
    LinkedList<Person> connected = new LinkedList<Person>();
    if ( markConnected ) start.setInComponent(true);
    connected.addToRear(start);
    while(!peeps.isEmpty()) {
      Person p = peeps.remove(0);
      boolean allVisited = true;
      LinkedList<Person> friends = p.getFriends();
      for (int i = 0; i < friends.size(); i++) {
        Person pi = friends.get(i);
        if (pi.getVisited() == -1) {
          pi.setVisited(level);
          pi.setOrderVisited(orderLevel);
          peeps.addToRear(pi);
          allVisited = false;
          orderLevel++;

          if ( markConnected ) pi.setInComponent(true);
          connected.addToRear(pi);
        }
      }
      if (!allVisited)
        level++;
    }
    return connected;
  }
  
  /**
   * Resets everyone's "visited" and "orderVisited" values back to -1.
   * @param start Person to start at.
   */
  public void resetVisited(Person start) {
    start.resetVisited();
    start.resetOrderVisited();
    LinkedList<Person> tomodachi = new LinkedList<Person>();
    tomodachi.addToRear(start);
    
    while(!tomodachi.isEmpty()) {
      Person p = tomodachi.remove(0);
      LinkedList<Person> friends = p.getFriends();
      for (int i = 0; i < friends.size(); i++) {
        Person pi = friends.get(i);
        if (pi.getVisited() != -1) {
          pi.resetVisited();
          pi.resetOrderVisited();
          tomodachi.addToRear(pi);
        }
      }
    }
  }
}