class Solution {
    public List<Integer> lexicalOrder(int n) {
        if (n == 0)
            return new ArrayList<>();
        
        List<Integer> res = new ArrayList<>();
        
        for (int i = 1; i <= 9; i++) {
            dfs(i, n, res);
        }
        return res;
    }
    
    public void dfs(int num, int n, List<Integer> res) {
        if (num > n)
            return;
        
        res.add(num);
        
        for (int i = 0; i < 10; i++) {
            int next = num * 10 + i;
            if (next > n)
                return;
            dfs(next, n, res);
        }
    }
}