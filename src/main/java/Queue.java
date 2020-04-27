import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<T> implements Iterable<T> {
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
        N++;
    }

    /**
     * Pop t.
     *
     * @return the t
     */
    public T dequeue() {
        if (isEmpty()) return null;
        N--;
        Node<T> oldHead = head;
        head = oldHead.next;
        if (isEmpty()) tail = null;
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
                return N > 0;
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

    public static void main(String[] args) { // Create a queue and enqueue/dequeue strings.
        Queue<String> q = new Queue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                q.enqueue(item);
            else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
        }
        StdOut.println("(" + q.size() + " left on queue)");
    }
}
