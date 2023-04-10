package geekTime.collection;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangrucheng on 2023/4/6
 */
public class StringSolution {

    private static Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        map.put('0', 0);
    }

    public static String decodeString(String s) {
        char[] arr = s.toCharArray();

        return processSub(arr, 0, arr.length);
    }

    private static String processSub(char[] arr, int start, int end) {

        if (start == end) {
            return String.valueOf(arr[start]);
        }

        StringBuilder s = new StringBuilder();
        int temp = 0;
        for (int i = start; i < end; i++) {
            if (arr[i] >= 48 && arr[i] < 58) {
                temp = temp * 10 + map.get(arr[i]);
            } else if (arr[i] == '[') {
                int nextEnd = findIndex(arr, i, end);
                String internal = processSub(arr, i + 1, nextEnd);
                for (int j = 0; j < temp; j++) {
                    s.append(internal);
                }
                i = nextEnd;
            } else {
                s.append(arr[i]);
            }
        }
        return s.toString();
    }

    private static int findIndex(char[] arr, int begin, int end) {
        Stack<Character> stack = new Stack<>();
        for (int i = begin; i < end; i++) {
            if (arr[i] == '[') {
                stack.push('[');
            } else if (arr[i] == ']') {
                stack.pop();
            }

            if (stack.isEmpty()) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws InterruptedException {
        List<String> arrA = new ArrayList<>();
        List<String> arrB = new ArrayList<>();
        arrA.add("1");
        arrA.add("3");
        arrB.add("2");
        arrB.add("4");
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition conditionA = reentrantLock.newCondition();
        Condition conditionB = reentrantLock.newCondition();
        Thread threadA = new Thread(() -> {
            for (String s : arrA) {
               try {
                   reentrantLock.lock();
                   System.out.println(s);
                   conditionB.signal();
                   conditionA.await();
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               } finally {
                   reentrantLock.unlock();
               }
            }
        });

        Thread threadB = new Thread(() -> {
            for (String s : arrB) {
                try {
                    reentrantLock.lock();
                    System.out.println(s);
                    conditionA.signal();
                    conditionB.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    reentrantLock.unlock();
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}
