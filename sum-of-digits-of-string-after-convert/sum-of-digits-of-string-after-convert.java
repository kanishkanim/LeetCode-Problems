class Solution {
    public int getLucky(String s, int k) {
        String number =  "";
        for(int i = 0; i<s.length();i++){
            number += Integer.toString(s.charAt(i) - 'a' + 1);
        }
        int sum = 0;
        while(k > 0){
            for(int i=0;i<number.length();i++){
                sum = sum + Integer.parseInt(number.charAt(i)+"");
            }
            number = String.valueOf(sum);
            sum = 0;
            k--;
        }
        return Integer.parseInt(number);
        
    }
}