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
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 0;
        
        for(int in : inorder) {
            map.put(in, index++);
        }
        
        return buildTree(preorder, inorder, 0, 0, inorder.length - 1, map) ;
    }
    
    TreeNode buildTree(int[] preorder, int[] inorder, int p, int startI, int endI, HashMap<Integer, Integer> map) {
      
        if(p > preorder.length - 1 || endI < startI) {
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[p]);
        int inInd = map.get(node.val);
        
        node.left = buildTree(preorder, inorder, p + 1, startI,inInd - 1, map);
        node.right = buildTree(preorder, inorder, p + inInd - startI + 1, inInd + 1, endI, map);
        
        return node;
    }
}