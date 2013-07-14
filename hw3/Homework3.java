/* Homework3.java */

public class Homework3 {

  /**
   *  smoosh() takes an array of ints.  On completion the array contains
   *  the same numbers, but wherever the array had two or more consecutive
   *  duplicate numbers, they are replaced by one copy of the number.  Hence,
   *  after smoosh() is done, no two consecutive numbers in the array are the
   *  same.
   *
   *  Any unused elements at the end of the array are set to -1.
   *
   *  For example, if the input array is [ 0 0 0 0 1 1 0 0 0 3 3 3 1 1 0 ],
   *  it reads [ 0 1 0 3 1 0 -1 -1 -1 -1 -1 -1 -1 -1 -1 ] after smoosh()
   *  completes.
   *
   *  @param ints the input array.
   **/

  public static void smoosh(int[] ints) {
    // Fill in your solution here.  (Ours is fourteen lines long, not counting
    // blank lines or lines already present in this file.)
  }

  /**
   *  stringInts() converts an array of ints to a String.
   *  @return a String representation of the array.
   **/

  private static String stringInts(int[] ints) {
    String s = "[  ";
    for (int i = 0; i < ints.length; i++) {
      s = s + Integer.toString(ints[i]) + "  ";
    }
    return s + "]";
  }

  /**
   *  main() runs test cases on your smoosh and squish methods.  Prints summary
   *  information on basic operations and halts with an error (and a stack
   *  trace) if any of the tests fail.
   **/

  public static void main(String[] args) {
    String result;
    int i;


    System.out.println("Let's smoosh arrays!\n");

    int[] test1 = {3, 7, 7, 7, 4, 5, 5, 2, 0, 8, 8, 8, 8, 5};
    System.out.println("smooshing " + stringInts(test1) + ":");
    smoosh(test1);
    result = stringInts(test1);
    System.out.println(result);
    TestHelper.verify(result.equals(
            "[  3  7  4  5  2  0  8  5  -1  -1  -1  -1  -1  -1  ]"),
                      "BAD SMOOSH!!!  No cookie.");

    int[] test2 = {6, 6, 6, 6, 6, 3, 6, 3, 6, 3, 3, 3, 3, 3, 3};
    System.out.println("smooshing " + stringInts(test2) + ":");
    smoosh(test2);
    result = stringInts(test2);
    System.out.println(result);
    TestHelper.verify(result.equals(
            "[  6  3  6  3  6  3  -1  -1  -1  -1  -1  -1  -1  -1  -1  ]"),
                      "BAD SMOOSH!!!  No cookie.");

    int[] test3 = {4, 4, 4, 4, 4};
    System.out.println("smooshing " + stringInts(test3) + ":");
    smoosh(test3);
    result = stringInts(test3);
    System.out.println(result);
    TestHelper.verify(result.equals("[  4  -1  -1  -1  -1  ]"),
                      "BAD SMOOSH!!!  No cookie.");

    int[] test4 = {0, 1, 2, 3, 4, 5, 6};
    System.out.println("smooshing " + stringInts(test4) + ":");
    smoosh(test4);
    result = stringInts(test4);
    System.out.println(result);
    TestHelper.verify(result.equals("[  0  1  2  3  4  5  6  ]"),
                      "BAD SMOOSH!!!  No cookie.");


    System.out.println("\nLet's squish linked lists!\n");

    int[] test5 = {3, 7, 7, 7, 4, 5, 5, 2, 0, 8, 8, 8, 8, 5};
    SList list5 = new SList();
    for (i = 0; i < test5.length; i++) {
      list5.insertEnd(new Integer(test5[i]));
    }
    System.out.println("squishing " + list5.toString() + ":");
    list5.squish();
    result = list5.toString();
    System.out.println(result);
    TestHelper.verify(result.equals("[  3  7  4  5  2  0  8  5  ]"),
                      "BAD SQUISH!!!  No biscuit.");

    int[] test6 = {6, 6, 6, 6, 6, 3, 6, 3, 6, 3, 3, 3, 3, 3, 3};
    SList list6 = new SList();
    for (i = 0; i < test6.length; i++) {
      list6.insertEnd(new Integer(test6[i]));
    }
    System.out.println("squishing " + list6.toString() + ":");
    list6.squish();
    result = list6.toString();
    System.out.println(result);
    TestHelper.verify(result.equals("[  6  3  6  3  6  3  ]"),
                      "BAD SQUISH!!!  No biscuit.");

    int[] test7 = {4, 4, 4, 4, 4};
    SList list7 = new SList();
    for (i = 0; i < test7.length; i++) {
      list7.insertEnd(new Integer(test7[i]));
    }
    System.out.println("squishing " + list7.toString() + ":");
    list7.squish();
    result = list7.toString();
    System.out.println(result);
    TestHelper.verify(result.equals("[  4  ]"),
                      "BAD SQUISH!!!  No biscuit.");

    int[] test8 = {0, 1, 2, 3, 4, 5, 6};
    SList list8 = new SList();
    for (i = 0; i < test8.length; i++) {
      list8.insertEnd(new Integer(test8[i]));
    }
    System.out.println("squishing " + list8.toString() + ":");
    list8.squish();
    result = list8.toString();
    System.out.println(result);
    TestHelper.verify(result.equals("[  0  1  2  3  4  5  6  ]"),
                      "BAD SQUISH!!!  No biscuit.");

    SList list9 = new SList();
    System.out.println("squishing " + list9.toString() + ":");
    list9.squish();
    result = list9.toString();
    System.out.println(result);
    TestHelper.verify(result.equals("[  ]"),
                      "BAD SQUISH!!!  No biscuit.");


    System.out.println("\nLet's twin linked lists!\n");

    System.out.println("twinning " + list6.toString() + ":");
    list6.twin();
    result = list6.toString();
    System.out.println(result);
    TestHelper.verify(result.equals(
                      "[  6  6  3  3  6  6  3  3  6  6  3  3  ]"),
                      "BAD TWIN!!!  No gravy.");

    System.out.println("twinning " + list7.toString() + ":");
    list7.twin();
    result = list7.toString();
    System.out.println(result);
    TestHelper.verify(result.equals("[  4  4  ]"),
                      "BAD TWIN!!!  No gravy.");

    System.out.println("twinning " + list9.toString() + ":");
    list9.twin();
    result = list9.toString();
    System.out.println(result);
    TestHelper.verify(result.equals("[  ]"),
                      "BAD TWIN!!!  No gravy.");
  }

}
