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
    public List<Integer> preorderTraversal(TreeNode root) {
        return recursePreorder(root, new LinkedList<>());
    }
    
    private List<Integer> recursePreorder(TreeNode currNode, List<Integer> lst) {
        if (currNode == null) return lst;
        
        lst.add(currNode.val);
        recursePreorder(currNode.left, lst);
        recursePreorder(currNode.right, lst);
        return lst;
    }
}