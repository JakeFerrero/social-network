# Social Network
A Java application that simulates a basic social network using Dijkstra's algorithm, breadth first search,
and a shortest path algorithm. A user can check whether two people are fiends, whether one person is a mutual
firend with another, whether two people are connected at all, and whether or not someone is popular based
on the number of friends they have.

## Usage
From the top-level directory:
```
java socialNetwork.SocialNetwork <input>
```
Where \<input\> contains names (seperated by newlines). Then a '$', then lines containing two names side-by-side (seperated by a space), representing a relationship between two people. For an example input file, see sampleSocialNetwork/sample.txt. The input file is needed in order to generate the actual "social network."

Once the application is started, a '$' will be present, letting the user know the app is ready for input. The following are valid queries:

* isfriend personA personB
  * function: Is personA friends with personB?
  * output: yes / no<
* mutual personA personB
  * function: Print out the mutual friends between personA and personB
  * output: all their names one per line, If there are no mutual acquaintances just print the $
* relation personA personB
  * function: find the shortest sequence of friends between A and B ( the shortest path in the graph between nodes representing A and B)
  * output: print the names of all the friends on the path in order including A and B (at beginning and end), again one name per line
* notconnected
  * function: Report how many pairs of people are not connected in the social network
  * <i>For all pairs {A, B}in the social network, A  is not connected to B if there is no path in the social network between A and B.</i>
  * output: the number of such pairs (followed by a $).
* popular
  * function: Report all the most popular people in the social network
