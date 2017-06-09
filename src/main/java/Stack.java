import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ezharuc on 6/8/2017.
 */
public class Stack {

    List<String> strings = new ArrayList<String>();

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
