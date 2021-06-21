class Solution {
    
    Map<String, Boolean> dp = new HashMap<>();
    
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        
        if(s1.equals(s2)) return true;
        
        String key = s1 + "*" + s2;
        if(dp.containsKey(key)) return dp.get(key);
        
        int len = s1.length();
        for(int i=1; i<len; i++) {
            if( (isScramble(s1.substring(0, i), s2.substring(0,i)) && isScramble(s1.substring(i), s2.substring(i)) ) 
               || ( isScramble(s1.substring(0, i), s2.substring(len-i) ) && isScramble(s1.substring(i), s2.substring(0, len-i)) ) ) {
                dp.put(key, true);
                return true;
            }
        }
        
        dp.put(key, false);
        return false;
    }
}