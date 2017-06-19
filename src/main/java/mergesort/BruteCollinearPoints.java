package mergesort;

import java.util.Arrays;

/**
 * examines 4 points at a time and checks whether they all lie on the same line segment, returning all such line segments.
 * To check whether the 4 points p, q, r, and s are collinear, check whether the three slopes between p and q,
 * between p and r, and between p and s are all equal.
 * Created by ezharuc on 6/16/2017.
 */
public class BruteCollinearPoints {

    private int numberOfSegments = 0;
    private Point[] points = null;
    private boolean flag = false;
    private LineSegment[] lineSegments = new LineSegment[0];

    /**
     * Instantiates a new Brute collinear points.
     *
     * @param points
     *         the points
     */
    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {

        flag = false;
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

        if (flag) {
            return numberOfSegments;
        }
        calculateSegments();
        flag = true;
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

        if (flag) {
            return lineSegments;
        }
        flag = true;
        calculateSegments();
        return lineSegments;
    }

    private void calculateSegments() {
        for (int i = 0; i < points.length - 3; i++) {
            Arrays.sort(points, points[i].slopeOrder());
            for (int j = i; j < points.length - 3; j++) {
                if (points[j].slopeTo(points[j + 3]) == points[j].slopeTo(points[j + 1])) {
                    lineSegments[numberOfSegments] = new LineSegment(points[j], points[j + 3]);
                    numberOfSegments++;
                }
            }
            // return to original sequence point array.
            Arrays.sort(points);
        }
    }
}
