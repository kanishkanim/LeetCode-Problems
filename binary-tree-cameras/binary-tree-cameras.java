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
    
    public int cameras = 0;
    
    public int minCameraCover(TreeNode root){
        if(dfs(root) == -1){ //critical point
            cameras++;  
        } 
        return cameras;
    }

    public int dfs(TreeNode root){
        if(root == null) return 1;

        int lchild = dfs(root.left);
        int rchild = dfs(root.right);

        if(lchild == -1 || rchild == -1){ //camera needed to any of the children
            cameras++;
            return 0;
        }
            
        if(lchild == 0 || rchild == 0) return 1; //if any of the children already has camera

        return -1;
    }
}