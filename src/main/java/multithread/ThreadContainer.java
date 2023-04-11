package multithread;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangrucheng on 2023/4/10
 */
public class ThreadContainer<T> {

    private int size = 0;
    private final LinkedList<T> list = new LinkedList<>();

    private final int MAX_SIZE = 10;

    public synchronized void put(T t) {
        while (size == MAX_SIZE) {
            try {
                System.out.println("I am full ..." + Thread.currentThread().getName());
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        list.add(t);
        size++;
        notifyAll();
    }

    public synchronized T get() {
        while (size == 0) {
            try {
                System.out.println("I am empty ..." + Thread.currentThread().getName());
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        T t = list.removeFirst();
        System.out.println(t);
        size--;
        notifyAll();
        return t;
    }

    public synchronized int getCount() {
        return size;
    }

    public static void main(String[] args) {
        ThreadContainer<String> stringThreadContainer = new ThreadContainer<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    stringThreadContainer.put("producer" + finalI + j);
                }
            }, "producer" + i).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                while (true) {
                    String s = stringThreadContainer.get();
                    System.out.println(s);
                }
            }, "consumer" + i).start();
        }

//        for (int i = 0; i < 100; i++) {
//            new Thread(() -> {
//                while (true) {
//                    int s = stringThreadContainer.getCount();
//                    System.out.println(s);
//                }
//            }, "counter" + i).start();
//        }
    }

}
