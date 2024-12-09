package edu.grinnell.csc207.util;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Trees intended to be used in storing mappings between fixed-length sequences of bits and
 * corresponding values.
 *
 * @author Koastiantyn
 */
public class BitTree {
  // +----------+------------------------------------------------------
  // | Constants|
  // +----------+
  /** Zero charachter. */
  static final char ZERO = '0';

  /** One charachter. */
  static final char ONE = '1';

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+
  /** height of the tree. */
  int height;

  /** An array of bits. */
  String bits;

  /** Value to be stored. */
  String value;

  /** Top of the tree. */
  BitTreeNode root;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Bit Tree.
   *
   * @param n height of the tree
   */
  public BitTree(int n) {
    this.root = new BitTreeNode(null);
    this.height = n;
  } // BitTree(int)

  // +---------------+-----------------------------------------------
  // | Local helpers |
  // +---------------+
  /**
   * Checks if the bit array is valid.
   *
   * @param bits an array of bits as a String
   * @return true if valid array of bits otherwise false
   */
  private boolean isValidBit(String bits) {
    if (bits.length() != this.height) {
      return false;
    } // if
    for (char bit : bits.toCharArray()) {
      if (bit != ONE && bit != ZERO) {
        return false;
      } // if
    } // for
    return true;
  } // isValidBit(String)

  /**
   * Helper method for setting a value in the right place in the BitTree.
   *
   * @param bits array of bits as a string
   * @param value value to be stored
   * @param root BitTreeNode
   */
  private void setHelper(String bits, String value, BitTreeNode root) {
    if (!isValidBit(bits)) {
      throw new IndexOutOfBoundsException("Invalid bits");
    } // if

    BitTreeNode curNode = root;
    for (char bit : bits.toCharArray()) {
      if (bit == ZERO) {
        if (curNode.left == null) {
          curNode.left = new BitTreeNode(null);
        } // if left node doesn't exist
        curNode = curNode.left;
      } else {
        if (curNode.right == null) {
          curNode.right = new BitTreeNode(null);
        } // if left node doesn't exist
        curNode = curNode.right;
      } // if
    } // for each
    curNode.value = value;
  } // setHelper(String, String)

  /**
   * Helper method to get the right value in the array.
   *
   * @param bits an array of bits as a String
   * @param root BitTreeNode
   * @return String value that is store in certain location
   */
  private String getHelper(String bits, BitTreeNode root) {
    if (!isValidBit(bits)) {
      throw new IndexOutOfBoundsException("Invalid bits");
    } // if
    BitTreeNode curNode = root;
    for (char bit : bits.toCharArray()) {
      if (bit == ZERO) {
        if (curNode.left == null) {
          throw new IndexOutOfBoundsException();
        } // if
        curNode = curNode.left;
      } else {
        if (curNode.right == null) {
          throw new IndexOutOfBoundsException();
        } // if
        curNode = curNode.right;
      } // if
    } // for
    return curNode.value;
  } // getHelper(String)

  /**
   * Helper method to get all the values in the tree.
   *
   * @param pen PrintWriter Object
   * @param bits an array of bits as a String
   * @param root BitTreeNode
   */
  private void dumpHelper(PrintWriter pen, String bits, BitTreeNode root) {
    if (root == null) {
      return;
    } // if
    if (root.value != null) {
      pen.println(bits + "," + root.value);
    } // if

    if (root.left != null) {
      dumpHelper(pen, bits + "0", root.left);
    } // if there is left children
    if (root.right != null) {
      dumpHelper(pen, bits + "1", root.right);
    } // if there is right children
  } // dumpHelper(PrintWriter, String, BinaryTreeNode)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Setting a value in the right place in the BitTree.
   *
   * @param bits array of bits as a string
   * @param value value to be stored
   */
  public void set(String bits, String value) {
    setHelper(bits, value, this.root);
  } // set(String, String)

  /**
   * Get the right value in the array.
   *
   * @param bits an array of bits as a String
   * @return String value that is store in certain location
   */
  public String get(String bits) {
    return getHelper(bits, this.root);
  } // get(String, String)

  /**
   * Helper method to get all the values in the tree.
   *
   * @param pen PrintWriter Object
   */
  public void dump(PrintWriter pen) {
    dumpHelper(pen, "", this.root);
  } // dump(PrintWriter)

  /**
   * Populates the bit tree.
   *
   * @param source InputStreem that contains text files
   */
  public void load(InputStream source) {
    Scanner eyes = new Scanner(source);
    while (eyes.hasNextLine()) {
      String[] input = eyes.nextLine().split(",");
      if (input.length == 2) {
        this.set(input[0], input[1]);
      } else {
        System.err.println("Invalid input line: " + eyes.nextLine());
      } //if
    } // while
    eyes.close();
  } // load(InputStream)
} // class BitTree
