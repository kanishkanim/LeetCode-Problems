class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        Set set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int current = num;
                int longSeq = 1;
                while (set.contains(current+1)) {
                    current++;
                    longSeq++;
                }
                max = Math.max(max,longSeq);
            }
        }       
        return max;
    }
}
