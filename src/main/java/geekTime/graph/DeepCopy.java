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

        private Node clone(Node node, HashMap<Integer, Node> visited) {
            if (node == null) {
                return null;
            }

            if (visited.containsKey(node.val)) {
                return visited.get(node.val);
            }

            Node newNode = new Node(node.val);
            visited.put(newNode.val, newNode);

            newNode.neighbors = new ArrayList<>();

            for (Node neighbor : node.neighbors) {
                newNode.neighbors.add(clone(neighbor, visited));
            }

            return newNode;

        }

        public Node cloneGraph1(Node node) {
            HashMap<Integer, Node> visited = new HashMap<>();
            return clone(node, visited);
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors = new ArrayList<>();
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors = new ArrayList<>();
        node2.neighbors.add(node3);
        node2.neighbors.add(node1);

        node3.neighbors = new ArrayList<>();
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors = new ArrayList<>();
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Node node = new Solution().cloneGraph(node1);
    }
}
