/* OpenCommercial.java */

import java.net.*;
import java.io.*;

/**  a class called Nuke2 whose main method reads a string from the keyboard
 * and prints the same string, with its second character removed.
 */

class Nuke2 {

  public static void main(String[] arg) throws Exception {

    BufferedReader keyboard;
    String inputString;

    /* read from keyboard */
    keyboard = new BufferedReader(new InputStreamReader(System.in));
    inputString = keyboard.readLine();

    String outString;
    /* concatenate 1st character and characters from 3rd to end */
    outString = inputString.substring(0,1) + inputString.substring(2);
    System.out.println(outString);

  }
}
