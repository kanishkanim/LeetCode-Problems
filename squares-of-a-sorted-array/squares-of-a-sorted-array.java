class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        
        int i = 0;
        int j = nums.length - 1;
        
        for(int k = j; k >= 0; k--){
            int val1 = nums[i] * nums[i];
            int val2 = nums[j] * nums[j];
            
            if(val1 > val2){
                res[k] = val1;
                i++;
            }else{
                res[k] = val2;
                j--;
            }
        }
        return res;
    }
}