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
    
    public static class housePair{
        int withRob = 0;
        int withoutRob = 0;
    }
    
    public static housePair houseRob(TreeNode root){
        if(root == null) return new housePair();
        
        housePair left = houseRob(root.left);
        housePair right = houseRob(root.right);
        
        housePair sol = new housePair();
        sol.withRob = left.withoutRob + root.val + right.withoutRob;
        sol.withoutRob = Math.max(left.withRob, left.withoutRob) + Math.max(right.withRob, right.withoutRob);
        
        return sol;
        
    }
    
    public int rob(TreeNode root) {
        housePair res = houseRob(root);
        return Math.max(res.withRob, res.withoutRob);
    }
}