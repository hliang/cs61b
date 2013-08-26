/* DList.java */

package list;

/**
 *  A DList is a mutable doubly-linked list ADT.  Its implementation is
 *  circularly-linked and employs a sentinel (dummy) node at the head
 *  of the list.
 *
 *  DO NOT CHANGE ANY METHOD PROTOTYPES IN THIS FILE.
 */

public class DList {

  /**
   *  head references the sentinel node.
   *  size is the number of items in the list.  (The sentinel node does not
   *       store an item.)
   *
   *  DO NOT CHANGE THE FOLLOWING FIELD DECLARATIONS.
   */

  protected DListNode head;
  protected int size;

  /* DList invariants:
   *  1)  head != null.
   *  2)  For any DListNode x in a DList, x.next != null.
   *  3)  For any DListNode x in a DList, x.prev != null.
   *  4)  For any DListNode x in a DList, if x.next == y, then y.prev == x.
   *  5)  For any DListNode x in a DList, if x.prev == y, then y.next == x.
   *  6)  size is the number of DListNodes, NOT COUNTING the sentinel,
   *      that can be accessed from the sentinel (head) by a sequence of
   *      "next" references.
   */

  /**
   *  newNode() calls the DListNode constructor.  Use this class to allocate
   *  new DListNodes rather than calling the DListNode constructor directly.
   *  That way, only this method needs to be overridden if a subclass of DList
   *  wants to use a different kind of node.
   *  @param item the item to store in the node.
   *  @param prev the node previous to this node.
   *  @param next the node following this node.
   */
  protected DListNode newNode(Object item, DListNode prev, DListNode next) {
    return new DListNode(item, prev, next);
  }

  /**
   *  DList() constructor for an empty DList.
   */
  public DList() {
    //  Your solution here.
    head = newNode(null, head, head);
    head.prev = head;
    head.next = head;
    size = 0;
  }

  /**
   *  isEmpty() returns true if this DList is empty, false otherwise.
   *  @return true if this DList is empty, false otherwise. 
   *  Performance:  runs in O(1) time.
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /** 
   *  length() returns the length of this DList. 
   *  @return the length of this DList.
   *  Performance:  runs in O(1) time.
   */
  public int length() {
    return size;
  }

  /**
   *  insertFront() inserts an item at the front of this DList.
   *  @param item is the item to be inserted.
   *  Performance:  runs in O(1) time.
   */
  public void insertFront(Object item) {
    // Your solution here.
    head.next.prev = newNode(item, head, head.next);
    head.next = head.next.prev;
    size++;
  }

  /**
   *  insertBack() inserts an item at the back of this DList.
   *  @param item is the item to be inserted.
   *  Performance:  runs in O(1) time.
   */
  public void insertBack(Object item) {
    // Your solution here.
    head.prev.next = newNode(item, head.prev, head);
    head.prev = head.prev.next;
    size++;
  }

  /**
   *  front() returns the node at the front of this DList.  If the DList is
   *  empty, return null.
   *
   *  Do NOT return the sentinel under any circumstances!
   *
   *  @return the node at the front of this DList.
   *  Performance:  runs in O(1) time.
   */
  public DListNode front() {
    // Your solution here.
    if (isEmpty()) {
        return null;
    }
    return head.next;
  }

  /**
   *  back() returns the node at the back of this DList.  If the DList is
   *  empty, return null.
   *
   *  Do NOT return the sentinel under any circumstances!
   *
   *  @return the node at the back of this DList.
   *  Performance:  runs in O(1) time.
   */
  public DListNode back() {
    // Your solution here.
    if (isEmpty()) {
        return null;
    }
    return head.prev;
  }

  /**
   *  next() returns the node following "node" in this DList.  If "node" is
   *  null, or "node" is the last node in this DList, return null.
   *
   *  Do NOT return the sentinel under any circumstances!
   *
   *  @param node the node whose successor is sought.
   *  @return the node following "node".
   *  Performance:  runs in O(1) time.
   */
  public DListNode next(DListNode node) {
    // Your solution here.
    if (node == null || node.next == head) {
        return null;
    }
    return node.next;
  }

  /**
   *  prev() returns the node prior to "node" in this DList.  If "node" is
   *  null, or "node" is the first node in this DList, return null.
   *
   *  Do NOT return the sentinel under any circumstances!
   *
   *  @param node the node whose predecessor is sought.
   *  @return the node prior to "node".
   *  Performance:  runs in O(1) time.
   */
  public DListNode prev(DListNode node) {
    // Your solution here.
    if (node == null || node.prev == head) {
        return null;
    }
    return node.prev;
  }

  /**
   *  insertAfter() inserts an item in this DList immediately following "node".
   *  If "node" is null, do nothing.
   *  @param item the item to be inserted.
   *  @param node the node to insert the item after.
   *  Performance:  runs in O(1) time.
   */
  public void insertAfter(Object item, DListNode node) {
    // Your solution here.
    if (node != null) {
      node.next.prev = newNode(item, node, node.next);;
      node.next = node.next.prev;
      size++;
    }
  }

  /**
   *  insertBefore() inserts an item in this DList immediately before "node".
   *  If "node" is null, do nothing.
   *  @param item the item to be inserted.
   *  @param node the node to insert the item before.
   *  Performance:  runs in O(1) time.
   */
  public void insertBefore(Object item, DListNode node) {
    // Your solution here.
    if (node != null) {
      node.prev.next = newNode(item, node.prev, node);
      node.prev = node.prev.next;
      size++;
    }
  }

  /**
   *  remove() removes "node" from this DList.  If "node" is null, do nothing.
   *  Performance:  runs in O(1) time.
   */
  public void remove(DListNode node) {
    // Your solution here.
    if (node != null) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }
  }

  /**
   *  toString() returns a String representation of this DList.
   *
   *  DO NOT CHANGE THIS METHOD.
   *
   *  @return a String representation of this DList.
   *  Performance:  runs in O(n) time, where n is the length of the list.
   */
  public String toString() {
    String result = "[  ";
    DListNode current = head.next;
    while (current != head) {
      result = result + current.item + "  ";
      current = current.next;
    }
    return result + "]";
  }

  public static void main(String[] argv) {
	System.out.println("Testing Constructor");
	DList testList = new DList();
	System.out.println("Is empty? Should be true: " + testList.isEmpty());
	System.out.println("Should be zero length: " + testList.length());
	System.out.println("Should be [  ]: " + testList);

	System.out.println("\nTesting insertFront");
	testList.insertFront(1);
	System.out.println("Is empty? Should be false: " + testList.isEmpty());
	System.out.println("Should be one length: " + testList.length());
	System.out.println("Should be [ 1 ]: " + testList);

	System.out.println("\nTesting insertBack");
	testList.insertBack(3);
	System.out.println("Is empty? Should be false: " + testList.isEmpty());
	System.out.println("Should be two length: " + testList.length());
	System.out.println("Should be [ 1 3 ]: " + testList);

	System.out.println("\nTesting front()");
	System.out.println("This should print out 1: " + testList.front().item);

	System.out.println("\nTesting back()");
	System.out.println("This should print out 3: " + testList.back().item);

	System.out.println("\nTesting next method");
	testList.insertFront(5);
	System.out.println("Should be [ 5 1 3 ]: " + testList);
	DListNode testingNode = testList.next(testList.front());
	System.out.println("This should print out 1: " + testingNode.item);
	testingNode = testList.next(testingNode);
	System.out.println("This should print out 3: " + testingNode.item);

	System.out.println("\nTesting prev method");
	testingNode = testList.prev(testingNode);
	System.out.println("This should print out 1: " + testingNode.item);

	System.out.println("\nTesting insertBefore");
	testList.insertBefore(10, testingNode);
	System.out.println("Should print out [ 5 10 1 3 ]: " + testList);

	System.out.println("\nTesting insertAfter");
	testList.insertAfter(40, testingNode);
	System.out.println("Should be [ 5 10 1 40 3 ]: " + testList);

	System.out.println("\nRemoving node");
	testList.remove(testingNode);
	System.out.println("Should be [ 5 10 40 3 ]: " + testList);
	System.out.println(testList.length());

        DList l = new DList();
		System.out.println("\n\n###Testing insertFront ###\nEmpty list is" + l);
		l.insertFront(9);
		System.out.println("\nInserting 9 at front. \nList with 9 is " + l);
		l.insertFront(8);
		l.insertFront(7);
		System.out.println("\nInserting 7, 8 at the front. \nList with 7, 8, 9 is " + l);
		l.insertAfter(6, l.head);
		System.out.println("\nInserting 6 after head. nList with 6, 7, 8, 9 is "+l);
		l.remove(l.head.next);
		System.out.println("\nRemoved head.next, should return a list of 7, 8, 9. nList with 7, 8, 9 is " + l);
        /*
		LockDList m = new LockDList();
		m.insertFront(9);
		m.insertFront(8);
		m.insertFront(7);
		System.out.println("\nInserting 7, 8, 9 at the front. List with 7, 8, 9 is " + m);
		m.lockNode(m.head.next);
		m.remove(m.head.next);
		System.out.println("Locked the first element of the DList, should not be removed. List with 7, 8, 9 is " + m);
        */
  }
}
