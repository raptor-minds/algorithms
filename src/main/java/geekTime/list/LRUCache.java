package geekTime.list;

class LRUCache {

    private int capacity = 0;
    private int count = 0;

    LRUNode head = null;
    LRUNode tail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        LRUNode p = head;
        while (p != null) {
            if (p.key == key) {
                //remove key from this position
                if (p == head) {
                    LRUNode newHead = p.next;
                    p.next = null;
                    tail.next = p;
                    p.pre = tail;
                    tail = p;
                    head = newHead;
                    return p.data;
                } else if (p == tail) {
                    return p.data;
                } else {
                    LRUNode pNext = p.next;
                    p.pre.next = pNext;
                    pNext.pre = p.pre;
                    tail.next = p;
                    p.pre = tail;
                    p.next = null;
                    tail = p;
                    return p.data;
                }
            }
            p = p.next;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (head == null) {
            head = new LRUNode(key, value, null, null);
            tail = head;
            return;
        }

        LRUNode p = head;
        while (p != null) {
            if (p.key == key) {
                //remove key from this position
                if (p == tail) {
                    p.data = value;
                    return;
                } else if (p == head) {
                    head = p.next;
                } else {
                    LRUNode pNext = p.next;
                    p.pre.next = pNext;
                    pNext.pre = p.pre;
                }
                count--;
            }
            p = p.next;
        }

        // each time add one new node to the tail position
        LRUNode node = new LRUNode(key, value, tail, null);
        tail.next = node;
        tail = node;

        if (count > capacity) {
            head = head.next;
            count--;
        }
    }

    private class LRUNode {
        LRUNode pre;
        LRUNode next;
        int key;
        int data;

        public LRUNode(int key, int value, LRUNode pre, LRUNode next) {
            this.key = key;
            this.data = value;
            this.pre = pre;
            count++;
        }
    }

    public void printLRUNode() {
        System.out.println("count is " + count);
        LRUNode p = head;
        while (p != null) {
            System.out.print(p.key + "v: " + p.data + "--->");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */);

        cache.put(2, 1);
        cache.printLRUNode();
        cache.put(1, 1);
        cache.printLRUNode();
        cache.put(2, 3);    // 该操作会使得密钥 2 作废
        cache.printLRUNode();
        cache.put(4, 1);    // 该操作会使得密钥 1 作废
        cache.printLRUNode();
        System.out.println(cache.get(1));        // 返回 -1 (未找到)
        System.out.println(cache.get(2));        // 返回  3
    }
}