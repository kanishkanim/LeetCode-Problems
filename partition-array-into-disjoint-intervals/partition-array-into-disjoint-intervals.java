class Solution {
    public int partitionDisjoint(int[] nums) {
        
        int cmax = nums[0]; //current maximum
        int nmax = nums[0]; //next maximum
        int ans = 0;
        
        for(int i = 0; i < nums.length; i++){
            int val = nums[i];
            nmax = Math.max(val, nmax);
            
            if(val < cmax){
                ans = i;
                cmax = nmax;
            }
        }
        return ans + 1; // length = last idx + 1
    }
}