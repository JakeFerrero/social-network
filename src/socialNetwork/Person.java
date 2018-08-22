package socialNetwork;

/**
 * This class constructs a Person object.
 */
public class Person {
  /** Name of person */
  String name;
  /** LinkedList of friends of a person */
  LinkedList<Person> friends;
  /** Popularity of a person */
  double popularity;
  /** How many times the person has been visited */
  int visited;
  /** Position that person is visited */
  int orderVisited;
  /** Person is added to graph*/
  int added;
  /** whether or not person is in component*/
  boolean inComponent;

  /**
   * Gets person's name
   * @return person's name
   */
  public String getName() { return name; }

  /**
   * Gets friends of person
   * @return linked list of friends
   */
  public LinkedList<Person> getFriends() { return friends; }

  /**
   * Adds friend to linked list of friends
   * @param p person to add to linked list
   */
  public void addFriend( Person p ) {
    friends.addToRear(p);
  }

  /**
   * Constructs Person object
   * @param name name of person
   */
  public Person(String name) {
    this.name = name;
    this.visited = -1;
    this.orderVisited = -1;
    friends = new LinkedList<Person>();
    this.added = 0;
    this.inComponent = false;
  }

  /**
   * sets popularity
   * @param popularity value of person's popularity
   */
  public void setPopularity (double popularity) {this.popularity = popularity;}

  /**
   * gets popularity
   * @return popularity
   */
  public double getPopularity() {return popularity;}

  /**
   * Gets number of times person has been visited
   * @return linked list of friends
   */
  public int getVisited() { return visited; }

  /**
   * sets value of visited
   * @param visited value visited will be set to
   */
  public void setVisited( int visited ) { this.visited = visited; }

  /**
   * Resets visited to -1
   */
  public void resetVisited() { this.visited = -1; }

  /**
   * gets order visited by algorithm
   * @return order visited
   */
  public int getOrderVisited() { return orderVisited; }

  /**
   * sets order visited by algorithm
   * @param orderVisited order visited
   */
  public void setOrderVisited( int orderVisited ) { this.orderVisited = orderVisited; }

  /**
   * resets order visited to -1
   */
  public void resetOrderVisited() { this.orderVisited = -1; }

  /**
   * gets added
   * @return added
   */
  public int getAdded() { return added; }

  /**
   * sets added
   * @param added added
   */
  public void setAdded(int added) { this.added = added; }

  /**
   * gets inComponent
   * @return inComponent
   */
  public boolean isInComponent() {return inComponent;}

  /**
   * sets inComponent
   * @param inComponent value of inComponent
   */
  public void setInComponent(boolean inComponent) {this.inComponent = inComponent;}
}