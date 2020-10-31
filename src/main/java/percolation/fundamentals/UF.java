package percolation.fundamentals;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * The type Uf.
 */
public class UF {

    private int count;

    private int[] a;

    /**
     * Instantiates a new Uf.
     *
     * @param N the n
     */
    public UF(int N) {
        this.count = N;
        a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = i;
        }
    }

    /**
     * Find int.
     *
     * @param index the index
     * @return the int
     */
    public int find(int index) {
        return a[index];
    }

    /**
     * Connected boolean.
     *
     * @param p the p
     * @param q the q
     * @return the boolean
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * Union.
     *
     * @param p the p
     * @param q the q
     */
    public void union(int p, int q) {

        int pId = find(p);
        int qId = find(q);

        if (pId == qId) return;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == pId) a[i] = qId;
        }
        count--;
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {  // Solve dynamic connectivity problem
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            System.out.println(p + " " + q);
            // Read number of sites.
            // Initialize N components.
            // Read pair to connect. // Ignore if connected.
            // Combine components
            // and print connection.
        }
        StdOut.println(uf.count() + " components");
    }
}
