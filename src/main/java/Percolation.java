import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by ezharuc on 5/16/2017.
 */
public class Percolation {

    private final int n;
    private final boolean[] sites;
    private int count;
    private final int top, bottom;

    private final WeightedQuickUnionUF weightedQuickUnionUF;
    private final WeightedQuickUnionUF fullUF;

    /**
     * Instantiates a new Percolation.
     * create n-by-n grid, with all sites blocked
     *
     * @param n
     *         the n
     */
    public Percolation(int n) {

        if (n <= 0) {
            throw new IllegalArgumentException("wrong arguments");
        }
        this.n = n;
        top = 0;
        bottom = n * n + 1;
        sites = new boolean[n * n + 2];
        weightedQuickUnionUF = new WeightedQuickUnionUF(this.n * this.n + 2);
        fullUF = new WeightedQuickUnionUF(n * n + 1);
    }

    private int index(int row, int col) {
        return (row - 1) * n + col;
    }

    /**
     * Open.
     *
     * @param row
     *         the row
     * @param col
     *         the col
     */
    public void open(int row, int col) {

        int tempId;

        if (!isOpen(row, col)) {
            count++;
        }

        int i = index(row, col);

        sites[i] = true;

        if (row == 1) {
            weightedQuickUnionUF.union(top, i);
            fullUF.union(top, i);
        }

        if (row == n) {
            weightedQuickUnionUF.union(bottom, i);
        }

        tempId = index(row - 1, col);
        if (row - 1 >= 1 && sites[tempId]) {
            weightedQuickUnionUF.union(i, tempId);
            fullUF.union(i, tempId);
        }

        tempId = index(row + 1, col);
        if (row + 1 <= n && sites[tempId]) {
            weightedQuickUnionUF.union(i, tempId);
            fullUF.union(i, tempId);
        }

        tempId = index(row, col - 1);
        if (col - 1 >= 1 && sites[tempId]) {
            weightedQuickUnionUF.union(i, tempId);
            fullUF.union(i, tempId);
        }

        tempId = index(row, col + 1);
        if (col + 1 <= n && sites[tempId]) {
            weightedQuickUnionUF.union(i, tempId);
            fullUF.union(tempId, i);
        }
    }

    /**
     * Is open boolean.
     *
     * @param row
     *         the row
     * @param col
     *         the col
     *
     * @return the boolean
     */
    public boolean isOpen(int row, int col) {
        int i = row - 1;
        int j = col - 1;
        if (i < 0 || j < 0 || row > n || col > n) {
            throw new IndexOutOfBoundsException("wrong arguments");
        }
        return sites[index(row, col)];
    }

    /**
     * Is full boolean.
     *
     * @param row
     *         the row
     * @param col
     *         the col
     *
     * @return the boolean
     */
    public boolean isFull(int row, int col) {

        int i = row - 1;
        int j = col - 1;
        if (i < 0 || j < 0 || row > n || col > n) {
            throw new IndexOutOfBoundsException("wrong arguments");
        }

        return sites[index(row, col)] && fullUF.connected(top, index(row, col));
    }

    /**
     * Percolates boolean.
     *
     * @return the boolean
     */
    public boolean percolates() {

        return weightedQuickUnionUF.connected(top, bottom);
    }

    /**
     * Number of open sites int.
     *
     * @return the int
     */
    public int numberOfOpenSites() {
        return count;
    }

    private void printPercolation() {

        System.out.println("**********************************");
        System.out.println(sites[top]);
        for (int i = 1; i <= this.n; i++) {
            for (int j = 1; j <= this.n; j++) {
                System.out.print(weightedQuickUnionUF.find(index(i, j)));
                System.out.print(" ");
                System.out.print(sites[index(i, j)]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println(sites[bottom]);
    }

    /**
     * The entry point of application.
     *
     * @param args
     *         the input arguments
     */
    public static void main(String[] args) {

        Percolation p = new Percolation(10);

        p.printPercolation();
        p.open(2, 2);
        p.open(2, 1);
        p.open(7, 5);
        p.open(3, 5);
        p.open(1, 2);
        p.printPercolation();

        System.out.println(p.index(0, 0));
        System.out.println(p.index(1, 0));
        System.out.println(p.index(1, 1));

        System.out.println("2,2 is full :" + p.isFull(2, 2));
        System.out.println("3,2 is full :" + p.isFull(3, 2));
        System.out.println("3,5 is full :" + p.isFull(3, 5));
    }
}
