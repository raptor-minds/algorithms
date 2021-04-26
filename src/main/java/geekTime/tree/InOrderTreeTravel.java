package geekTime.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InOrderTreeTravel<T> {
    public void stackWay(Node<T> root) {
        if (root == null) {
            return;
        }
        Stack<Node<T>> stack = new Stack<>();
        Node<T> temp = root;
        stack.push(root);
        while (!stack.isEmpty()) {
            while (temp != null) {
                temp = temp.left;
                if (temp != null) {
                    stack.push(temp);
                }
            }
            Node<T> pop = stack.pop();
            System.out.print(pop.data + " ");
            if (pop.right != null) {
                stack.push(pop.right);
            }
            temp = pop.right;
        }
    }

    public void recursiveTreeTravel(Node<T> root) {
        if (root.left != null) {
            recursiveTreeTravel(root.left);
        }
        System.out.print(root.data + " ");
        if (root.right != null) {
            recursiveTreeTravel(root.right);
        }
    }

    public static void main(String[] args) {
        Node<String> root = new Node<>("A");
        root.left = new Node<>("B");
        root.right = new Node<>("C");
        root.left.left = new Node<>("D");
        root.left.right = new Node<>("F");
        root.left.right.left = new Node<>("E");
        root.right.right = new Node<>("I");
        root.right.left = new Node<>("G");
        root.right.left.right = new Node<>("H");
        InOrderTreeTravel<String> integerInOrderTreeTravel = new InOrderTreeTravel<>();
        integerInOrderTreeTravel.recursiveTreeTravel(root);
        System.out.println();
        integerInOrderTreeTravel.stackWay(root);
    }
}
