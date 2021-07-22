class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        for(int i = digits.length - 1; i >= 0; i--){
            carry = (digits[i] + 1) / 10;
            digits[i] = (digits[i] + 1) % 10;
            if (carry == 0) 
                return digits;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}