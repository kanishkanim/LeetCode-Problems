class Solution {
    public List<List<String>> groupAnagrams(String[] s){
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < s.length; i++){
            char[] strChar = s[i].toCharArray();
            Arrays.sort(strChar);
            
            String newString = new String(strChar);
            List<String> newList = map.getOrDefault(newString, new ArrayList<>());
            newList.add(s[i]);
            map.put(newString, newList);
        }
        return new ArrayList<> (map.values());
    }
}