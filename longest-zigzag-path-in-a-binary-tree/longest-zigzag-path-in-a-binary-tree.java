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
    
    public static class pair{
        int forwardSlope = -1;
        int backwardSlope = -1;
        int maxLen = 0;
    }
    
    public static pair longestZigZag_(TreeNode root){
        if(root == null) return new pair();
        
        pair left = longestZigZag_(root.left);
        pair right = longestZigZag_(root.right);
        
        pair sol = new pair();
        sol.maxLen = Math.max(Math.max(left.maxLen, right.maxLen), Math.max(left.backwardSlope, right.forwardSlope) + 1); 
        
        sol.forwardSlope = left.backwardSlope + 1;
        sol.backwardSlope = right.forwardSlope + 1;
        
        return sol;
    }
    
    public int longestZigZag(TreeNode root) {
        pair solve = longestZigZag_(root);
        return solve.maxLen;
    }
}