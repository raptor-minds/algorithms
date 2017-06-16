package mergesort;

/**
 * examines 4 points at a time and checks whether they all lie on the same line segment, returning all such line segments.
 * To check whether the 4 points p, q, r, and s are collinear, check whether the three slopes between p and q,
 * between p and r, and between p and s are all equal.
 * Created by ezharuc on 6/16/2017.
 */
public class BruteCollinearPoints {

    /**
     * Instantiates a new Brute collinear points.
     *
     * @param points
     *         the points
     */
    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {

    }

    /**
     * Number of segments int.
     *
     * @return the int
     */
    // the number of line segments
    public int numberOfSegments() {

        return 0;
    }

    /**
     * Segments line segment [ ].
     * <p>
     * the line segments
     *
     * @return the line segment [ ]
     */
    public LineSegment[] segments() {

        return new LineSegment[10];
    }
}
