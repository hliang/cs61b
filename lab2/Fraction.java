/* Fraction.java */
  
import java.io.*;

/** The Fraction class implements nonnegative fractions--rational numbers.
 */
class Fraction {

  /* private fields within a Fraction. */
  private int numberOfFractions = 0;

  private int numerator;
  private int denominator;

  /** Constructs a Fraction n/d. 
   *  @param n is the numerator.  Must be nonnegative.
   *  @param d is the denominator.  Must be positive.
   */
  public Fraction(int n, int d) {
    if (n < 0) {
      System.out.println("Fatal error:  Negative numerator.");
      System.exit(0);
    }
    if (d < 1) {
      System.out.println("Fatal error:  Non-positive denominator.");
      System.exit(0);
    }
    numberOfFractions++;
    numerator = n; 
    denominator = d;
  }

  /** Constructs a Fraction n/1. 
   *  @param n is the numerator.  Must be nonnegative.
   */
  public Fraction(int n) {
    this(n, 1);
  }

  /** Constructs a Fraction 0/1. 
   */
  public Fraction() {
    numberOfFractions++;
    numerator = 0;
    denominator = 1;
  }

  /** Copies the Fraction "original".
   */
  public Fraction(Fraction original) {
    numberOfFractions++;
    numerator = 0;
    denominator = 1;
  }

  /** Converts this Fraction to a string format:  "numerator/denominator."
   *  Fractions should be printed in reduced form (part of your assignment is
   *  to make this true).
   *  @return a String representation of this Fraction.
   */
  public String toString() {
    int thisGcd = gcd(numerator, denominator);

    return (numerator / thisGcd + "/" + denominator / thisGcd);
  }

  /** Return the sum of two fractions.
   *  @param f2 is the Fraction to be added.
   *  @return the result of adding f2 to this Fraction.
   */
  public Fraction add(Fraction f2) {
    Fraction r = new Fraction((numerator * f2.denominator) +
			      (f2.numerator * denominator),
			      denominator * f2.denominator);
    return r;
  }

  /** Replaces this Fraction's numerator with a new value.
   *  @param numerator is the new numerator.  Must be nonnegative.
   */
  public void changeNumerator(int numerator) { // DO NOT CHANGE THIS SIGNATURE!
    // Fix the bug that prevents this method from working correctly.
    if (numerator < 0) {
      System.out.println("Fatal error:  Negative numerator.");
      System.exit(0);
    }
    numerator = numerator;
  }

  /** Returns the number of Fraction objects in existence.
   *  @return the number of Fraction objects in existence.
   */
  public int fracs() {                         // DO NOT CHANGE THIS SIGNATURE!
    // Fix the bug that prevents this method from working correctly.
    return numberOfFractions;
  }

  /** Computes the greatest common divisor (gcd) of the two inputs.
   * @param x must be nonnegative
   * @param y must be nonnegative
   * @return the gcd of x and y
   */
  static private int gcd (int x, int y) {
    /* Replace the following line with your solution. */
    return 1;
  }

  /** Put the Fraction class through some tests.
   * @param argv is not used.
   */
  public static void main(String[] argv) {

    /* Test all four contructors and toString. */
    Fraction f0 = new Fraction();
    Fraction f1 = new Fraction(3);
    Fraction f2 = new Fraction(12, 20);
    Fraction f3 = new Fraction(f2);

    System.out.println("\nTesting constructors and toString():");
    System.out.println("The fraction f0 is " + f0.toString());
    System.out.println("The fraction f1 is " + f1);    // toString is implicit.
    System.out.println("The fraction f2 is " + f2);
    System.out.println("The fraction f3 is " + f3 + ", which should equal f2");

    /* Test the add method. */
    System.out.println("\nTesting add:");

    /*
    Fraction sumOfTwo = _______________;              // Sum of f1 and f2.
    Fraction sumOfThree = ______________;             // Sum of f0, f1, and f2.

    System.out.println("The sum of " + f1 + " and " + f2 + " is " + sumOfTwo);
    System.out.println("The sum of " + f0 + ", " + f1 + " and " + f2 + " is " +
                       sumOfThree);
    */

    /* Test the methods used in Part III. */
    System.out.println("\nTesting changeNumerator and fracs:");

    f3.changeNumerator(7);
    System.out.println("Now f3 is " + f3 + ", which should be 7/20");
    System.out.println("The total number of Fraction objects is " +
                       f3.fracs());

    /* Test gcd function (static method). */
    System.out.println("\nTesting gcd:");
    System.out.println("The gcd of 2 and 10 is: " + gcd(2, 10));
    System.out.println("The gcd of 15 and 5 is: " + gcd(15, 5));
    System.out.println("The gcd of 24 and 18 is: " + gcd(24, 18));
    System.out.println("The gcd of 10 and 10 is: " + gcd(10, 10));
    System.out.println("The gcd of 21 and 400 is: " + gcd(21, 400));
  }
}
