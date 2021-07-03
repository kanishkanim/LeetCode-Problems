class Solution {
    public int missingNumber(int[] nums) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
            map.put(nums[i], 1);
        
        for(int i = 0; i < map.size(); i++)
        {
            //then that number is missing
            if(!map.containsKey(i + 1)) return i + 1;   
        }
        return 0;
    }
}