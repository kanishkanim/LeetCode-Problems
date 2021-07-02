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
class Solution {
    public void flatten(TreeNode root) {
        dfs(root);
	}
    
    private TreeNode dfs(TreeNode root) {
       if (root == null) {
	     return root;
	   }
	   // Step 1:
       TreeNode leftTail = dfs(root.left);
       TreeNode rightTail = dfs(root.right);
	   
       // Step 2:
       leftTail = leftTail == null ? root : leftTail;
       leftTail.right = root.right;
       
	   // Step 3:
       if (root.left != null) {
         root.right = root.left;
         root.left = null;
       }
	   
	   // Step 4:
       return rightTail == null ? leftTail : rightTail;
    }
}
