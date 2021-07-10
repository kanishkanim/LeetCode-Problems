class Solution {
    public int numDecodings(String s) {
        
        int MOD=1000000000+7;
        if(s.charAt(0)=='0')
            return 0;
        int len = s.length();
        long[] dp = new long[len+1];
        
        dp[0]=1;
        if(s.charAt(0)!='*')
            dp[1]=1;
        else
            dp[1]=9;
        
        for(int i=2;i<=len;i++){
            
            if(s.charAt(i-1)!='0' && s.charAt(i-1)!='*')
                dp[i]=dp[i-1];
            if(s.charAt(i-1)=='*')
                dp[i]=dp[i-1]*9;
            
            if(s.charAt(i-2)=='1'){
                if(s.charAt(i-1)!='*')
                    dp[i]+=dp[i-2];
                else{
                    dp[i]+=dp[i-2]*9;
                } 
            }
            else if(s.charAt(i-2)=='2'){
                if(s.charAt(i-1)>='0' && s.charAt(i-1)<='6'){
                    dp[i]+=dp[i-2];
                }else if(s.charAt(i-1)=='*'){
                    dp[i]+=dp[i-2]*6;
                }
            }else if(s.charAt(i-2)=='*'){
                if(s.charAt(i-1)=='*'){
                    dp[i]+=dp[i-2]*(9+6);
                }else if(s.charAt(i-1)>='0' && s.charAt(i-1)<='6'){
                    dp[i]+=dp[i-2]*2;
                }else {
                    dp[i]+=dp[i-2];
                }
            }
            dp[i]=dp[i]%MOD;
        }
        
        return (int)dp[len];
        
    }
}