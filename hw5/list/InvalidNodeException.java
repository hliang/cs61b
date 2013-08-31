/* InvalidNodeException.java */

package list;

/**
 *  Implements an Exception that signals an attempt to use an invalid ListNode.
 */

public class InvalidNodeException extends Exception {
  protected InvalidNodeException() {
    super();
  }

  protected InvalidNodeException(String s) {
    super(s);
  }
}
