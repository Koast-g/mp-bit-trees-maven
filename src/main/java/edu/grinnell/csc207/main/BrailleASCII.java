package edu.grinnell.csc207.main;

import edu.grinnell.csc207.util.BrailleAsciiTables;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Main Class.
 *
 * @author koast Tsymbal
 */
public class BrailleASCII {
  // +-----------+-----------------------------------------------
  // | Constants |
  // +-----------+
  /** Valid commands. */
  static final String[] COMMANDS = {"braille", "ascii", "unicode"};

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
    String command = args[0].toLowerCase();
    String input = args[1];
    boolean containsCommand = Arrays.stream(COMMANDS).anyMatch(command::equals);

    if (!containsCommand) {
      throw new Exception("Invalid command");
    } // if

    switch (command) {
      case "braille":
        try {
          for (int i = 0; i < input.length(); i++) {
            pen.println(BrailleAsciiTables.toBraille(input.charAt(i)));
          } // for
        } catch (Exception e) {
          pen.println("Trouble translating because No corresponding value");
        } // try/catch
        break;
      case "ascii":
        if (input.length() % 6 != 0) {
          throw new Exception("Invalid lenght of a bit string");
        } // if
        try {
          for (int i = 0; i < input.length(); i += 6) {
            pen.print(BrailleAsciiTables.toAscii(input.substring(i, i + 6)));
          } // for
        } catch (Exception e) {
          pen.println("Trouble translating because No corresponding value");
        } // try/catch
        break;
      case "unicode":
        try {
          for (int i = 0; i < input.length(); i++) {
            pen.println(
                BrailleAsciiTables.toUnicode(BrailleAsciiTables.toBraille(input.charAt(i))));
          } // for
        } catch (Exception e) {
          pen.println("Trouble translating because No corresponding value");
        } // try/catch
        break;
      default:
        throw new Exception("Something went wrong");
    } // switch
    pen.close();
  } // main(String[]
} // class BrailleASCII
