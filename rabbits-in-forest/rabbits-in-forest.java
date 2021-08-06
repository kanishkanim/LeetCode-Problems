class Solution {
    public int numRabbits(int[] arr) {
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) +1);
        }
        
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
           count = count + ((e.getKey() + 1) * (e.getValue() / (e.getKey() + 1)));
            if(e.getValue() % (e.getKey() + 1) != 0){
                count += e.getKey() + 1;
            }
            
        }
        return count;
    }
}