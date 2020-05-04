package queue;

import java.util.NoSuchElementException;

public class Josephus<T> {

    private long N = 0;
    private Node<T> head;
    private Node<T> tail;

    /**
     * Push.
     *
     * @param t the t
     */
    public void enqueue(T t) {
        Node<T> node = new Node<>();
        node.item = t;
        if (tail == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        tail.next = head;
        N++;
    }

    /**
     * Pop t.
     *
     * @return the t
     */
    public T dequeue() {
        if (N == 1) throw new NoSuchElementException();
        N--;
        Node<T> oldHead = head;
        head = oldHead.next;
        tail.next = head;
        return oldHead.item;
    }

    public T findNode(Node<T> p, int step) {
        while (N > 1) {
            for (int i = 1; i < step; i++) {
                head = head.next;
                tail = tail.next;
            }
            System.out.println(dequeue());
        }
        return head.item;
    }

    /**
     * Size long.
     *
     * @return the long
     */
    public long size() {
        return N;
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return N == 0;
    }

    private class Node<T> {
        private T item;
        private Node<T> next;
    }

    public static void main(String[] args) {
        int N = 7;
        int M = 2;
        Josephus<Integer> josephus = new Josephus<>();
        for (int i = 0; i < N; i++) {
            josephus.enqueue(i);
        }
        System.out.println("head is: " + josephus.head.item);
        System.out.println("tail is : " + josephus.tail.item);
        Integer find = josephus.findNode(josephus.head, M);
        System.out.println("final is: " + find);
    }
}
