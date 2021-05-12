package geekTime.middle;

import java.util.HashMap;

public class LRUCache {

    private class Node {
        Node prev;
        Node next;
        int key;
        int value;
    }

    private final HashMap<Integer, Node> map;

    private final int capacity;

    private int size;

    private Node head = null, tail = null;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            // move to tail
            Node node = map.get(key);

            node.prev.next = node.next;
            node.next.prev = node.prev;

            // add to tail
            node.prev = tail.prev;
            tail.prev.next = node;

            tail.prev = node;
            node.next = tail;
            print();
            return map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = new Node();
        node.value = value;
        node.key = key;

        tail.prev.next = node;
        node.prev = tail.prev;

        tail.prev = node;
        node.next = tail;

        size++;

        if (map.containsKey(key)) {
            Node removeNode = map.get(key);
            removeNode.prev.next = removeNode.next;
            removeNode.next.prev = removeNode.prev;
            size--;
        } else if (size > capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
            size--;
        }
        print();
        map.put(key, node);
    }
    public void print() {
        Node node = head;
        int i = 0;
        System.out.println("-----------------");
        while (i <= size) {
            System.out.print(node.value + " ");
            node = node.next;
            i++;
        }
        System.out.println();
        System.out.println("+++++++++++++++++");
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(10);
        lruCache.put(10, 13);
        lruCache.put(3, 17);
        lruCache.put(6, 11);
        lruCache.put(10, 5);
        lruCache.put(9, 10);
        lruCache.get(13);
        lruCache.put(2, 19);
        lruCache.get(2);
        lruCache.get(3);
        lruCache.put(5, 25);
        lruCache.get(8);
        lruCache.put(9, 22);
        lruCache.put(5, 5);
        lruCache.put(1, 30);
        lruCache.get(11);
//        lruCache.get(1);
//        System.out.println(lruCache.get(4));
//        System.out.println(lruCache.get(3));
//        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(1));
        lruCache.put(5, 5);

//        System.out.println(lruCache.get(1));
//        System.out.println(lruCache.get(2));
//        System.out.println(lruCache.get(3));
//        System.out.println(lruCache.get(4));
//        System.out.println(lruCache.get(5));
    }
}

