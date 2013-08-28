/* ListNode.java */

package sortedlist;

/**
 *  ListNode is a class used internally by the List class.  Each node in a
 *  List is represented as a ListNode, with an item and a reference to the
 *  next node in the list.
 **/
class ListNode {
  Keyable item;
  ListNode next;

  /**
   *  Constructs a ListNode with item obj and next null.
   *  @param obj will be the item in the node.
   **/
  ListNode(Keyable obj) {
    item = obj;
    next = null;
  }

  /**
   *  Constructs a ListNode with item obj and next n.
   *  @param obj will be the item in the node.
   *  @param n will be the next ListNode in the list.
   **/
  ListNode(Keyable obj, ListNode n) {
    item = obj;
    next = n;
  }

  /**
   *  ptrTo() returns a reference to the node at the given position.  If
   *  position < 1 or position > the number of nodes in the list, returns
   *  null.  Assumes the list is acyclic.
   *  @return a reference to the node at position "position".
   */
  public ListNode ptrTo(int position) {
    if (position < 1) {
      return null;
    } else if (position == 1) {
      return this;
    } else if (next == null) {
      return null;
    } else {
      return next.ptrTo(position - 1);
    }
  }
}
