class Solution {
    public int largestIsland(int[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }
        int rows = grid.length, cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];
        int max = 0;
        int index = 3;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (grid[i][j] == 1 && !visited[i][j]){
                    int curSize = dfs(grid, i, j, visited);
                    map.put(index, curSize);
                    broadcast(grid, i, j, dp, index++);
                    max = Math.max(curSize, max);
                }
            }
        }
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (grid[i][j] == 0){
                    Set<Integer> toVisit = new HashSet<>();
                    if (i-1>=0) toVisit.add(dp[i-1][j]);
                    if (i+1<rows) toVisit.add(dp[i+1][j]);
                    if (j-1>=0) toVisit.add(dp[i][j-1]);
                    if (j+1<cols) toVisit.add(dp[i][j+1]);
                    
                    int size=1;
                    for (int mapI: toVisit){
                        size += map.get(mapI);
                    }
                    max = Math.max(size, max);
                }
            }
        }
        return max;
    }
    public int dfs(int[][] grid, int i, int j, boolean[][] visited){
        if (i < 0 || i>=grid.length || j < 0 || j>= grid[0].length || visited[i][j] || grid[i][j] == 0){
            return 0;
        }
        visited[i][j] = true;
        return 1+dfs(grid, i+1, j, visited)+dfs(grid, i-1, j, visited)+dfs(grid, i, j-1, visited)+dfs(grid, i, j+1, visited);
    }
    public void broadcast(int[][] grid, int i, int j, int[][] dp, int size){
        if (i < 0 || i>=grid.length || j < 0 || j>= grid[0].length || dp[i][j]==size || grid[i][j] == 0){
            return ;
        }
        dp[i][j] = size;
        broadcast(grid, i+1, j, dp, size);
        broadcast(grid, i-1, j, dp, size);
        broadcast(grid, i, j+1, dp, size);
        broadcast(grid, i, j-1, dp, size);
    }
}

