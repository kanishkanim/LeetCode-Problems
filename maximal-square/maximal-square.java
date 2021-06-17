class Solution {
    public int maximalSquare(char[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) return 0;
        int r = m.length, c = m[0].length, res = 0;
        int[][] a = new int[r][c];
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (i == 0 || j == 0)a[i][j] = m[i][j] == '1' ? 1 : 0;
                else if (m[i][j] == '1') a[i][j] = Math.min(a[i-1][j-1], Math.min(a[i-1][j], a[i][j-1])) + 1;
                else a[i][j] = 0;
                res = Math.max(a[i][j], res);
            }
        }
        return res*res; 
    }
}