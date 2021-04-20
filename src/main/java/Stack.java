//import edu.princeton.cs.algs4.StdIn;
//import edu.princeton.cs.algs4.StdOut;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.NoSuchElementException;
//
///**
// * Created by ezharuc on 6/8/2017.
// *
// * @param <T> the type parameter
// */
//public class Stack<T> implements Iterable<T> {
//
//    private long N = 0;
//    private Node<T> head;
//
//    /**
//     * Push.
//     *
//     * @param t the t
//     */
//    public void push(T t) {
//        Node<T> node = new Node<>();
//        node.item = t;
//        node.next = head;
//        head = node;
//        N++;
//    }
//
//    /**
//     * Pop t.
//     *
//     * @return the t
//     */
//    public T pop() {
//        if (isEmpty()) return null;
//        N--;
//        Node<T> oldHead = head;
//        head = oldHead.next;
//        return oldHead.item;
//    }
//
//    /**
//     * Size long.
//     *
//     * @return the long
//     */
//    public long size() {
//        return N;
//    }
//
//    /**
//     * Is empty boolean.
//     *
//     * @return the boolean
//     */
//    public boolean isEmpty() {
//        return N == 0;
//    }
//
//    private static class Node<T> {
//
//        private T item;
//        private Node<T> next;
//    }
//
//
//    @Override
//    public Iterator<T> iterator() {
//        return new Iterator<T>() {
//            @Override
//            public boolean hasNext() {
//                return N > 0;
//            }
//
//            @Override
//            public T next() {
//                if (!hasNext()) throw new NoSuchElementException("no such element");
//                Node<T> oldHead = head;
//                head = oldHead.next;
//                return oldHead.item;
//            }
//        };
//    }
//
//    /**
//     * The entry point of application.
//     *
//     * @param args the input arguments
//     */
//    public static void main(String[] args) {
//        Stack<String> stack = new Stack<>();
//        String s;
//        s.to
//        while (!StdIn.isEmpty()) {
//            String item = StdIn.readString();
//            if (!item.equals("-"))
//                stack.push(item);
//            else if (!stack.isEmpty())
//                StdOut.print(stack.pop() + " ");
//        }
//        StdOut.println("(" + stack.size() + " left on stack)");
//    }
//}
