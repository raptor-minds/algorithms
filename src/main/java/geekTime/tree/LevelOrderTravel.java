package geekTime.tree;

import edu.princeton.cs.algs4.In;

import java.util.*;

public class LevelOrderTravel {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        treeNodeQueue.offer(root);
        while (!treeNodeQueue.isEmpty()) {
            while (!treeNodeQueue.isEmpty()) {
                TreeNode tr = treeNodeQueue.poll();
                deque.add(tr);
            }

            for (TreeNode next : deque) {
                if (next.left == null && next.right == null) {
                    continue;
                }
                treeNodeQueue.offer(next.left);
                treeNodeQueue.offer(next.right);
            }
            if (deque.size() == 1) {
                deque.poll();
                continue;
            }
            if (deque.size() % 2 != 0) {
                return false;
            }
            while (!deque.isEmpty()) {
                TreeNode first = deque.pollFirst();
                TreeNode last = deque.pollLast();
                if (first == null && last != null) {
                    return false;
                }
                if (first != null && last == null) {
                    return false;
                }
                if (first.val != last.val) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
        Queue<TreeNode> tempQueue = new ArrayDeque<>();
        List<List<Integer>> results = new ArrayList<>();
        treeNodeQueue.offer(root);
        while (!treeNodeQueue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            while (!treeNodeQueue.isEmpty()) {
                tempQueue.offer(treeNodeQueue.poll());
            }
            while (!tempQueue.isEmpty()) {
                TreeNode peek = tempQueue.poll();
                if (peek.left != null) {
                    treeNodeQueue.offer(peek.left);
                }
                if (peek.right != null) {
                    treeNodeQueue.offer(peek.right);
                }
                temp.add(peek.val);
            }
            results.add(temp);
        }
        return results;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        //root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        //root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
        boolean symmetric = new LevelOrderTravel().isSymmetric(root);
        System.out.println(symmetric);
    }
}
