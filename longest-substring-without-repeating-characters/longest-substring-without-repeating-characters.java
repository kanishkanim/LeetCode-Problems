class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()) return 0;
        int max = 0;
        int start = 0, end = 0;

        char[] arr = s.toCharArray();
        while (start < arr.length && end < arr.length) {
            int index = isWithinWindow(start, end, arr, arr[end]);
            if(index != -1) {
                start = index + 1;
            }
            max = Math.max(max, end - start + 1);
            end++;
        }

        return max;
    }

    int isWithinWindow(int start, int end, char[] arr, char c) {
        for(int i = start; i < end; i++) {
            if(arr[i] == c) return i;
        }
        return -1;
    }
}