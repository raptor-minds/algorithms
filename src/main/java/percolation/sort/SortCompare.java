package percolation.sort;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.awt.*;

public class SortCompare {
    public static double time(String alg, Double[] a) {
        Stopwatch stopwatch = new Stopwatch();
        switch (alg){
            case "Insert":
                Insertion insertion = new Insertion();
                insertion.sort(a, false);
                break;
            case "Select":
                Selection selection = new Selection();
                selection.sort(a, false);
                break;
        }
        return stopwatch.elapsedTime();
    }

    public static double timeRandomInput(String alg, int T, int N) {
        double total = 0.0;
        for (int i = 0; i < T; i++) {
            Double[] a = new Double[N];
            for (int j = 0; j < N; j++) {
                a[j] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = "Insert";
        String alg2 = "Select";
        double[] time1s = new double[12];
        double[] time2s = new double[12];
        int x = 1;
        for (int i = 0; i < 12; i++) {
            double alg1Time = timeRandomInput(alg1, 100, x);
            double alg2Time = timeRandomInput(alg2, 100, x);
            time1s[i] = alg1Time;
            time2s[i] = alg2Time;
            x *= 2;
        }

        StdDraw.setXscale(0, 15);
        StdDraw.setYscale(0, 1);
        double[] xx = new double[12];
        for (int i = 0; i < time1s.length; i++) {
            xx[i] =  i * 1.0;
        }

        StdDraw.setPenColor(Color.RED);
        StdDraw.filledPolygon(xx, time2s);

        StdDraw.setPenColor(Color.BLUE);
        StdDraw.filledPolygon(xx, time1s);


//        System.out.println(alg1 + " time " + alg1Time);
//        System.out.println(alg2 + " time " + alg2Time);
//        System.out.println(alg2 + "is time faster than " + alg1Time/alg2Time + " " + alg1);
    }
}
