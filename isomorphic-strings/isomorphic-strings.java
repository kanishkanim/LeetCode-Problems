class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() == 0 && t.length() == 0){
            return true;
        }
        
        if(s.length() != t.length()){
            return false;
        }
        
        HashMap<Character,Character> map = new HashMap<Character,Character>();
        for(int i = 0; i <= s.length() - 1; i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i)) != t.charAt(i)){
                    return false;
                }
            }else{
                if(map.containsValue(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }
        }
      return true;
    }
}