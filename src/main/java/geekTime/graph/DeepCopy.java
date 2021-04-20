package geekTime.graph;

import java.util.*;

public class DeepCopy {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    static class Solution {
        public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }
            Set<Node> visited = new HashSet<>();
            Stack<Node> toDos = new Stack<>();
            Stack<Node> newToDos = new Stack<>();
            toDos.push(node);
            visited.add(node);
            Node head = new Node(node.val);
            newToDos.push(head);
            while (!toDos.isEmpty()) {
                Node top = toDos.pop();
                Node newNode = newToDos.pop();
                visited.add(top);
                ArrayList<Node> topNeighbors = new ArrayList<>();
                if (top.neighbors == null) {
                    newNode.neighbors = null;
                    continue;
                }
                top.neighbors.forEach(n -> {
                    Node temp = new Node(n.val);
                    topNeighbors.add(temp);
                    if (!visited.contains(n)) {
                        toDos.push(n);
                        newToDos.push(temp);
                    }
                });
                newNode.neighbors = topNeighbors;
            }
            return head;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.neighbors = new ArrayList<>();
        node1.neighbors.add(node2);

        node2.neighbors = new ArrayList<>();
        node2.neighbors.add(node3);

        node3.neighbors = new ArrayList<>();
        node3.neighbors.add(node1);

        Node node = new Solution().cloneGraph(node1);
    }
}
