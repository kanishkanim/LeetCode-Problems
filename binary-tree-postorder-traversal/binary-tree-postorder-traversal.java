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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        
        if(root == null) return list;
        
        TreeNode cur = root;
        
        while(cur != null || !st.isEmpty()){
            if(cur != null){
                st.push(cur);
                cur = cur.left;
            }else{
                TreeNode temp = st.peek().right;
                if(temp == null){
                    temp = st.pop();
                    list.add(temp.val);
                    while(!st.isEmpty() && temp == st.peek().right){
                        temp = st.pop();
                        list.add(temp.val);
                    }
                }else{
                    cur = temp;
                }
            }
        }
        return list;
    }
}