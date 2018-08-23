package socialNetwork;

import java.io.File;
import java.util.Scanner;

public class SocialNetwork {
  /**

   o Valid Queries:
     - isfriend personA personB
       function: Is personA friends with personB?
       output: yes / no

     - mutual personA personB
       function: Print out the mutual friends between personA and personB
       output: all their names one per line, If there are no mutual acquaintances just print the $

     - relation personA personB
       function: find the shortest sequence of friends between A and B ( the shortest path in the graph between nodes representing A and B)
       output: print the names of all the friends on the path in order including A and B (at beginning and end), again one name per line

     - notconnected
       function: Report how many pairs of people are not connected in the social network
         For all pairs {A, B}in the social network, A  is not connected to B if there is no path in the social network between A and B.
       output: the number of such pairs (followed by a $).

     - popular
       function: Report all the most popular people in the social network
   */
  public static void main(String[] args) {
    // Create instances
    File in = new File(args[0]);
    Wrapper wrap = new Wrapper(in);
    System.out.println("$");

    Scanner console = new Scanner(System.in);
    while( console.hasNextLine() ) {
      Scanner line = new Scanner(console.nextLine());

      if ( !line.hasNext() ) continue;
      String command = line.next();
      if(command.equals("quit")) System.exit(0);

      if(command.equals("isfriend")) {
        String eval = wrap.isFriend(line.next(), line.next()) ? "yes" : "no";
        System.out.println(eval + "\n$");
      } else if(command.equals("mutual")) {
        System.out.println(wrap.mutualFriends(line.next(), line.next()) + "$");
      } else if(command.equals("relation")) {
        System.out.println(wrap.relation(line.next(), line.next()) + "$");
      } else if(command.equals("notconnected")) {
        System.out.println(wrap.notConnected() + "\n$");
      } else if(command.equals("popular")) {
        System.out.println(wrap.computePopular() + "$");
      } else {
        System.out.println("Invalid command: " + command );
      }
    }

    /**
    // Read in commands
    Scanner console = new Scanner(System.in);
    Scanner line = new Scanner(console.nextLine());

    String command = line.next();

    while( !command.equals("quit") ) {

      if(command.equals("isfriend")) {
        String eval = wrap.isFriend(line.next(), line.next()) ? "yes" : "no";
        System.out.println(eval + "\n$");
      } else if(command.equals("mutual")) {
        System.out.println(wrap.mutualFriends(line.next(), line.next()) + "$");
      } else if(command.equals("relation")) {
        System.out.println(wrap.relation(line.next(), line.next()) + "$");
      } else if(command.equals("notconnected")) {
        System.out.println(wrap.notConnected() + "$");
      } else if(command.equals("popular")) {
        System.out.println(wrap.computePopular() + "$");
      } else {
        System.out.println("Invalid command: " + command );
      }

      line = new Scanner(console.nextLine());
      command = line.next();
    }
     */
  }
}
