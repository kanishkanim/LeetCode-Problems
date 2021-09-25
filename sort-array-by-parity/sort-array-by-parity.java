class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0; //first unsolved
        int j = 0; //first odd
        
        while(i < nums.length){
            if(nums[i] % 2 == 0){
                // even -> swap, i++, j++
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                
                i++; j++;
            }else{
                //odd -> i++;
                i++;
            }
        }
        return nums;
    }
}