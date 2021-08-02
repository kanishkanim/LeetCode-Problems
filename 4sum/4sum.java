class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int sum = target - nums[i] - nums[j];
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    if (start > j + 1 && nums[start] == nums[start - 1]) {
                        start++;
                        continue;
                    }
                    
                    if (nums[start] + nums[end] == sum) {
                        List<Integer> subAns = Arrays.asList(nums[i], nums[j], nums[start], nums[end]);
                        ans.add(subAns);
                        start++;
                        end--;
                    } else if (nums[start] + nums[end] < sum) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return ans;
    }
}