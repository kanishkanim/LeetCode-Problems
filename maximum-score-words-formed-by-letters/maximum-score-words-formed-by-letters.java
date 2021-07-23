class Solution {
    
    public int findMaxScore(String[] words, int[] freqChar, int[] score, int idx){
        if(idx == words.length){
            return 0;
        }
        
        //if word is not included
        int sno = findMaxScore(words, freqChar, score, idx + 1);
        
        //if word is included
        int sword = 0;
        String word = words[idx];
        boolean flag = true; //if yes call can be made
        
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
        
            if(freqChar[ch - 'a'] == 0)
                flag = false;
            freqChar[ch - 'a']--;
            sword += score[ch - 'a'];
        }
    
    int syes = 0;
    if(flag)
        syes = sword + findMaxScore(words, freqChar, score, idx + 1);
    
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            freqChar[ch - 'a']++;
    }
        
    return Math.max(sno, syes);
  }
        
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freqChar = new int[score.length];
        for(char ch : letters){
            freqChar[ch - 'a']++;
        }
        return findMaxScore(words, freqChar, score, 0);
    }
}