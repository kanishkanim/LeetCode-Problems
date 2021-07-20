class Solution {
    public int balancedStringSplit(String s) {
        int countR = 0, max = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'R') countR++;
            else if(s.charAt(i) == 'L') countR--; 
            
            if(countR == 0) max++;
        }
        return max;
    }
}