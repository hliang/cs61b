/* SList.java */

package list;

/**
 *  A SList is a mutable singly-linked list ADT.  Its implementation employs
 *  a tail reference.
 *
 *  DO NOT CHANGE THIS FILE.
 **/

public class SList extends List {

  /**
   *  (inherited)  size is the number of items in the list.
   *  head references the first node.
   *  tail references the last node.
   **/

  protected SListNode head;
  protected SListNode tail;

  /* SList invariants:
   *  1)  Either head == null and tail == null, or tail.next == null and the
   *      SListNode referenced by tail can be reached from the head by a
   *      sequence of zero or more "next" references.  This implies that the
   *      list is not circularly linked.
   *  2)  The "size" field is the number of SListNodes that can be accessed
   *      from head (including head itself) by a sequence of "next" references.
   *  3)  For any SListNode x in an SList l, x.myList = l.
   **/

  /**
   *  newNode() calls the SListNode constructor.  Use this method to allocate
   *  new SListNodes rather than calling the SListNode constructor directly.
   *  That way, only this method need be overridden if a subclass of SList
   *  wants to use a different kind of node.
   *
   *  @param item the item to store in the node.
   *  @param next the node following this node.
   **/
  protected SListNode newNode(Object item, SListNode next) {
    return new SListNode(item, this, next);
  }

  /**
   *  SList() constructs for an empty SList.
   **/
  public SList() {
    head = null;
    tail = null;
    size = 0;
  }

  /**
   *  insertFront() inserts an item at the front of this SList.
   *
   *  @param item is the item to be inserted.
   *
   *  Performance:  runs in O(1) time.
   **/
  public void insertFront(Object item) {
    head = newNode(item, head);
    if (size == 0) {
      tail = head;
    }
    size++;
  }

  /**
   *  insertBack() inserts an item at the back of this SList.
   *
   *  @param item is the item to be inserted.
   *
   *  Performance:  runs in O(1) time.
   **/
  public void insertBack(Object item) {
    if (head == null) {
      head = newNode(item, null);
      tail = head;
    } else {
      tail.next = newNode(item, null);
      tail = tail.next;
    }
    size++;
  }

  /**
   *  front() returns the node at the front of this SList.  If the SList is
   *  empty, return an "invalid" node--a node with the property that any
   *  attempt to use it will cause an exception.
   *
   *  @return a ListNode at the front of this SList.
   *
   *  Performance:  runs in O(1) time.
   */
  public ListNode front() {
    if (head == null) {
      // Create an invalid node.
      SListNode node = newNode(null, null);
      node.myList = null;
      return node;
    } else {
      return head;
    }
  }

  /**
   *  back() returns the node at the back of this SList.  If the SList is
   *  empty, return an "invalid" node--a node with the property that any
   *  attempt to use it will cause an exception.
   *
   *  @return a ListNode at the back of this SList.
   *
   *  Performance:  runs in O(1) time.
   */
  public ListNode back() {
    if (tail == null) {
      // Create an invalid node.
      SListNode node = newNode(null, null);
      node.myList = null;
      return node;
    } else {
      return tail;
    }
  }

  /**
   *  toString() returns a String representation of this SList.
   *
   *  @return a String representation of this SList.
   *
   *  Performance:  runs in O(n) time, where n is the length of the list.
   */
  public String toString() {
    String result = "[  ";
    SListNode current = head;
    while (current != null) {
      result = result + current.item + "  ";
      current = current.next;
    }
    return result + "]";
  }

  private static void testInvalidNode(ListNode p) {
    System.out.println("p.isValidNode() should be false: " + p.isValidNode());
    try {
      p.item();
      System.out.println("p.item() should throw an exception, but didn't.");
    } catch (InvalidNodeException lbe) {
      System.out.println("p.item() should throw an exception, and did.");
    }
    try {
      p.setItem(new Integer(0));
      System.out.println("p.setItem() should throw an exception, but didn't.");
    } catch (InvalidNodeException lbe) {
      System.out.println("p.setItem() should throw an exception, and did.");
    }
    try {
      p.next();
      System.out.println("p.next() should throw an exception, but didn't.");
    } catch (InvalidNodeException lbe) {
      System.out.println("p.next() should throw an exception, and did.");
    }
    try {
      p.prev();
      System.out.println("p.prev() should throw an exception, but didn't.");
    } catch (InvalidNodeException lbe) {
      System.out.println("p.prev() should throw an exception, and did.");
    }
    try {
      p.insertBefore(new Integer(1));
      System.out.println("p.insertBefore() should throw an exception, but " +
                         "didn't.");
    } catch (InvalidNodeException lbe) {
      System.out.println("p.insertBefore() should throw an exception, and did."
                         );
    }
    try {
      p.insertAfter(new Integer(1));
      System.out.println("p.insertAfter() should throw an exception, but " +
                         "didn't.");
    } catch (InvalidNodeException lbe) {
      System.out.println("p.insertAfter() should throw an exception, and did."
                         );
    }
    try {
      p.remove();
      System.out.println("p.remove() should throw an exception, but didn't.");
    } catch (InvalidNodeException lbe) {
      System.out.println("p.remove() should throw an exception, and did.");
    }
  }

  private static void testEmpty() {
    List l = new SList();
    System.out.println("An empty list should be [  ]: " + l);
    System.out.println("l.isEmpty() should be true: " + l.isEmpty());
    System.out.println("l.length() should be 0: " + l.length());
    System.out.println("Finding front node p of l.");
    ListNode p = l.front();
    testInvalidNode(p);
    System.out.println("Finding back node p of l.");
    p = l.back();
    testInvalidNode(p);
    l.insertFront(new Integer(10));
    System.out.println("l after insertFront(10) should be [  10  ]: " + l);
  }

  public static void main(String[] argv) {
    testEmpty();
    List l = new SList();
    l.insertFront(new Integer(3));
    l.insertFront(new Integer(2));
    l.insertFront(new Integer(1));
    System.out.println("l is a list of 3 elements: " + l);
    try {
      ListNode n;
      int i = 1;
      for (n = l.front(); n.isValidNode(); n = n.next()) {
	System.out.println("n.item() should be " + i + ": " + n.item());
        n.setItem(new Integer(((Integer) n.item()).intValue() * 2));
	System.out.println("n.item() should be " + 2 * i + ": " + n.item());
	i++;
      }
      System.out.println("After doubling all elements of l: " + l);
      testInvalidNode(n);

      i = 6;
      for (n = l.back(); n.isValidNode(); n = n.prev()) {
	System.out.println("n.item() should be " + i + ": " + n.item());
	n.setItem(new Integer(((Integer) n.item()).intValue() * 2));
	System.out.println("n.item() should be " + 2 * i + ": " + n.item());
	i = i - 2;
      }
      System.out.println("After doubling all elements of l again: " + l);
      testInvalidNode(n);

      n = l.front().next();
      System.out.println("Removing middle element (8) of l: " + n.item());
      n.remove();
      System.out.println("l is now: " + l);
      testInvalidNode(n);    
      n = l.back();
      System.out.println("Removing end element (12) of l: " + n.item());
      n.remove();
      System.out.println("l is now: " + l);
      testInvalidNode(n);    

      n = l.front();
      System.out.println("Removing first element (4) of l: " + n.item());
      n.remove();
      System.out.println("l is now: " + l);
      testInvalidNode(n);    
    } catch (InvalidNodeException lbe) {
      System.err.println ("Caught InvalidNodeException that should not happen."
                          );
      System.err.println ("Aborting the testing code.");
    }
  }
}
