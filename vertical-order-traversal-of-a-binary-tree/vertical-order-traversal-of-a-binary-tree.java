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

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        Map<Integer, List<int[]>> map = new HashMap<>();
        int min = 0, max = 0;
        
        Queue<TreeNode> nodeQ = new LinkedList<>();
        Queue<Integer> indexQ = new LinkedList<>();
        
        nodeQ.add(root);
        indexQ.add(0);
        
        int y = 0;
        while (!nodeQ.isEmpty()) {
            int size = nodeQ.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = nodeQ.poll();
                int x = indexQ.poll();
                if (!map.containsKey(x)) {
                    map.put(x, new ArrayList<>());
                }
                map.get(x).add(new int[] {cur.val, y});
                if (cur.left != null) {
                    nodeQ.add(cur.left);
                    indexQ.add(x - 1);
                    min = Math.min(min, x - 1);
                }
                if (cur.right != null) {
                    nodeQ.add(cur.right);
                    indexQ.add(x + 1);
                    max = Math.max(max, x + 1);
                }
            }
            y++;
        }
        
        for (int x = min; x <= max; x++) {
            List<int[]> list = map.get(x);
            Collections.sort(list, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    int d = a[1] - b[1];
                    if (d != 0) return d;
                    return a[0] - b[0];
                }
            });
            
            List<Integer> l = new ArrayList<>();
            for (int[] nums : list) {
                l.add(nums[0]);
            }
            res.add(l);
        }
        return res;
                             
    }
}
