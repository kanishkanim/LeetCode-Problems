class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0)
        return 0;
        
        if (envelopes.length == 1)
        return 1;
       
        // sorting the array in inncreaing order of width
        Arrays.sort(envelopes, Comparator.comparing(a -> a[0]));

        int [] dp = new int [envelopes.length];
        int  max= 1;

        for( int i = 0; i < envelopes.length ;  i++)
            dp[i] = 1;

        for(int i = 1 ; i < envelopes.length; i++){
        for(int j = 0 ;   j< i; j++){

            if(envelopes[i][0] > envelopes [j][0]  && envelopes[i][1] >  envelopes[j][1])
                        dp[i] = Integer.max(dp[i], 1 +  dp[j]);
        }

            if(dp[i] > max)
                max = dp[i];
        }
        
        return max;
    }
}