class Solution {
    public int countSpecialSubsequences(int[] nums) {
        double sum0 = 0;
        double sum1 = 0;
        double sum2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                sum0 = ((sum0 + 1) + sum0) % ((int)(1e9) + 7);
            } else if (nums[i] == 1){
                sum1 = ((sum0 + sum1) + sum1) % ((int)(1e9) + 7);
            } else if (nums[i] == 2){
                sum2 = ((sum1 + sum2) + sum2) % ((int)(1e9) + 7);
            }
        }
        return (int)sum2 % ((int)(1e9) + 7);
    }
}