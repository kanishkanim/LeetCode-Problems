class Solution {
    
    public static boolean isMajority(int[] nums, int val) {
        int count = 0;
        
        for(int ele : nums) {
            if(ele == val)
                count++;
        }
        
        return count > nums.length / 3;
    }
    
    public List<Integer> majorityElement(int[] nums) {
        int val1 = nums[0];
        int count1 = 1;
        int val2 = nums[0];
        int count2 = 0;
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == val1){
                count1++;
            }else if(nums[i] == val2){
                count2++;
            }else{
                // might be a triplet or a fresh start
                if(count1 == 0){
                    val1 = nums[i];
                    count1 = 1;
                }else if(count2 == 0){
                    val2 = nums[i];
                    count2 = 1;
                }else{
                    count1--;
                    count2--;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        
        //checking if val1 and val2 are present in majority or not
        if(isMajority(nums, val1)){
            res.add(val1);
        }
        if(val1 != val2 && isMajority(nums, val2) == true){
            res.add(val2);
        }
        return res;
    }
}