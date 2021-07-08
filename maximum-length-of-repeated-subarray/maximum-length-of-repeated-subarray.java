class Solution {
    public int findLength(int[] A, int[] B) {
        int[] dp = new int[B.length];
        
        int ans = 0;
        
        //case i==0;
        for(int j=0;j<B.length;j++){
            dp[j] = A[0] == B[j]?1:0;
            ans = Math.max(ans, dp[j]);
        }
        //case i>0;
        for(int i=1;i<A.length;i++){
            for(int j=B.length-1;j>0;j--){
                dp[j] = A[i]==B[j]?(1+dp[j-1]):0;
                ans = Math.max(ans, dp[j]);
            }
            dp[0] = A[i]==B[0]?1:0;
            ans = Math.max(ans, dp[0]);
        }
    
        return ans;
        
    }
}