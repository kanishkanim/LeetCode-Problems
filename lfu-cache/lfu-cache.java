class LFUCache {

    class Node{
        Node prev;
        Node next;
        int key;
        int value;
        int freq;
        
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.freq = 0;
        }
    }
    
    class DLL{
        Node head;
        Node tail;
        int size;
        
        public DLL(){
            this.head = new Node(-1,-1);
            this.tail = new Node(-1,-1);
            this.size = 0;
            this.head.next = tail;
            this.tail.prev = head;
        }
        
        public Node removeNode(Node node){
            Node nextNode = node.next;
            Node prevNode = node.prev;
            nextNode.prev = node.prev;
            prevNode.next = node.next;
            node.next = null;
            node.prev = null;
            this.size--;
            return node;
        }
        
        public void addToHead(Node node){
            node.next = this.head.next;
            this.head.next = node;
            node.prev = head;
            node.next.prev = node;
            this.size++;
        }
        
        public Node removeFromTail(){
            Node node = this.tail.prev;
            this.tail.prev = node.prev;
            this.tail.prev.next = tail;
            node.next = null;
            node.prev = null;
            this.size--;
            return node;
        }
    }
    
    Map<Integer,Node> map;
    Map<Integer,DLL> freqMap;
    int capacity;
    int numberOfNodes;
    int minFreq;
    
    public LFUCache(int c) {
        map = new HashMap<>();
        freqMap = new HashMap<>();
        capacity = c; 
        numberOfNodes = 0;
    }
    
    public int get(int key) { 
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        update(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node;
        if (map.containsKey(key)){
            node = map.get(key);
            node.value = value;
        } else {
            numberOfNodes++;
            System.out.println("MIN:" + minFreq);
            if (capacity == 0) return;
            if (numberOfNodes>capacity){
                DLL minDLL = freqMap.getOrDefault(minFreq, new DLL());
                Node minNode = minDLL.removeFromTail();
                map.remove(minNode.key);
                numberOfNodes--;
            }
            node = new Node(key,value);
            map.put(key,node);
            DLL newDLL = freqMap.getOrDefault(node.freq, new DLL());
            newDLL.addToHead(node);
            freqMap.put(node.freq, newDLL);
        }
        update(node);
    }
    
    public void update(Node node){
        int oldFreq = node.freq;
        DLL oldDLL = freqMap.get(oldFreq);
        
        oldDLL.removeNode(node);
        
        int newFreq = oldFreq+1;
        
        if (minFreq == oldFreq && oldDLL.size == 0)
            minFreq = newFreq;
        else if (newFreq < minFreq)
            minFreq = newFreq;
        
        if (freqMap.containsKey(newFreq)){
            DLL newDLL = freqMap.get(newFreq);
            newDLL.addToHead(node);
        } else {
            DLL newDLL = new DLL();
            newDLL.addToHead(node);
            freqMap.put(newFreq, newDLL);
        } 
        node.freq = newFreq;
    }
}