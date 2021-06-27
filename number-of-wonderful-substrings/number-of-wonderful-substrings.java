class Solution {
    public long wonderfulSubstrings(String word) {
        
        Map<Integer, Long> map = new HashMap<>();
        map.put(0, 1L);
        long res = 0;
        int cur = 0;
        for (char c : word.toCharArray()) {
            cur = cur ^ (1 << (c-'a'));
            res += map.getOrDefault(cur, 0L);
            for (int i = 0; i < 10; i++) {
                cur = cur ^ (1 << i);
                res += map.getOrDefault(cur, 0L);
                cur = cur ^ (1 << i);
            }
            map.put(cur, map.getOrDefault(cur, 0L)+1);
        }
        return res;
    }
}