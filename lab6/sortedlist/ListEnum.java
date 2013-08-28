/* ListEnum.java */

package sortedlist;

import java.util.Enumeration;

/**
 *  The ListEnum class implements an Enumeration for singly-linked lists.
 *  ListEnum objects are mutable. 
 *  @author Kathy Yelick
 **/

public class ListEnum implements Enumeration {
  private ListNode trav;  

  /**
   *  Creates a new enumeration for the elements linked with ListNodes 
   *  starting with l.  Requires that there are no cycles in the list.
   */
  public ListEnum( ListNode l ) {
    trav = l;
  }

  /**
   *  Tests if this enumeration contains more elements.
   *  @return true if this enumeration contains more elements; false otherwise
   */
  public boolean hasMoreElements() {
    return (trav != null);
  }

  /**
   *  Returns the next element of this enumeration.
   *  Modifies the enumeration to move the enumeration past the returned 
   *  element of the list. 
   * @return the next element of this enumeration.
   */
  public Object nextElement() {
    Object retItem = trav.item;
    trav = trav.next;
    return retItem;
  }
}
