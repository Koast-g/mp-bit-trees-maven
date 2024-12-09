package edu.grinnell.csc207.main;

import java.io.PrintWriter;

/**
 * Main Class.
 *
 * @author koast Tsymbal
 */
public class BrailleASCII {
  // +---------------+-----------------------------------------------
  // | Local helpers |
  // +---------------+
  /**
   * Converts Braile to String.
   *
   * @param input String
   * @return Braile String
   */
  static String toBraile(String input) {
    return "";
  } // toBraile(String)

  /**
   * Converts ASCII to String.
   *
   * @param input String
   * @return ASCII String
   */
  static String toASCII(String input) {
    return "";
  } // toBraile(String)

  /**
   * Converts string to Unicode.
   *
   * @param input String
   * @return Unicode String
   */
  static String toUnicode(String input) {
    return "";
  } // toBraile(String)

  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Main.
   *
   * @param args a line of string arguments
   * @throws Exception Exception
   */
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    if (args.length != 2) {
      throw new Exception("Invalid input length");
    } // if

    switch (args[0]) {
      case "braille":
        pen.println(toBraile(args[1]));
        break;
      case "ascii":
        pen.println(toASCII(args[1]));
        break;
      case "unicode":
        pen.println(toUnicode(args[1]));
        break;
      default:
        throw new Exception("Invalid command");
    } // switch
    pen.close();
  } // main(String[]
} // class BrailleASCII
