class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        
        for(int i = 0; i <= nums1.length; i++){
            for(int j = 0; j <= nums2.length; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }else if(nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }
}