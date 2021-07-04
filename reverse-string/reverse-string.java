class Solution {
    public void reverseString(char[] s) 
    {
        int i;
        char temp;
        for(i=0;i<s.length/2;i++)
        {
            temp=s[i];
            s[i]=s[s.length-i-1];
            s[s.length-i-1]=temp;
        }
    }
}