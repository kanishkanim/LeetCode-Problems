class Solution {
    public int maxSumSubmatrix(int[][] matrix, int K) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = Integer.MIN_VALUE;
        
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] += matrix[i][j-1]; 
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                TreeSet<Integer> set = new TreeSet();
                // init
                set.add(0);
                
                int sum = 0;
                
                for (int k = 0; k < m; k++) {
                    sum += matrix[k][j] - (i > 0 ? matrix[k][i-1] : 0);
                    Integer val = set.ceiling(sum - K);
                    if (val != null)
                        res = Math.max(res, sum - val);
                    set.add(sum);
                }
            }
        }
        return res;
    }
}