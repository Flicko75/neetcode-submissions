class Node {
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    private final int capacity;

    private final HashMap<Integer, Node> map; 

    private final Node leftDummy;

    private final Node rightDummy;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        leftDummy = new Node(0, 0);
        rightDummy = new Node(0, 0);

        leftDummy.next = rightDummy;
        rightDummy.prev = leftDummy;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        node.prev = rightDummy.prev;
        rightDummy.prev.next = node;
        rightDummy.prev = node;
        node.next = rightDummy;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        remove(node);
        insert(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        Node node = new Node(key, value);
        map.put(key, node);

        insert(node);

        if (map.size() > capacity) {
            Node lru = leftDummy.next;

            map.remove(lru.key);
            remove(lru);
        }
    }
}
