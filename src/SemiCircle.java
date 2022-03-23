/*
 * SENG2200 Assignment 2
 * Jaydon Cameron
 * C3329145
 * 22/03/2022
 */

/**
 *
 */
public class SemiCircle extends PlanarShape {
    private final Point[] points;

    /**
     * <p><code>Class</code> constructor specifying the coordinates of point at the center of the base of the semicircle and the
     * point perpendicular to the center of the base</p>
     */
    public SemiCircle(final double x0, final double y0, final double x1, final double y1) {
        points = new Point[4];
        points[0] = new Point(x0, y0);
        points[1] = new Point(x1, y1);
        points[2] = new Point(x0 - Math.abs(y0 - y1), y0 + Math.abs(x0 - x1));
        points[3] = new Point(x0 + Math.abs(y0 - y1), y0 - Math.abs(x0 - x1));
    }

    /**
     * <p>Returns the <code>SemiCircle</code> object represented as a <code>String</code> in the format<br/>
     * <code style="font-weight: 500;">SEMI=[point<sub>0</sub> point<sub>1</sub>]: area_value</span></p>
     *
     * @return The <code>SemiCircle</code> represented as a <code>String</code>
     */
    @Override
    public String toString() {
        return String.format("SEMI=[%s%s] : %5.2f", points[0].toString(), points[1].toString(), area());
    }

    /**
     * Returns the calculated area of the <code>Circle</code> object
     *
     * @return The calculated area as a <code>double</code>*/
    @Override
    public double area() {
        // Calculate distance between points
        final double radius = Math.sqrt(
                Math.pow(points[1].getX() - points[0].getX(), 2) +
                        Math.pow(points[1].getY() - points[0].getY(), 2)
        );
        return (Math.PI * Math.pow(radius, 2)) / 2;
    }

    /**
     * <p>Returns the calculated distance from the origin of the closest of the two data points and the two base
     * extremity points (x<sub>2</sub>, y<sub>2</sub>) and (x<sub>3</sub>, y<sub>3</sub>)</p>
     *
     * @return The calculated distance as a <code>double</code>
     */
    @Override
    public double originDistance() {
        double closest = points[0].calcDistance();
        for (byte i = 1; i < points.length; i++) {
            closest = Math.min(closest, points[i].calcDistance());
        }
        return closest;
    }
}
