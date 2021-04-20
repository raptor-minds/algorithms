package geekTime.graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author zhangrucheng
 */
public class Island {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    public int numIslands(char[][] grid) {
        Queue<Node> nodeQueue = new ArrayDeque<>();
        int count = 0;
        for (int m = 0; m < grid.length; m++) {
            for (int n = 0; n < grid[0].length; n++) {
                // 未访问
                if (grid[m][n] == '1') {
                    count++;
                    Node node = new Node(m, n);
                    nodeQueue.add(node);
                    while (!nodeQueue.isEmpty()) {
                        Node p = nodeQueue.poll();
                        if (p.x - 1 >= 0 && grid[p.x - 1][p.y] == '1') {
                            nodeQueue.offer(new Node(p.x - 1, p.y));
                            grid[p.x - 1][p.y] = '2';
                        }
                        if (p.x + 1 < grid[0].length && grid[p.x + 1][p.y] == '1') {
                            nodeQueue.offer(new Node(p.x + 1, p.y));
                            grid[p.x + 1][p.y] = '2';
                        }
                        if (p.y - 1 >= 0 && grid[p.x][p.y - 1] == '1') {
                            nodeQueue.offer(new Node(p.x, p.y - 1));
                            grid[p.x][p.y - 1] = '2';
                        }
                        if (p.y + 1 < grid.length && grid[p.x][p.y + 1] == '1') {
                            nodeQueue.offer(new Node(p.x, p.y + 1));
                            grid[p.x][p.y + 1] = '2';
                        }
                    }
                }
            }
        }
        return count;
    }
}

