// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}



// } Driver Code Ends

// Here is the top-down approach of  
// dynamic programming
class Solution{
    
// A utility function that returns  
// maximum of two integers     
static int max(int a, int b)     
{     
    return (a > b) ? a : b;     
} 

// Returns the value of maximum profit   
static int knapSackRec(int W, int wt[], int val[], int n, int [][]dp)
{   
    
    // Base condition
    if (n == 0 || W == 0)   
        return 0;
        
    if (dp[n][W] != -1)
        return dp[n][W];   
    
    if (wt[n - 1] > W)   
    
        // Store the value of function call   
        // stack in table before return
        return dp[n][W] = knapSackRec(W, wt, val, n - 1, dp);
                                      
    else 
    
        // Return value of table after storing  
        return dp[n][W] = max((val[n - 1] + knapSackRec(W - wt[n - 1], wt, val, n - 1, dp)), knapSackRec(W, wt, val, n - 1, dp));             
}

static int knapSack(int W, int wt[], int val[], int N)
{  
    
    // Declare the table dynamically
    int dp[][] = new int[N + 1][W + 1]; 
    
    // Loop to initially filled the 
    // table with -1 
    for(int i = 0; i < N + 1; i++)   
        for(int j = 0; j < W + 1; j++)   
            dp[i][j] = -1;    
    
    return knapSackRec(W, wt, val, N, dp);     
}

}


