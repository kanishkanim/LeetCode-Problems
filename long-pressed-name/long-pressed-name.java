class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if(name.length() > typed.length()) return false;
        
        int i = 0; // i is for name
        int j = 0; // j is for typed
        
        while(i < name.length() && j < typed.length()){
            if(name.charAt(i) == typed.charAt(j)){
                i++; j++;
            }else if(i - 1 >= 0 && name.charAt(i - 1) == typed.charAt(j)){
                j++;
            }else{
                return false;
            }
        }
        
        while(j < typed.length()){
            if(typed.charAt(j) != name.charAt(i - 1)) return false;
            j++;
        }
        
        return i < name.length() ? false : true;
    }
}