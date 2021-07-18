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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return root;
        
        if(key < root.val){
            root.left = deleteNode(root.left, key);   
        }
        else if(key > root.val){
            root.right = deleteNode(root.right, key);   
        }
        else{
            if(root.left == null && root.right == null) root = null;
            else if(root.right != null){
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }else{
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
       return root;
    }
    
    public int successor(TreeNode node){
        node = node.right;
        while(node.left != null) node = node.left;
        return node.val;
    }
    public int predecessor(TreeNode node){
        node = node.left;
        while(node.right != null) node = node.right;
        return node.val;
    }
    
    
}