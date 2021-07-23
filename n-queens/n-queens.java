class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(board[i], '.');
        }
        solve(board, n, 0, ans);
        return ans;
    }
    
    private void solve (char[][] board, int n, int row, List<List<String>> ans){
        if(row == n){
            List<String> li = new ArrayList<String>();
            for(char[] rowChars : board){
                li.add(new String(rowChars));
            }
            ans.add(li);
            return;
        }
        for(int col = 0; col < n; col++){
            if(board[row][col] == '.' && isValid(board, n, row, col)){
                board[row][col] = 'Q';
                solve(board, n, row + 1, ans);
                board[row][col] = '.';
            }
        }
    }
    
    private boolean isValid(char[][] board, int n, int i, int j){
        for(int row = 0; row < n; row++){
            if(board[row][j] == 'Q')
                return false;
        }
        for(int col = 0; col < n; col++){
            if(board[i][col] == 'Q')
                return false;
        }
        
        //check diagonal
        int row = i, col = j;
        while (row >= 0 && col >= 0) {
            if (board[row--][col--] == 'Q')
                return false;
        }
        row = i;
        col = j;
        while (row < n && col < n) {
            if (board[row++][col++] == 'Q')
                return false;
        }

        // check other diagonal.
        row = i;
        col = j;
        while (row >= 0 && col < n) {
            if (board[row--][col++] == 'Q')
                return false;
        }
        row = i;
        col = j;
        while (row < n && col >= 0) {
            if (board[row++][col--] == 'Q')
                return false;
        }

        return true;
    }
}