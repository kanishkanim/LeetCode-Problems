class Solution {
    
    public int findTheWinner(int n, int k) {
        return solution(n, k) + 1; //converting from 0th idx to 1th idx
    }
    
    public int solution(int n, int k){
        if(n == 1)
            return 0;
        int x = solution(n - 1, k); 
        int y = (x + k) % n;
        return y;
    }
}

