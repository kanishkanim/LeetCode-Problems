/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Recursive Approach

class Solution {
 List<Integer> al = new ArrayList<Integer>();

    public List<Integer> inorderTraversal(TreeNode root) {
        printInorder(root);
        return al;
    }
    void printInorder(TreeNode node)
    {
        if (node == null)
            return;
 
        /* first recur on left child */
        printInorder(node.left);
 
        /* then print the data of node */
        al.add(node.val);
 
        /* now recur on right child */
        printInorder(node.right);
    }
 
}