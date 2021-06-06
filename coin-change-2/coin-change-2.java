class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        
        for(int coin: coins){
            for(int j = coin; j < dp.length; j++){
			// calculate remaining amt;
                int rem_amt = j - coin;
                dp[j] += dp[rem_amt];
            }
        }
        
        return dp[amount]; 
    }
}