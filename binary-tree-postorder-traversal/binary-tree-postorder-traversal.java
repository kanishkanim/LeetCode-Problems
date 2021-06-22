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

// Iterative Approach

class Solution {
    public static class Pair{
        TreeNode node;
        int state;
        
        Pair(TreeNode node, int state){
            this.node = node;
            this.state = state;
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
       if(root == null) return new ArrayList<>();
        
       Stack<Pair> st = new Stack<>();
       st.push(new Pair(root, 1));
       List<Integer> postorder = new ArrayList<>();
       
       while(st.size() > 0){
           Pair top =  st.peek();
           
           if(top.state == 1){
               //PRE ORDER AREA
               top.state++;
               if(top.node.left != null){
                   st.push(new Pair(top.node.left, 1));
               }
           }
           else if(top.state == 2){
               //IN ORDER AREA
               top.state++;
               if(top.node.right != null){
                   st.push(new Pair(top.node.right, 1));
               }
           }
           else if(top.state == 3){
               //POST ORDER AREA
               postorder.add(top.node.val);
               st.pop();
           }
       }
        return postorder;
    }
}