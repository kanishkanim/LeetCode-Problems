class Solution {
    
    HashMap<Character, Integer> orderedMap = new HashMap<>();
    
    public boolean isAlienSorted(String[] words, String order) {
        
        if(words == null || order == null || words.length == 0 || order.length() == 0){
            return false;
        }
        
        for(int i = 0; i <= order.length() - 1; i++){
            orderedMap.put(order.charAt(i), i);
        }
        
        for(int i = 0; i < words.length - 1; i++){
            if(isOrdered(words[i], words[i + 1])) return false;
        }
        return true;
    }

    public boolean isOrdered(String first, String second) {
       
        for(int i = 0; i < first.length() && i < second.length(); i++){
            int fi = orderedMap.get(first.charAt(i));
            int si = orderedMap.get(second.charAt(i));
            
            if(fi != si){
                return fi > si;
            }
        }
        return first.length() > second.length();
    }
}

