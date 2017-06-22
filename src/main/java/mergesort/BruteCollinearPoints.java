package mergesort;

import java.util.ArrayList;
import java.util.List;

/**
 * examines 4 points at a time and checks whether they all lie on the same line segment, returning all such line segments.
 * To check whether the 4 points p, q, r, and s are collinear, check whether the three slopes between p and q,
 * between p and r, and between p and s are all equal.
 * Created by ezharuc on 6/16/2017.
 */
public class BruteCollinearPoints {

    private int numberOfSegments = 0;
    private Point[] points = null;
    private List<LineSegment> lineSegmentList = new ArrayList<LineSegment>();

    /**
     * Instantiates a new Brute collinear points.
     *
     * @param points
     *         the points
     */
    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {

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
        calculateSegments();
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * Number of segments int.
     *
     * @return the int
     */
    // the number of line segments
    public int numberOfSegments() {
        return numberOfSegments;
    }

    /**
     * Segments line segment [ ].
     * <p>
     * the line segments
     * The method segments() should include each line segment containing 4 points exactly once.
     * If 4 points appear on a line segment in the order p→q→r→s,
     * then you should include either the line segment p→s or s→p (but not both)
     * and you should not include subsegments such as p→r or q→r.
     * For simplicity, we will not supply any input to BruteCollinearPoints that has 5 or more collinear points
     *
     * @return the line segment [ ]
     */
    public LineSegment[] segments() {

        LineSegment[] lineSegments = new LineSegment[numberOfSegments];
        return lineSegmentList.toArray(lineSegments);
    }

    private void calculateSegments() {
        for (int i = 0; i < points.length - 3; i++) {
            boolean flag = true;
            for (int j = i + 1; j < points.length - 2 && flag; j++) {
                for (int k = j + 1; k < points.length - 1 && flag; k++) {
                    for (int h = k + 1; h < points.length && flag; h++) {
                        double slope = points[i].slopeTo(points[k]);
                        if (slope == points[j].slopeTo(points[h]) && slope == points[i].slopeTo(points[j])) {
                            lineSegmentList.add(new LineSegment(points[i], points[h]));
                            numberOfSegments++;
                            flag = false;
                        }
                    }
                }
            }
        }
    }
}
