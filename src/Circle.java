/*
 * SENG2200 Assignment 2
 * Jaydon Cameron
 * C3329145
 * 22/03/2022
 */

/**
 *
 */
public class Circle extends PlanarShape {
    private final Point center;
    private final double r;


    /**
     * <code>Class</code> constructor specifying the center and radius
     *
     * @param x The x-coordinate of the center of the circle
     * @param y The y-coordinate of the center of the circle
     * @param r The radius of the circle
     */
    public Circle(final double x, final double y, final double r) {
        center = new Point(x, y);
        this.r = r;
    }

    /**
     * <p>Returns the <code>Circle</code> object represented as a <code>String</code> in the format<br/>
     * <code style="font-weight: 500;">CIRC=[point<sub>0</sub> r]: area_value</code></p>
     *
     * @return The <code>Circle</code> object represented as a <code>String</code>*/
    @Override
    public String toString() {
        return String.format("[%s %3.2f] : %5.2f", center, r, area());
    }

    /**
     * Returns the calculated area of the <code>Circle</code>
     *
     * @return The calculated area as a <code>double</code>
     */
    @Override
    public double area() {
        return Math.pow(Math.PI * r, 2);
    }

    /**
     * Returns the calculated distance of the origin from the center of the <code>Circle</code>
     *
     * @return The calculated distance as a <code>double</code>
     */
    @Override
    public double originDistance() {
        return center.calcDistance() - r;
    }
}
