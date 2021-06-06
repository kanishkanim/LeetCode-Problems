class Solution {
    public int minOperations(int[] nums, int x) {
        int target = -x;
        
        for (int num : nums) target += num;

        if (target == 0) return nums.length;  
        
        int begin = 0;
        int end = 0;
        int res = Integer.MIN_VALUE;
        int sum = 0;
        
        while(end < nums.length) {
            sum += nums[end++];
            while(sum > target && begin < end) {
                sum -= nums[begin++];
            }
            if(sum == target) res = Math.max(res, end-begin);
        }
        return res == Integer.MIN_VALUE ? -1 : nums.length-res;
    }
}