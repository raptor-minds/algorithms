package queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircleQueue<T> implements Iterable<T> {

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

    private static class Node<T> {
        private T item;
        private Node<T> next;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return N > 1;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException("error");
                Node<T> oldHead = head;
                head = oldHead.next;
                return oldHead.item;
            }
        };
    }
}
