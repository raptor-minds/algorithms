package percolation.fundamentals;

public class RingBuffer<T> {
    private int N;

    private int head;

    private int tail;

    private Object[] ringBuffer;

    public RingBuffer(int length) {
        ringBuffer = new Object[length];
        this.N = length;
    }

    public synchronized void push(T t) {
        if (isFull()) {
            System.out.println("it's full !");
            return;
        }

        ringBuffer[head++] = t;
        if (head - N == 0) {
            head = head - N;
        }
    }

    public synchronized boolean isFull() {
        if (head < tail) {
            return false;
        }
        return head - tail == N;
    }

    public synchronized boolean isEmpty() {
        return tail == head;
    }

    public synchronized int size() {
        if (head < tail) {
            return head + N -tail;
        }
        return head - tail;
    }

    public synchronized T pop() {
        if (isEmpty()) {
            System.out.println("it's empty !");
            return null;
        }
        T temp = (T) ringBuffer[tail++];
        if (tail - N == 0) {
            tail -= N;
        }
        return temp;
    }

    public static void main(String[] args) {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(10);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Integer i = 0;
                while (true) {
                    ringBuffer.push(i + 10);
                    System.out.println("thread1 head :" + ringBuffer.head + "tail is : " + ringBuffer.tail + "size is : " + ringBuffer.size());
                    i++;
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                Integer i = 0;
                while (true) {
                    ringBuffer.push(i + 30);
                    System.out.println("thread3 head :" + ringBuffer.head + "tail is : " + ringBuffer.tail + "size is : " + ringBuffer.size());
                    i++;
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(ringBuffer.pop());
                    System.out.println("thread2 head :" + ringBuffer.head + "tail is : " + ringBuffer.tail + "size is : " + ringBuffer.size());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }

}
