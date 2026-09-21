public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

public class LRUCache {

    private Map<Integer, Node> map;
    private Node front;
    private Node back;
    private int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
        this.front = new Node(0, 0);
        this.back = new Node(0, 0);
        this.front.next = this.back;
        this.back.prev = this.front;
    }

    private void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insertToFront(Node node){
        Node next = this.front.next;
        node.next = next;
        next.prev = node;
        this.front.next = node;
        node.prev = this.front;
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insertToFront(node);
            
            return node.val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            remove(map.get(key));
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insertToFront(newNode);

        if (map.size() > cap){
            Node lru = this.back.prev;
            remove(lru);
            map.remove(lru.key);
        }
    }
}
