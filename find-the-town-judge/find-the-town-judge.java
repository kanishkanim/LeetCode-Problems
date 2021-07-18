class Solution {
    public int findJudge(int n, int[][] trust) {
       
        int visited[] = new int[n+1];
        
        for(int i = 0; i < trust.length; i++){
            visited[trust[i][0]]--;  //outgoing edge
            visited[trust[i][1]]++;  //incoming edge
        }
        for(int i = 1; i < visited.length; i++){
            if(visited[i] == n-1)   return i;
        }
        return -1;
    }
}