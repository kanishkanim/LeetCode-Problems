public class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
    }
    
    public void addNode(Node temp){
        Node tailPrev = tail.prev;
        tailPrev.next = temp;
        temp.next = tail;
        tail.prev = temp;
        temp.prev = tailPrev;
    }
    
    private HashMap<Integer , Node> map = new HashMap<>();
    private int capacity;
    private Node head;
    private Node tail;
    
    public LRUCache(int capacity){
        this.capacity = capacity;
        
        head = new Node();
        head.prev = null;
        
        tail = new Node();
        tail.next = null;
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int popHeadNext(){
        Node temp = head.next;
        int key = temp.key;
        removeNode(temp);
        
        return key;
    }
    
    public void removeNode(Node node){
        Node tempm1 = node.prev;
        Node tempp1 = node.next;
        tempm1.next = tempp1;
        tempp1.prev = tempm1;
        node.next = null;
        node.prev = null;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node==null){
            return -1;
            
        }
        moveToTail(node);
        return node.value;
    }
    
    public void moveToTail(Node temp){
        removeNode(temp);
        addNode(temp);
    }
    
    public void put(int key, int value) {
       // Node node = map.getOrDefault(key , null);
       if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            moveToTail(node);
        }
        else{
            Node temp = new Node();
            temp.key = key ;
            temp.value = value;
            map.put(key , temp);
            addNode(temp);
            if(map.size()>capacity){
                int res = popHeadNext();
                map.remove(res);
            }
        }
        
    }
    
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */