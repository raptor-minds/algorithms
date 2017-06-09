import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ezharuc on 6/8/2017.
 */
public class Stack {

    public static void main(String[] args) {
        edu.princeton.cs.algs4.Stack stack = new edu.princeton.cs.algs4.Stack();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-")) {
                StdOut.print(stack.pop());
            } else {
                stack.push(s);
            }
        }
    }
}
