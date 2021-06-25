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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        
        Stack<TreeNode> nextStack = new Stack<>();
        nextStack.add(root);
        
        boolean leftFirst = false;
        List<List<Integer>> result = new ArrayList<>();
        while (nextStack.size() > 0) {
            Stack<TreeNode> stack = nextStack;
            nextStack = new Stack<>();
            leftFirst = !leftFirst;
            
            List<Integer> list = new ArrayList<>();
            while (stack.size() > 0) {
                TreeNode node = stack.pop();
                if (leftFirst) {
                    if (node.left != null) {
                        nextStack.add(node.left);
                    }
                    if (node.right != null) {
                        nextStack.add(node.right);
                    }
                    
                } else {
                    if (node.right != null) {
                        nextStack.add(node.right);
                    }
                    if (node.left != null) {
                        nextStack.add(node.left);
                    }
                }
                list.add(node.val);
            }
            result.add(list);
        }
        return result;
    }
}