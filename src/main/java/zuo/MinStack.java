package zuo;

import java.util.Comparator;
import java.util.Stack;

/**
 * @author zhangrucheng on 2023/4/7
 */
public class MinStack<T extends Comparable<T>> {

    private Stack<T> stack = new Stack<>();
    private Stack<T> minStack = new Stack<>();

    public void push(T t) {
        stack.push(t);
        if (minStack.peek().compareTo(t) >= 0) {
            minStack.push(t);
        }
    }

    public T pop() {
        T pop = stack.pop();
        if (pop == minStack.peek()) {
            minStack.pop();
        }
        return pop;
    }

    public T getMin() {
        return minStack.peek();
    }
}
