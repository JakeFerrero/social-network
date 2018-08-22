/**
 * 
 */
package test;

import junit.framework.TestCase;

import socialNetwork.Graph;
import socialNetwork.Person;

/**
 * @author Ferrero
 *
 */
public class GraphTest extends TestCase{
  
  Graph g;
  Person p1 = new Person("Jake");
  Person p2 = new Person("Elizabeth");
  Person p3 = new Person("Aruna");
  Person p4 = new Person("Mathias");
  Person p5 = new Person("Dan");
  Person p6 = new Person("Tyler");
  Person p7 = new Person("Christina");
  Person p8 = new Person("Josh");
  Person p9 = new Person("Joey");
  Person p10 = new Person("Tony");

  /**
   * @throws java.lang.Exception
   */
  public void setUp() throws Exception {
    g = new Graph();

    /*
    p1 = new Person("Jake");
    p2 = new Person("Elizabeth");
    p3 = new Person("Aruna");
    p4 = new Person("Mathias");
    p5 = new Person("Dan");
    p6 = new Person("Tyler");
    p7 = new Person("Christina");
    p8 = new Person("Josh");
    p9 = new Person("Joey");
    p10 = new Person("Tony");
    */
    
    /*g.add(p1.getName());
    g.add(p2.getName());
    g.add(p3.getName());
    g.add(p4.getName());
    g.add(p5.getName());
    g.add(p6.getName());
    g.add(p7.getName());
    g.add(p8.getName());
    g.add(p9.getName());
    g.add(p10.getName());
    */
  }

  public void testAdd() {
    g.add(p1);
    g.add(p2);
    g.add(p3);
    g.add(p4);
    g.add(p5);
    g.add(p6);
    g.add(p7);
    g.add(p8);
    g.add(p9);
    g.add(p10); 
    
    String[] s = {"Jake", "Elizabeth", "Aruna", "Mathias", "Dan", "Tyler", "Christina", "Josh",
                  "Joey", "Tony"};
    
    for(int i = 0; i < s.length; i++)
      assertEquals(s[i], g.find(s[i]).getName());   
  }

  public void testDiJakestra() {
    g.add(p1);
    g.add(p2);
    g.add(p3);
    g.add(p4);
    g.add(p5);
    /*g.add(p6.getName());
    g.add(p7.getName());
    g.add(p8.getName());
    g.add(p9.getName());
    g.add(p10.getName()); */
    
    p1.addFriend(p2);
    p1.addFriend(p3);
    p2.addFriend(p1);
    p2.addFriend(p4);
    p3.addFriend(p1);
    p3.addFriend(p4);
    p4.addFriend(p2);
    p4.addFriend(p3);
    p4.addFriend(p5);
    p5.addFriend(p4);
    
    //System.out.println(g.diJakestra(p1, p5));
    String s = "Jake\n" + "Elizabeth\n" + "Mathias\n" + "Dan\n";
    assertEquals(s, g.diJakestra(g.find(p1.getName()), g.find(p5.getName())));
  }
}
