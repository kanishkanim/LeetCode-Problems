class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int N = A.length;
        int i, j, sum = 0, c1, c2;
	    
        for(i = 0; i < N; i++){
            sum += A[i];
        }
        
        if(sum % 3 != 0)
            return false;
        else{
            c1 = 0;
            for(i = 0; i < N; i++){
                c1 += A[i];
                if(c1 == (sum/3)){
                    c2 = 0;
                    for(j = i + 1; j < N; j++){
                        c2 += A[j];
                        if(c2 == c1 && j < N - 1)
                            return true;                                                 
                     }  
                }
            }
            
            return false;
        }
    }
}
