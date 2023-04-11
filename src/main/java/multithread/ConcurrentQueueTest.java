package multithread;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

/**
 * @author zhangrucheng on 2023/4/11
 */
public class ConcurrentQueueTest {

    private static final Queue<String> tickets = new ConcurrentLinkedQueue<>();

    static {
        for (int i = 0; i < 100000; i++) {
            tickets.offer("ticket " + i);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    String poll = tickets.poll();
                    if (poll == null) {
                        countDownLatch.countDown();
                        System.out.println(Thread.currentThread().getName() + " count down ");
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + " " + poll);
                }
            }).start();
        }
        countDownLatch.await();
        System.out.println(tickets.size());
        System.in.read();
    }
}
