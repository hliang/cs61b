/* SListNode.java */

package list;

/**
 *  An SListNode is a mutable node in an SList (singly-linked list).
 **/

public class SListNode extends ListNode {

  /**
   *  (inherited)  item references the item stored in the current node.
   *  (inherited)  myList references the List that contains this node.
   *  next references the next node in the SList.
   *
   *  DO NOT CHANGE THE FOLLOWING FIELD DECLARATIONS.
   **/

  protected SListNode next;

  /**
   *  SListNode() constructor.
   *  @param i the item to store in the node.
   *  @param l the list this node is in.
   *  @param n the node following this node.
   */
  SListNode(Object i, SList l, SListNode n) {
    item = i;
    myList = l;
    next = n;
  }

  /**
   *  next() returns the node following this node.  If this node is invalid,
   *  throws an exception.
   *
   *  @return the node following this node.
   *  @exception InvalidNodeException if this node is not valid.
   *
   *  Performance:  runs in O(1) time.
   */
  public ListNode next() throws InvalidNodeException {
    if (!isValidNode()) {
      throw new InvalidNodeException("next() called on invalid node");
    }
    if (next == null) {
      // Create an invalid node.
      SListNode node = ((SList) myList).newNode(null, null);
      node.myList = null;
      return node;
    } else {
      return next;
    }
  }

  /**
   *  prev() returns the node preceding this node.  If this node is invalid,
   *  throws an exception.
   *
   *  @param node the node whose predecessor is sought.
   *  @return the node preceding this node.
   *  @exception InvalidNodeException if this node is not valid.
   *
   *  Performance:  runs in O(this.size) time.
   */
  public ListNode prev() throws InvalidNodeException {
    if (!isValidNode()) {
      throw new InvalidNodeException("prev() called on invalid node");
    }
    SListNode prev = ((SList) myList).head;
    if (prev == this) {
      // Create an invalid node.
      prev = ((SList) myList).newNode(null, null);
      prev.myList = null;
    } else {
      while (prev.next != this) {
        prev = prev.next;
      }
    }
    return prev;
  }

  /**
   *  insertAfter() inserts an item immediately following this node.  If this
   *  node is invalid, throws an exception.
   *
   *  @param item the item to be inserted.
   *  @exception InvalidNodeException if this node is not valid.
   *
   *  Performance:  runs in O(1) time.
   */
  public void insertAfter(Object item) throws InvalidNodeException {
    if (!isValidNode()) {
      throw new InvalidNodeException("insertAfter() called on invalid node");
    }
    SListNode newNode = ((SList) myList).newNode(item, next);
    if (next == null) {
      ((SList) myList).tail = newNode;
    }
    next = newNode;
    myList.size++;
  }

  /**
   *  insertBefore() inserts an item immediately preceding this node.  If this
   *  node is invalid, throws an exception.
   *
   *  @param item the item to be inserted.
   *  @exception InvalidNodeException if this node is not valid.
   *
   *  Performance:  runs in O(this.size) time.
   */
  public void insertBefore(Object item) throws InvalidNodeException {
    if (!isValidNode()) {
      throw new InvalidNodeException("insertBefore() called on invalid node");
    }
    SListNode newNode = ((SList) myList).newNode(item, this);
    if (this == ((SList) myList).head) {
      ((SList) myList).head = newNode;
    } else {
      SListNode prev = (SListNode) prev();
      prev.next = newNode;
    }
    myList.size++;
  }

  /**
   *  remove() removes this node from its SList.  If this node is invalid,
   *  throws an exception.
   *
   *  @exception InvalidNodeException if this node is not valid.
   *
   *  Performance:  runs in O(this.size) time.
   */
  public void remove() throws InvalidNodeException {
    if (!isValidNode()) {
      throw new InvalidNodeException("remove() called on invalid node");
    }
    if (this == ((SList) myList).head) {
      ((SList) myList).head = next;
      if (next == null) {
        ((SList) myList).tail = null;
      }
    } else {
      SListNode prev = (SListNode) prev();
      prev.next = next;
      if (next == null) {
        ((SList) myList).tail = prev;
      }
    }
    myList.size--;

    // Make this node an invalid node, so it cannot be used to corrupt myList.
    myList = null;
    // Set other reference to null to improve garbage collection.
    next = null;
  }

}
