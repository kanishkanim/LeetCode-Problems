class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
		
        int dp[][] = new int[n+1][m+1];
		//fill the DP matrix according to how you have filled for finding the length of the LCS.
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0||j==0)
                    dp[i][j] = 0;
                else{
                    if(str1.charAt(i-1) == str2.charAt(j-1))
                        dp[i][j] = 1+dp[i-1][j-1];
                    else
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
		//for tracking back all the characters of both the strings and pushing into the resulting string.
        int i=n;
        int j=m;
        String s = "";
        while(i>0 && j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                s = str1.charAt(i-1) + s;
                i--;
                j--;
            }
            else{ // for pushing the opposite direction's character into the resulting string when the characters are not equal and we need to decide which direction to move next
                if(dp[i][j-1]>dp[i-1][j]){
                    s = str2.charAt(j-1) + s;
                    j--;
                }
                else{
                    s = str1.charAt(i-1) + s;
                    i--;
                }
            }
        }
		//once any of the pointers(i or j) reaches 0, means the string denoted by that pointer has been fully processed, then --> we need to check if we have any characters left in the other string.
        while(i>0){
            s = str1.charAt(i-1) + s;
            i--;
        }
        while(j>0){
            s = str2.charAt(j-1) + s;
            j--;
        }
        return s;
    }
}