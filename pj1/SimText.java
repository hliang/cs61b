/* SimText.java */

/* DO NOT CHANGE THIS FILE (except as noted). */
/* YOUR SUBMISSION MUST WORK CORRECTLY WITH _OUR_ COPY OF THIS FILE. */

/* (You may wish to make temporary changes or insert println() statements    */
/* while testing your code.  When you're finished testing and debugging,     */
/* though, make sure your code works with the original version of this file. */

import java.util.*;

/**
 *  The SimText class is a program that runs and animates a simulation of
 *  Sharks and Fish.
 *
 *  The SimText program takes up to four parameters.  The first two specify
 *  the width and height of the ocean.  The third parameter specifies the value
 *  of starveTime.  For example, if you run
 *
 *         java SimText 25 25 1
 *
 *  then SimText will animate a 25x25 ocean with a starveTime of 1.  If you run
 *  "java SimText" with no parameters, by default SimText will animate a 50x25
 *  ocean with a starveTime of 3.  With some choices of parameters, the ocean
 *  quickly dies out; with others, it teems forever.
 *
 *  @author Jonathan Shewchuk
 */

public class SimText {

  /**
   *  Default parameters.  (You may change these if you wish.)
   */

  private static int i = 50;                             // Default ocean width
  private static int j = 25;                            // Default ocean height
  private static int starveTime = 3;           // Default shark starvation time

  /**
   *  paint() prints an Ocean.
   */

  public static void paint(Ocean sea) {
    if (sea != null) {
      int width = sea.width();
      int height = sea.height();

      /* Draw the ocean. */
      for (int x = 0; x < width + 2; x++) {
        System.out.print("-");
      }
      System.out.println();
      for (int y = 0; y < height; y++) {
        System.out.print("|");
        for (int x = 0; x < width; x++) {
          int contents = sea.cellContents(x, y);
          if (contents == Ocean.SHARK) {
            System.out.print('S');
          } else if (contents == Ocean.FISH) {
            System.out.print('~');
          } else {
            System.out.print(' ');
          }
        }
        System.out.println("|");
      }
      for (int x = 0; x < width + 2; x++) {
        System.out.print("-");
      }
      System.out.println();
    }
  }

  /**
   *  main() reads the parameters and performs the simulation and animation.
   */

  public static void main(String[] argv) throws InterruptedException {
    Ocean sea;

    /**
     *  Read the input parameters.
     */

    if (argv.length > 0) {
      try {
        i = Integer.parseInt(argv[0]);
      }
      catch (NumberFormatException e) {
        System.out.println("First argument to SimText is not an number.");
      }
    }

    if (argv.length > 1) {
      try {
        j = Integer.parseInt(argv[1]);
      }
      catch (NumberFormatException e) {
        System.out.println("Second argument to SimText is not an number.");
      }
    }

    if (argv.length > 2) {
      try {
        starveTime = Integer.parseInt(argv[2]);
      }
      catch (NumberFormatException e) {
        System.out.println("Third argument to SimText is not an number.");
      }
    }

    /**
     *  Create the initial ocean.
     */

    sea = new Ocean(i, j, starveTime);

    /**
     *  Visit each cell (in a roundabout order); randomly place a fish, shark,
     *  or nothing in each.
     */

    Random random = new Random(0);      // Create a "Random" object with seed 0
    int x = 0;
    int y = 0;
    for (int xx = 0; xx < i; xx++) {
      x = (x + 78887) % i;           // This will visit every x-coordinate once
      if ((x & 8) == 0) {
        for (int yy = 0; yy < j; yy++) {
          y = (y + 78887) % j;       // This will visit every y-coordinate once
          if ((y & 8) == 0) {
            int r = random.nextInt();     // Between -2147483648 and 2147483647
            if (r < 0) {                        // 50% of cells start with fish
              sea.addFish(x, y);
            } else if (r > 1500000000) {     // ~15% of cells start with sharks
              sea.addShark(x, y);
            }
          }
        }
      }
    }

    /**
     *  Perform timesteps forever.
     */

    while (true) {                                              // Loop forever
      paint(sea);
      //  For fun, you might wish to change the delay in the next line.
      Thread.sleep(1000);                // Wait one second (1000 milliseconds)
      sea = sea.timeStep();                              // Simulate a timestep
    }
  }

}
