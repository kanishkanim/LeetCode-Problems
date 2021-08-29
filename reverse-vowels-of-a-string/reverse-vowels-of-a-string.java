class Solution {
    
    public static boolean isVowel(char[] arr, int idx){
        
        char ch = arr[idx];
        
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
            return true;
        }
        return false;
    }
    
    public static void swap(char[] arr, int left, int right){
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
    
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        
        int left = 0;
        int right = arr.length - 1;
        
        while(left < right){
            //left -> vowel
            while(left < right && isVowel(arr, left) == false){
                left++;
            }
            
            //right -> vowel
            while(left < right && isVowel(arr, right) == false){
                right--;
            }
            
            swap(arr, left, right);
            left++;
            right--;
        }
        
        String string = "";
        for(char ch : arr){
            string += ch;
        }
        return string;
    }
}