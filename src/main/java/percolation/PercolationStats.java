package percolation;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by ezharuc on 5/24/2017.
 */
public class PercolationStats {

    private final int trials;
    private double[] x;


    /**
     * Instantiates a new percolation.Percolation stats.
     *
     * @param n
     *         the n
     * @param trials
     *         the trials
     */
    public PercolationStats(int n, int trials) {

        this.trials = trials;

        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("bad arguments");
        }

        x = new double[trials];
        for (int i = 0; i < trials; i++) {

            Percolation percolation = new Percolation(n);

            while (!percolation.percolates()) {
                percolation.open(StdRandom.uniform(1, n + 1), StdRandom.uniform(1, n + 1));
            }
            x[i] = percolation.numberOfOpenSites() * 1.0 / (n * n);
        }
    }

    /**
     * Mean double.
     *
     * @return the double
     */
    public double mean() {

        double sum = 0;
        for (int i = 0; i < trials; i++) {
            sum += x[i];
        }
        return sum / trials;
    }

    /**
     * Stddev double.
     *
     * @return the double
     */
    public double stddev() {

        double sum = 0;
        double v = mean();
        for (int i = 0; i < trials; i++) {
            sum += (x[i] - v) * (x[i] - v);
        }
        return Math.sqrt(sum / (trials - 1));
    }

    /**
     * Confidence lo double.
     *
     * @return the double
     */
    public double confidenceLo() {
        double v = mean();
        return v - 1.96 * stddev() / Math.sqrt(trials);
    }

    /**
     * Confidence hi double.
     *
     * @return the double
     */
    public double confidenceHi() {

        double v = mean();
        return v + 1.96 * stddev() / Math.sqrt(trials);
    }

    /**
     * The entry point of application.
     *
     * @param args
     *         the input arguments
     */
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);

        int trials = Integer.parseInt(args[1]);

        PercolationStats percolationStats = new PercolationStats(n, trials);
        System.out.println(n + trials);
        System.out.println("mean= " + percolationStats.mean());
        System.out.println("stddev= " + percolationStats.stddev());
        System.out.println("95% confidence interval= "
                + percolationStats.confidenceLo() + "," + percolationStats.confidenceHi());
    }
}
