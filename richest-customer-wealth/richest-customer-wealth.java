class Solution {
    public int maximumWealth(int[][] accounts) {
        
        int wealth = 0;
        for(int i = 0; i<=accounts.length-1 ; i++){
            int wealthI = 0;
            for(int j = 0; j<=accounts[i].length-1 ; j++){
                wealthI += accounts[i][j];
            }
            wealth = Math.max(wealthI , wealth);
        }
        return wealth;
    }
}