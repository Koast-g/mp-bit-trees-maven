package edu.grinnell.csc207.util;

/**
 * Nodes in the tree.
 *
 * @author Kostiantyn Tsymbal
 */
class BitTreeNode {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+
  /** The value to the in the node. */
  String value;

  /** The left subtree. */
  BitTreeNode left;

  /** The right subtree. */
  BitTreeNode right;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new binary tree node with a String, left subtree, and right subtree.
   *
   * @param val The string value to be stored in the node.
   */
  public BitTreeNode(String val) {
    this.value = val;
    this.left = null;
    this.right = null;
  } // BinaryTreeNode(T, BinaryTreeNode, BinaryTreeNode)
} // class BitTreeNode
