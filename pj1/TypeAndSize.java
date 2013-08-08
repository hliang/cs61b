/* TypeAndSize.java */

/* DO NOT CHANGE THIS FILE. */
/* YOUR SUBMISSION MUST WORK CORRECTLY WITH _OUR_ COPY OF THIS FILE. */

import java.io.*;

/**
 *  Each TypeAndSize object represents a sequence of identical sharks, fish,
 *  or empty cells.  TypeAndSizes are your way of telling the test program
 *  what runs appear in your run-length encoding.  TypeAndSizes exist solely
 *  so that your program can return two integers at once:  one representing
 *  the type (species) of a run, and the other representing the size of a run.
 *
 *  TypeAndSize objects are not appropriate for representing your run-length
 *  encoding, because they do not represent the degree of hunger of a run of
 *  sharks.
 *
 *  @author Jonathan Shewchuk
 */

public class TypeAndSize {

  public int type;                   // Ocean.EMPTY, Ocean.SHARK, or Ocean.FISH
  public int size;                                // Number of cells in the run

  /**
   *  Constructor for a TypeAndSize of specified species and run length.
   *  @param species is Ocean.EMPTY, Ocean.SHARK, or Ocean.FISH.
   *  @param runLength is the number of identical cells in this run.
   *  @return the newly constructed Critter.
   */

  public TypeAndSize(int species, int runLength) {
    if ((species != Ocean.EMPTY) && (species != Ocean.SHARK) &&
        (species != Ocean.FISH)) {
      System.out.println("TypeAndSize Error:  Illegal species.");
      System.exit(1);
    }
    if (runLength < 1) {
      System.out.println("TypeAndSize Error:  runLength must be at least 1.");
      System.exit(1);
    }
    this.type = species;
    this.size = runLength;
  }

}
