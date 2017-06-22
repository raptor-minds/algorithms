package mergesort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ezharuc on 6/20/2017.
 */
public class FastCollinearPoints {

    private int numberOfSegments = 0;
    private Point[] points = null;
    private List<LineSegment> lineSegmentList = new ArrayList<LineSegment>();


    public FastCollinearPoints(Point[] points) {


        if (points == null) {
            throw new NullPointerException("null points.");
        }

        for (int i = 0; i < points.length; i++) {

            if (points[i] == null) {
                throw new NullPointerException("null point.");
            }
            for (int j = i; j > 0; j--) {
                if (less(points[j], points[j - 1])) {
                    exch(points, j, j - 1);
                } else if (points[j].compareTo(points[j - 1]) == 0) {
                    throw new IllegalArgumentException("illegal arguments.");
                }
            }
        }

        this.points = points;

        int j;
        for (int i = 0; i < points.length - 3; i++) {
            j = 0;
            Arrays.sort(points, points[i].slopeOrder());
            while (points[j].slopeTo(points[j + 1]) == points[j].slopeTo(points[j + 2])) {
                j++;
            }

            if (j == 2) {
                numberOfSegments++;
                lineSegmentList.add(new LineSegment(points[0], points[3]));
            } else if (j > 2) {

            }
        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public int numberOfSegments() {
        return 0;
    }

    public LineSegment[] segments() {
        return new LineSegment[0];
    }
}
