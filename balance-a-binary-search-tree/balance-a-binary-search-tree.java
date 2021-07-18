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
    private List<Integer> arr = new ArrayList();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);        
        return build(arr,0,arr.size()-1); 
    }
    private void inorder(TreeNode node){
        if(node == null)return;
        inorder(node.left);
        arr.add(node.val);
        inorder(node.right);
    }
    private TreeNode build(List<Integer> arr,int start,int end){
        if(start > end)return null;
        int mid = (start+end)/2;
        TreeNode temp  = new TreeNode(arr.get(mid));
        temp.left = build(arr,start,mid-1);
        temp.right = build(arr,mid+1,end);
        return temp;
    }
}