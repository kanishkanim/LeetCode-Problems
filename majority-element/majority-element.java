class Solution {
    public int majorityElement(int[] nums) {
        int count=1;
        int tempMajority=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==tempMajority){
               count++;
            }else{
               count--;
            }
            if(count==0){
                tempMajority=nums[i];
               count=1;
            }
        }
        return tempMajority;
    }
}