class Solution {
    public boolean areOccurrencesEqual(String s) {
         
        if(s.length()==1)
        return true;
      
        int a[]=new int[26];

        for(int i=0;i<s.length();i++)
        a[s.charAt(i)-'a']++;
        
        for(int i=0;i<s.length()-1;i++)
        if(a[s.charAt(i)-'a']!=a[s.charAt(i+1)-'a'])
        return false;
            
        return true;   
    }
}