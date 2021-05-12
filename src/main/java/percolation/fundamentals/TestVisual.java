package percolation.fundamentals;

import edu.princeton.cs.algs4.StdDraw;

public class TestVisual {

    private double total;
    private int N;

    public void canvas() {
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
    }

    public void addDataValue(double val) {
        N += 4;
        total += val;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        //StdDraw.point(N, val);
        StdDraw.filledRectangle(N, val/2, 1, val/2);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.text(N, val + 1, String.valueOf(val));
       // StdDraw.setPenColor(StdDraw.YELLOW);

        //StdDraw.point(N, total / N);
//        StdDraw.line(N, 0, N+0.5, total/N);
//        StdDraw.text(N, total/N, String.valueOf(total/N), 90);
    }

    public static void main(String[] args) {
        TestVisual testVisual = new TestVisual();
        testVisual.canvas();
        for (int i = 0; i < 100; i = i+10) {
            testVisual.addDataValue((double)i);
        }
    }
}
