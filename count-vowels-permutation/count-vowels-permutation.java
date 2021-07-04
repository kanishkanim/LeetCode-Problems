class Solution {
    public int countVowelPermutation(int n) {
        int mod = (int) (1e9 + 7);
        if (n == 0) return 1;
        if (n == 1) return 5;
        long[][] dp = new long[n+1][5];
        for (int i = 0; i < 5; i++) {
            dp[1][i] = 1;
        }
		// for i + 1, just add new char to the head of old string.
        for (int i = 1; i < n; i++) {
            dp[i+1][0] = (dp[i][1]) % mod; 
            dp[i+1][1] = (dp[i][0] + dp[i][2]) % mod;
            dp[i+1][2] = (dp[i][0] + dp[i][1] + dp[i][3] + dp[i][4]) % mod;
            dp[i+1][3] = (dp[i][2] + dp[i][4]) % mod;
            dp[i+1][4] = (dp[i][0]) % mod;
        }
        long res = 0;
        for (int i = 0; i < 5; i++) {
            res = (res +dp[n][i]) % mod;
        }
        return (int) res;
    }
}
