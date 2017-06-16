package queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by ezharuc on 6/9/2017.
 * Your deque implementation must support each deque operation in constant worst-case time.
 * A deque containing n items must use at most 48n + 192 bytes of memory.
 * and use space proportional to the number of items currently in the deque.
 * Additionally, your iterator implementation must support each operation (including construction) in constant worst-case time.
 *
 * @param <Item>
 *         the type parameter
 */
public class Deque<Item> implements Iterable<Item> {

    private Node first, last;
    private int n = 0;

    /**
     * Instantiates a new queue.Deque.
     * A double-ended queue or deque is a generalization of a stack and a queue that supports adding and removing items from
     * either the front or the black of the data structure.
     */
    public Deque() {

    }

    private class Node {
        /**
         * The Item.
         */
        private Item item;
        /**
         * The Next.
         */
        private Node next;

        /**
         * The Pre.
         */
        private Node prev;

        /**
         * Instantiates a new Node.
         *
         * @param item
         *         the item
         */
        Node(Item item) {
            this.item = item;
            this.next = null;
            this.prev = null;
        }
    }

    /**
     * Returns an iterator over a set of elements of type Item.
     *
     * @return an Iterator.
     */
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {

            private Node current = first;

            public boolean hasNext() {
                return current != null;
            }

            public Item next() {

                if (current == null) {
                    throw new NoSuchElementException("no such element.");
                }
                Item item = current.item;
                current = current.next;
                return item;
            }

            public void remove() {

                /* un support method */
                throw new UnsupportedOperationException("un support method.");
            }
        };
    }


    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Size int.
     *
     * @return the int
     */
    public int size() {
        return n;
    }

    /**
     * Add first.
     *
     * @param item
     *         the item
     */
    public void addFirst(Item item) {

        validate(item);
        n++;
        if (first == null) {
            first = new Node(item);
            last = first;
        } else {
            Node oldFirst = first;
            first = new Node(item);
            first.next = oldFirst;
            oldFirst.prev = first;
        }
    }

    /**
     * Remove first t.
     *
     * @return the t
     */
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("no such elements");
        }
        n--;
        Node oldFirst = first;
        first = oldFirst.next;
        if (first != null) {
            first.prev = null;
        } else {
            last = first;
        }
        oldFirst.next = null;
        oldFirst.prev = null;
        return oldFirst.item;
    }

    private void validate(Item item) {
        if (item == null) {
            throw new NullPointerException("this item cannot be null.");
        }
    }

    /**
     * Add last.
     *
     * @param item
     *         the item
     */
    public void addLast(Item item) {

        validate(item);
        n++;
        if (last == null) {
            last = new Node(item);
            first = last;
        } else {
            Node oldLast = last;
            last = new Node(item);
            oldLast.next = last;
            last.prev = oldLast;
        }
    }

    /**
     * Remove last t.
     *
     * @return the t
     */
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("no such elements");
        }
        n--;
        Node oldLast = last;
        last = oldLast.prev;
        if (last != null) {
            last.next = null;
        } else {
            first = last;
        }
        oldLast.next = null;
        oldLast.prev = null;
        return oldLast.item;
    }


    @Override
    public String toString() {

        Iterator<Item> iterator = iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            sb.append(iterator.next()).append(" ");
        }

        return sb.toString();
    }

    /**
     * The entry point of application.
     *
     * @param args
     *         the input arguments
     */
    public static void main(String[] args) {

        Deque<String> deque = new Deque<String>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("dsfg");
        deque.addLast("c");
        deque.addLast("d");
        System.out.println(deque);
        deque.removeFirst();
        deque.removeLast();
        System.out.println(deque);
        deque.removeLast();
        deque.removeLast();
        deque.removeLast();
        System.out.println(deque);
        deque.addFirst("k");
        System.out.println(deque.removeLast());
        System.out.println(deque);
    }
}
