/* LockDList.java */

package list;

public class LockDList extends DList {

  // protected LockDListNode newNode(Object item, LockDListNode prev, LockDListNode next) {
  // the above code will not work!!
  // prev and next must use "DListNode" instead of "LockDListNode".
  protected LockDListNode newNode(Object item, DListNode prev, DListNode next) {
    return new LockDListNode(item, prev, next);
  }

  public void lockNode(DListNode node) {
      ((LockDListNode)node).isLocked = true;
  }

  public void remove(DListNode node) {
    // Your solution here.
    if (((LockDListNode)node).isLocked == false) {
        super.remove(node);
    }
  }

  public static void main(String[] argv) {
/*
	System.out.println("Testing Constructor");
	LockDList testList = new LockDList();
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
	testList.remove((LockDListNode)testingNode);
	System.out.println("Should be [ 5 10 40 3 ]: " + testList);
	System.out.println("Length should be 4:" + testList.length());

*/
	System.out.println("Testing Constructor");
	LockDList testList = new LockDList();
	System.out.println("Is empty? Should be true: " + testList.isEmpty());
	System.out.println("Should be zero length: " + testList.length());

	System.out.println("\nTesting insertFront");
	testList.insertFront(1);
	System.out.println("Is empty? Should be false: " + testList.isEmpty());
	System.out.println("Should be one length: " + testList.length());
	System.out.println("Should be [ 1 ]: " + testList);
	testList.insertFront(3);
	testList.insertFront(6);
	testList.insertFront(9);
	System.out.println(testList);

	LockDListNode currNode = (LockDListNode) ((DList) testList).front();
	currNode = (LockDListNode) testList.next(currNode);
	currNode = (LockDListNode) testList.next(currNode);
	//testList.lockNode(currNode);
	testList.remove(currNode);

	System.out.println(testList);


        LockDList l = new LockDList();
		System.out.println("\n\n###Testing insertFront ###\nEmpty list is" + l);
		l.insertFront(9);
		System.out.println("\nInserting 9 at front. \nList with 9 is " + l);
		l.insertFront(8);
		l.insertFront(7);
		System.out.println("\nInserting 7, 8 at the front. \nList with 7, 8, 9 is " + l);
		l.insertAfter(6, l.head);
		System.out.println("\nInserting 6 after head. nList with 6, 7, 8, 9 is "+l);
		l.remove(l.head.next);
		System.out.println("Removed head.next, should return a list of 7, 8, 9. nList with 7, 8, 9 is " + l);
		LockDList m = new LockDList();
		m.insertFront(9);
		m.insertFront(8);
		m.insertFront(7);
		System.out.println("\nInserting 7, 8, 9 at the front. List with 7, 8, 9 is " + m);
		m.lockNode(m.head.next);
		m.remove(m.head.next);
		System.out.println("Locked the first element of the DList, should not be removed. List with 7, 8, 9 is " + m);
  }
}
