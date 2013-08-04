/* DList1.java */

/**
 *  A DList1 is a mutable doubly-linked list.  (No sentinel, not
 *  circularly linked.)
 */

public class DList1 {

  /**
   *  head references the first node.
   *  tail references the last node.
   *
   *  DO NOT CHANGE THE FOLLOWING FIELD DECLARATIONS.
   */

  protected DListNode1 head;
  protected DListNode1 tail;
  protected long size;

  /* DList1 invariants:
   *  1)  head.prev == null.
   *  2)  tail.next == null.
   *  3)  For any DListNode1 x in a DList, if x.next == y and x.next != null,
   *      then y.prev == x.
   *  4)  For any DListNode1 x in a DList, if x.prev == y and x.prev != null,
   *      then y.next == x.
   *  5)  The tail can be accessed from the head by a sequence of "next"
   *      references.
   *  6)  size is the number of DListNode1s that can be accessed from the
   *      head by a sequence of "next" references.
   */

  /**
   *  DList1() constructor for an empty DList1.
   */
  public DList1() {
    head = null;
    tail = null;
    size = 0;
  }

  /**
   *  DList1() constructor for a one-node DList1.
   */
  public DList1(int a) {
    head = new DListNode1();
    tail = head;
    head.item = a;
    size = 1;
  }

  /**
   *  DList1() constructor for a two-node DList1.
   */
  public DList1(int a, int b) {
    head = new DListNode1();
    head.item = a;
    tail = new DListNode1();
    tail.item = b;
    head.next = tail;
    tail.prev = head;
    size = 2;
  }

  /**
   *  insertFront() inserts an item at the front of a DList1.
   */
  public void insertFront(int i) {
    // Your solution here.
  }

  /**
   *  removeFront() removes the first item (and node) from a DList1.  If the
   *  list is empty, do nothing.
   */
  public void removeFront() {
    // Your solution here.
  }

  /**
   *  toString() returns a String representation of this DList.
   *
   *  DO NOT CHANGE THIS METHOD.
   *
   *  @return a String representation of this DList.
   */
  public String toString() {
    String result = "[  ";
    DListNode1 current = head;
    while (current != null) {
      result = result + current.item + "  ";
      current = current.next;
    }
    return result + "]";
  }

  public static void main(String[] args) {
    // DO NOT CHANGE THE FOLLOWING CODE.

    DList1 l = new DList1();
    System.out.println("### TESTING insertFront ###\nEmpty list is " + l);

    l.insertFront(9);
    System.out.println("\nInserting 9 at front.\nList with 9 is " + l);
    if (l.head == null) {
      System.out.println("head is null.");
    } else {
      if (l.head.item != 9) {
        System.out.println("head.item is wrong.");
      }
      if (l.head.prev != null) {
        System.out.println("head.prev is wrong.");
      }
    }
    if (l.tail == null) {
      System.out.println("tail is null.");
    } else {
      if (l.tail.item != 9) {
        System.out.println("tail.item is wrong.");
      }
      if (l.tail.next != null) {
        System.out.println("tail.next is wrong.");
      }
    }
    if (l.size != 1) {
      System.out.println("size is wrong.");
    }

    l.insertFront(8);
    System.out.println("\nInserting 8 at front.\nList with 8 and 9 is " + l);
    if (l.head == null) {
      System.out.println("head is null.");
    } else {
      if (l.head.item != 8) {
        System.out.println("head.item is wrong.");
      }
      if (l.head.prev != null) {
        System.out.println("head.prev is wrong.");
      }
      if (l.head.next != l.tail) {
        System.out.println("head.next is wrong.");
      }
    }
    if (l.tail == null) {
      System.out.println("tail is null.");
    } else {
      if (l.tail.item != 9) {
        System.out.println("tail.item is wrong.");
      }
      if (l.tail.next != null) {
        System.out.println("tail.next is wrong.");
      }
      if (l.tail.prev != l.head) {
        System.out.println("tail.prev is wrong.");
      }
    }
    if (l.size != 2) {
      System.out.println("size is wrong.");
    }



    l = new DList1(1, 2);
    System.out.println("\n\n### TESTING removeFront ###\nList with 1 and 2 is "
                       + l);

    l.removeFront();
    System.out.println("\nRemoving front node.\nList with 2 is " + l);
    if (l.head.item != 2) {
      System.out.println("head.item is wrong.");
    }
    if (l.head.prev != null) {
      System.out.println("head.prev is wrong.");
    }
    if (l.tail.item != 2) {
      System.out.println("tail.item is wrong.");
    }
    if (l.tail.next != null) {
      System.out.println("tail.next is wrong.");
    }
    if (l.size != 1) {
      System.out.println("size is wrong.");
    }

    l.removeFront();
    System.out.println("\nRemoving front node.\nEmpty list is " + l);
    if (l.head != null) {
      System.out.println("head is wrong.");
    }
    if (l.tail != null) {
      System.out.println("tail is wrong.");
    }
    if (l.size != 0) {
      System.out.println("size is wrong.");
    }

    l.removeFront();
    System.out.println("\nRemoving front node.\nEmpty list is " + l);
    if (l.head != null) {
      System.out.println("head is wrong.");
    }
    if (l.tail != null) {
      System.out.println("tail is wrong.");
    }
    if (l.size != 0) {
      System.out.println("size is wrong.");
    }
  }

}
