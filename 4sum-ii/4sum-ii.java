class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        for(int e1 : nums1){
            for(int e2 : nums2){
                map.put(e1 + e2, map.getOrDefault(e1 + e2, 0) + 1);
            }
        }
        
        int target = 0;
        for(int e1 : nums3){
            for(int e2 : nums4){
                count += map.getOrDefault(target - (e1 + e2), 0);
            }
        }
        return count;
    }
}