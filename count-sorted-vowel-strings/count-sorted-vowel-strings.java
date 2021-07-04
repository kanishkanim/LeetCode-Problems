class Solution {
    public int countVowelStrings(int n) {
        int[][] dp = new int[n][5];
        Arrays.fill(dp[0],1);
        for(int i=1;i<n;i++){
            for(int j=4;j>=0;j--){
                dp[i][j] = j==4?1:dp[i-1][j] + dp[i][j+1];
            }
        }
        int res = 0;
        for(int i=0;i<5;i++){
            res+=dp[n-1][i];
        }
        return res;
    }
}