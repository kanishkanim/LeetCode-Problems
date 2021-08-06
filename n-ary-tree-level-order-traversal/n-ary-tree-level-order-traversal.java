/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        if(root == null)
            return result;
        q.add(root);
        while(!q.isEmpty())
        {
            List<Integer> newarr = new ArrayList<>();
            int size = q.size();
            for(int i=0; i<size; i++)
            {
                Node temp = q.poll();
                newarr.add(temp.val);
                List<Node> currlist = temp.children;
                int currsize = currlist.size();
                for(int j=0; j<currsize; j++)
                {
                    q.add(currlist.get(j));
                }
            }
            result.add(newarr);
        }
        return result;
    }
}