class Solution {
    // the idea is to maximize the sum: 
    // maxCoins(up to selected-last) + left*selected-last*right + maxCoins(following selected-last)
    // for that we gradually calculate subproblems from single num (sliding window size = 0) up to entire nums
    public int maxCoins(int[] nums) {
        if (nums.length == 0) return 0;
        
        int n = nums.length;
        
        // dp[i,j] holds the solution for max conins between indices and i and j in nums
        int[][] dp = new int[nums.length][nums.length];
        
        // k - sliding window size, i.e. distance between i and j. we try all sizes
        for (int k = 0; k < n; k++) {
            // i - statring index of sliding window in nums
            // j - endind index of sliding window in nums
            for (int i = 0; i < n - k; i++) {
                int j = i + k;
                int l = i == 0 ? 1 : nums[i - 1];
                int r = j == n - 1 ? 1 : nums[j + 1];
                
                dp[i][j] = 0;
                // q - which element of the sliding window will burst last, we try them all to find best/max
                for (int q = i; q <= j; q++) {
                    int lh = q == i ? 0 : dp[i][q - 1];
                    int rh = q == j ? 0 : dp[q + 1][j];
                    dp[i][j] = Math.max(dp[i][j], lh + l * nums[q] * r + rh);
                }
            }
        }
        
        return dp[0][nums.length - 1];
    }
}