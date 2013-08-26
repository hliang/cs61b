/* LockDListNode.java */

package list;

/**
 *  A LockDListNode is a node in a DList (doubly-linked list).
 */

public class LockDListNode extends DListNode {

  protected boolean isLocked;

  LockDListNode(Object i, DListNode p, DListNode n) {
    super(i, p, n);
    isLocked = false;
  }
}
