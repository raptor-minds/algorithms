package percolation.sort;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;
import java.util.Random;

public class SortBase {

    static void show(Comparable[] a, int index, boolean needPrint) {

        if (!needPrint) return;

        StdDraw.setPenColor(Color.RED);
        for (int i = 0; i < index; i++) {
            StdDraw.filledRectangle(i, (Double) a[i] / 2, 0.25, (Double) a[i] / 2);
        }
        StdDraw.setPenColor(Color.GRAY);
        for (int i = index; i < a.length; i++) {
            StdDraw.filledRectangle(i, (Double) a[i] / 2, 0.25, (Double) a[i] / 2);
        }
        StdDraw.show();
        StdDraw.setPenColor(Color.WHITE);
        for (int i = 0; i < a.length; i++) {
            StdDraw.filledRectangle(i, 30, 0.5, 30);
        }
    }

    static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (less(a[i + 1], a[i])) return false;
        }
        return true;
    }

    static boolean less(Comparable comparable, Comparable comparable1) {
        return comparable.compareTo(comparable1) < 0;
    }


    static void exec(int i, int j, Comparable[] a) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static Comparable[] init(boolean needPrint) {
        int N = 100;
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = Double.valueOf(new Random().nextInt(50));
        }

        if (!needPrint) return a;
        StdDraw.setCanvasSize(1000, 500);
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 50);
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(Color.GRAY);
        return a;
    }
}
