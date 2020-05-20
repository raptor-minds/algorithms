package percolation.fundamentals;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnionUF {
    private int[] id; // parent link
    private int[] sz; // root size
    private int count;
    private int size;

    public WeightedQuickUnionUF(int N) {
        size = N;
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int getCount() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    private int find(int p) {
        while (id[p] != p) p = id[p];
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        if (sz[rootP] < sz[rootQ]) {
            id[rootP] = rootQ;
            sz[rootQ] += sz[rootP];
        } else {
            id[rootQ] = rootP;
            sz[rootP] += sz[rootQ];
        }
        count--;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(i);
            int p = i;
            while (p != id[p]) {
                p = id[p];
                System.out.print("-->" + p);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {  // Solve dynamic connectivity problem
        int N = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            uf.print();
            System.out.println(p + " " + q);
            // Read number of sites.
            // Initialize N components.
            // Read pair to connect. // Ignore if connected.
            // Combine components
            // and print connection.
        }
        StdOut.println(uf.getCount() + " components");
    }
}
