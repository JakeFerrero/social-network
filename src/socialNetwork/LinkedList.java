package socialNetwork;

/**
 * This class is our implementation of a linked list data
 * structure to be used by other classes within our program.
 * @author Jake Ferrero (jaferrer)
 */
public class LinkedList<E> {
  /** Beginning node of the list. */
  private Node head;
  
  /** Size of the list. */
  private int size;
  
  /**
   * The constructor for the class, it initializes fields and checks
   * to make sure they are valid values.
   */
  public LinkedList() {
    head = null;
    size = 0;
  }
  
  /**
   * Adds a Node containing a generic value to the end of the list.
   * @param value Value of the node to add.
   */
  public void addToRear(E value) {
    Node temp = new Node(value);
    Node current = head;
    
    // Empty list case
    if (current == null) {
      head = temp;
      size++;
    }
    else {
      while (current.next() != null) {
        current = current.next();
      }
    
      current.setNext(temp);
      size++;
    }
  }
  
  /**
   * Adds a Node containing a generic value to the provided index.
   * @param value Value of the added node.
   * @param index Index to add the node at.
   */
  public void add(E value, int index) {
    if (index < 0 || index > size()) {
      throw new IndexOutOfBoundsException();
    }
    
    Node temp = new Node(value);
    Node current = head;

    // adding to the back of list
    if( index == size() ) {
      addToRear(value);
      return;
    }

    // adding to front of list
    if (index == 0) {
      temp.setNext(current);
      head = temp;
      size++;
    }
    else {
      for (int i = 1; i < index; i++) {
        current = current.next();
      }
      temp.setNext(current.next());
      current.setNext(temp);
      size++;
    }
  }
  
  /**
   * Gets the value of the Node at the given index.
   * @param index Index of the Node to get the value from.
   * @return The value of the Node at the provided index.
   */
  public E get(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException();
    }
    
    Node current = head;
    for (int i = 0; i < index; i++) {
      // If the next node is null
      if (current.next() == null) {
        return null;
      } else {
        current = current.next();
      }
    }
    return current.value();
  }
  
  /**
   * Removes the Node at a given index.
   * @param index Index of the Node to remove.
   * @return The value of the Node that was removed.
   */
  public E remove(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException();
    }
    
    Node current = head;
    E oldValue;
    
    if (index == 0) {
      oldValue = current.value();
      head = current.next();
      current.setNext(null);
      size--;
      return oldValue;
    } else {
      for (int i = 1; i < index; i++) {
        if (current.next == null) {
          return null;
        } else {
          current = current.next();
        }
      }
      oldValue = current.next().value();
      current.setNext(current.next().next());
      size--;
      return oldValue;
    }
  }
  
  /**
   * Size of the Linked List.
   * @return Size of the list.
   */
  public int size() {
    return this.size;
  }
  
  /**
   * Returns true if the list is empty, false otherwise.
   * @return True if list is empty.
   */
  public boolean isEmpty() {
    return head == null;
  }
  
  /**
   * Method used to print a string representation of the Linked List.  Used
   * only for testing purposes.
   * @return String representation of the list.
   */
  public String toString() {
    String output = "";
    Node current = head;
    while (current != null) {
      output += "[" + current.value().toString() + "]";
      current = current.next();
    }
    return output;
  }
  
  /**
   * Internal class used only by Linked List that defines the
   * implementation of Nodes for the Linked List.
   * @author Jake Ferrero (jaferrer)
   */
  private class Node {
    /** Node that follows the current one. */
    Node next;
    
    /** value of Node. */
    E value;

    /**
     * The constructor for the class, it initializes fields and checks
     * to make sure they are valid values.
     * @param value Initial value of the Node.
     */
    public Node(E value) {
      this.next = null;
      this.value = value;
    }

    /**
     * The getter method for the value of the current Node.
     * @return Generic value of the current Node.
     */
    public E value() {
      return value;
    }

    /**
     * Method that gets what the current Node points to.
     * @return The Node that follows the current one.
     */
    public Node next() {
      return next;
    }

    /**
     * Sets the current node's pointer to the passed in Node.
     * @param next Node to set the current's pointer to.
     */
    public void setNext(Node next) {
      this.next = next;
    }
  } 
}