/* Simulation.java */

/* DO NOT CHANGE THIS FILE (except as noted). */
/* YOUR SUBMISSION MUST WORK CORRECTLY WITH _OUR_ COPY OF THIS FILE. */

/* (You may wish to make temporary changes or insert println() statements    */
/* while testing your code.  When you're finished testing and debugging,     */
/* though, make sure your code works with the original version of this file. */

import java.awt.*;
import java.util.*;

/**
 *  The Simulation class is a program that runs and animates a simulation of
 *  Sharks and Fish.
 *
 *  The Simulation program takes up to four parameters.  The first two specify
 *  the width and height of the ocean.  The third parameter specifies the value
 *  of starveTime.  For example, if you run
 *
 *         java SimText 25 25 1
 *
 *  then Simulation will animate a 25x25 ocean with a starveTime of 1.  If you
 *  run "java SimText" with no parameters, by default Simulation will animate
 *  a 50x25 ocean with a starveTime of 3.  With some choices of parameters,
 *  the ocean quickly dies out; with others, it teems forever.
 *
 *  @author Jonathan Shewchuk
 */

public class Simulation {

  /**
   *  The constant cellSize determines the size of each cell on the screen
   *  during animation.  (You may change this if you wish.)
   */

  private static final int cellSize = 4;

  /**
   *  Default parameters.  (You may change these if you wish.)
   */

  private static int i = 80;                             // Default ocean width
  private static int j = 80;                            // Default ocean height
  private static int starveTime = 3;           // Default shark starvation time

  private static void drawOcean(Graphics graphics, Ocean ocean) {
    if (ocean != null) {
      int width = ocean.width();
      int height = ocean.height();

      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          int contents = ocean.cellContents(x, y);
          if (contents == Ocean.SHARK) {
            graphics.setColor(Color.red);                   // Draw a red shark
            graphics.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
          } else if (contents == Ocean.FISH) {
            graphics.setColor(Color.green);                // Draw a green fish
            graphics.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
          } else {
            graphics.clearRect(x * cellSize, y * cellSize, cellSize, cellSize);
          }
        }
      }
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
        System.out.println("First argument to Simulation is not an number.");
      }
    }

    if (argv.length > 1) {
      try {
        j = Integer.parseInt(argv[1]);
      }
      catch (NumberFormatException e) {
        System.out.println("Second argument to Simulation is not an number.");
      }
    }

    if (argv.length > 2) {
      try {
        starveTime = Integer.parseInt(argv[2]);
      }
      catch (NumberFormatException e) {
        System.out.println("Third argument to Simulation is not an number.");
      }
    }

    /**
     *  Create a window on your screen.
     */

    Frame frame = new Frame("Sharks and Fish");
    //  The "10" and "30" in the following line were determined by trial and
    //  error, and seem to be necessary for the lab machines.  On some other
    //  machines, they just create ugly margins.  Sigh.
    frame.setSize(i * cellSize + 10, j * cellSize + 30);
    frame.show();

    /**
     *  Create a "Canvas" we can draw upon; attach it to the window.
     */

    Canvas canvas = new Canvas();
    canvas.setBackground(Color.white);
    canvas.setSize(i * cellSize, j * cellSize);
    frame.add(canvas);
    Graphics graphics = canvas.getGraphics();

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
      Thread.sleep(1000);                // Wait one second (1000 milliseconds)
      drawOcean(graphics, sea);                       // Draw the current ocean
      //  For fun, you might wish to change the delay in the next line.
      //  If you make it too short, though, the graphics won't work properly.
      sea = sea.timeStep();                              // Simulate a timestep
    }
  }

}
