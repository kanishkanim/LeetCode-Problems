class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String str[] = text.split(" ");
        int count = 0;
        for(String a : str){
            for(Character b : brokenLetters.toCharArray()){
                if(a.indexOf(b) != -1){
                    count++;
                    break;
                }
            }
        }
        return str.length - count;
    }
}