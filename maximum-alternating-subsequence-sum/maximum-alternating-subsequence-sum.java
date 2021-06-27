class Solution {
    public long maxAlternatingSum(int[] A) {
        long odd = 0, even = 0;
        for (int a : A) {
            even = Math.max(even, odd + a);
            odd = even - a;
        }
        return even;
    }
}