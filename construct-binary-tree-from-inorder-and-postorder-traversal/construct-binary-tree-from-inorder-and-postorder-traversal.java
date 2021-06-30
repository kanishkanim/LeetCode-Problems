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
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeHelper(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int[] postorder, int psi, int pei, int[] inorder, int isi, int iei) {
		
        if(isi > iei) {
            return null;
        }
		
        TreeNode root = new TreeNode(postorder[pei]);
        int matchIndex = isi;
        
        while(inorder[matchIndex] != postorder[pei]) {
            matchIndex++;
        }
        
        int postorderLeftSubtreeSize = matchIndex - isi;
		root.left = buildTreeHelper(postorder, psi, psi + postorderLeftSubtreeSize - 1, inorder, isi, matchIndex - 1);
        root.right = buildTreeHelper(postorder, psi + postorderLeftSubtreeSize, pei - 1, inorder, matchIndex + 1, iei);
        return root;
    }
}