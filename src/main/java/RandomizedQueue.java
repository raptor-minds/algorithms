import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by ezharuc on 6/9/2017.
 * A randomized queue is similar to a stack or queue,
 * except that the item removed is chosen uniformly at random from items in the data structure.
 *
 * @param <Item>
 *         the type parameter
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private int n = 0; // number of elements in the queue.
    private int capacity;
    private Item[] queue;

    /**
     * Instantiates a new Randomized queue.
     */
    public RandomizedQueue() {

        capacity = 1;

        queue = (Item[]) new Object[capacity];
    }


    /**
     * Returns an iterator over a set of elements of type T.
     *
     * @return an Iterator.
     */
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {

            private int current = 0;

            private int[] shuffledIndexes = new int[n];

            {
                for (int i = 0; i < n; i++) {
                    shuffledIndexes[i] = i;
                }

                StdRandom.shuffle(shuffledIndexes);
            }

            public boolean hasNext() {
                return current != n;
            }

            public Item next() {

                if (size() == 0 || current >= n) {
                    throw new NoSuchElementException("no such element.");
                }
                return queue[shuffledIndexes[current++]];
            }

            public void remove() {

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
     * Enqueue, add the item.
     *
     * @param item
     *         the item
     */
    public void enqueue(Item item) {

        validate(item);

        if (n + 1 > capacity) {
            resizePlus();
        }
        queue[n++] = item;
    }

    private void resizePlus() {

        capacity = capacity * 2;
        Item[] newQueue = (Item[]) new Object[capacity];
        int index = 0;
        for (Item i : queue) {
            newQueue[index++] = i;
        }

        queue = newQueue;
    }


    /**
     * Dequeue item, remove and return a random item.
     *
     * @return the item
     */
    public Item dequeue() {

        if (isEmpty()) {
            throw new NoSuchElementException("no such elements");
        }

        int index = StdRandom.uniform(n);
        Item item = queue[index];

        queue[index] = queue[--n];
        queue[n] = null;
        if (capacity / 4 > n) {
            resizeMin();
        }
        return item;
    }

    private void resizeMin() {
        capacity /= 2;

        Item[] newQueue = (Item[]) new Object[capacity];
        int index = 0;
        for (int i = 0; i < n; i++) {
            newQueue[index++] = queue[i];
        }

        queue = newQueue;
    }

    /**
     * Sample item, return (but do not remove) a random item.
     *
     * @return the item
     */
    public Item sample() {

        if (isEmpty()) {
            throw new NoSuchElementException("no such elements");
        }

        int index = StdRandom.uniform(n);
        return queue[index];
    }


    @Override
    public String toString() {

        Iterator<Item> iterator = iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            sb.append(iterator.next()).append("\n");
        }

        return sb.toString();
    }

    private String toMyString() {

        Iterator<Item> iterator = iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            sb.append(iterator.next()).append("\n");
        }

        return sb.toString();
    }

    private void validate(Item item) {
        if (item == null) {
            throw new NullPointerException("this item cannot be null.");
        }
    }


    /**
     * The entry point of application.
     *
     * @param args
     *         the input arguments
     */
    public static void main(String[] args) {

        RandomizedQueue queue = new RandomizedQueue();
        queue.enqueue("bbb");
        queue.enqueue("aaa");
        queue.enqueue("ccc");
        queue.enqueue("ddd");
        queue.enqueue("eee");
        System.out.println(queue);
        System.out.println(queue.toMyString());
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);
    }
}
