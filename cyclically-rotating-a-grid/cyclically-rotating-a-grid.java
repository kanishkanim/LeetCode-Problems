class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length, r = m, c = n;
        for(int i=0; i<Math.min(m,n)/2; i++, r -= 2, c-= 2){
            int total = 2*(r+c-2);
            int k1 = k%total;
            while(k1-- > 0){
                int tmp = grid[i][i];
                for(int j=i+1;j<i+c;j++){
                    grid[i][j-1] = grid[i][j]; 
                }
                for(int j=i+1;j<i+r;j++){
                    grid[j-1][i+c-1] = grid[j][i+c-1];
                }
                for(int j=i+c-2; j>=i; j--){
                    grid[i+r-1][j+1] = grid[i+r-1][j];
                }
                for(int j=i+r-2; j>i; j--){
                    grid[j+1][i] = grid[j][i];
                }
                grid[i+1][i] = tmp;
            }
        }
        return grid;
    }
}
