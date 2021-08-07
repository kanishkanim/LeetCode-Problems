class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int val = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                val = nums[i]; break;
            }else{
                map.put(nums[i], 1);
            }
        }
        return val;
    }
}