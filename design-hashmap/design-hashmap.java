class MyHashMap {
    
    class KV{
        int key,value;
       KV(int key, int value){
            this.key=key;
            this.value=value;
        }
    }

    List<KV>[] map;

    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new List[10000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = key % 10000;
        if(map[hash]==null) map[hash]= new ArrayList<>();
        for(KV p:map[hash]){
            if(p.key==key) {
                p.value=value;
                return;
            }
        }
        map[hash].add(new KV(key,value));
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = key % 10000;
        if(map[hash]==null) return -1;
        for(KV p:map[hash]) if(p.key==key) return p.value;
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = key % 10000;
        if(map[hash]==null) return;
        for(int i = 0;i<map[hash].size();i++){
            if(map[hash].get(i).key==key) {
                map[hash].remove(i);
                return;
            }
        }
    }  
}