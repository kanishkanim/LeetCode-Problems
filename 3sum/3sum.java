class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        
        for(int i = nums.length - 1; i >= 2; i -- ){
            int target = -nums[i];
            // skip, if the targets are the same. 
            if(i < nums.length - 1 && target == -nums[i+1]){
                continue;
            }
            int left = 0;
            int right = i - 1;
            twoSum(nums, target, left, right, ans);
        }
        return ans;
    }
    
    void twoSum(int[] nums, int target, int left, int right, List<List<Integer>> ans){
        // share one List<List<Integer>> ans. 
        while(left < right){
            if(nums[left]+nums[right]==target){
                List<Integer> a = new ArrayList();
                a.add(nums[left]);
                a.add(nums[right]);
                a.add(-target);
                ans.add(a);
                left ++;
                right --;
                // check if two elements in a row are the same. 
                while(left < right && nums[left] == nums[left-1]){
                    left ++;
                }
                while(left < right && nums[right] == nums[right+1]){
                    right --; 
                }
            }else if(nums[left]+nums[right]<target){
                left ++;
            }else{
                right --;
            }
        }
    }
}