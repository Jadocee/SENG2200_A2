/*
 * SENG2200 Assignment 2
 * Jaydon Cameron
 * C3329145
 * 22/03/2022
 */

/**
 * Stores an array of <code>Point</code> objects<br/>
 * Implements <code>ComparePoly</code> interface and the <code>comesBefore()</code> method
 */
public class Polygon extends PlanarShape {
    // Instance variable
    private final Point[] points;

    /**
     * <code>Class</code> Constructor specifying the vertex/vertices of the <code>Polygon</code>.
     *
     * @param vertices A 2D array of <code>double</code> values corresponding to the x and y coordinates of
     *                 a vertex/point
     **/
    public Polygon(final double[] vertices) {
        points = new Point[vertices.length + 1];
        double x;
        double y;
        int count = 0;
        for (int i = 0, j = i + 1; j < vertices.length; i++, j++) {
//            if (i % 2 == 0) {
//                x = vertices[i];
//            } else {
//                y = vertices[i];
//            }
            points[i] = new Point(vertices[i], vertices[j]);
        }
        points[points.length - 1] = points[0];

    }

    /**
     * <p>Returns the <code>Polygon</code> object as a <code>String</code> in the format<br/>
     * <code style="font-weight: 500;">POLY=[point<sub>0</sub>point<sub>1</sub>...point<sub>n-2</sub>]: area_value</span></p>
     *
     * @return The <code>String</code> representation of the <code>Polygon</code> object
     **/
    @Override
    public String toString() {
        // Create new StringBuilder object
        StringBuilder stringBuilder = new StringBuilder("POLY=[");
        // Loop through Point array
        for (int i = 0; i < this.points.length - 1; i++) {
            // concatenate Point object as a string to the StringBuilder
            stringBuilder.append(points[i].toString());
        }
        // Calculate area of the Polygon and append to the end of the string
        stringBuilder.append(String.format("] : %5.2f", area()));
        // Return Polygon object as a String object in the format "[p0p1...pn-2]: area"
        return stringBuilder.toString();
    }


    /**
     * Returns the calculated area of the <code>Polygon</code> object.
     *
     * @return The area of <code>Polygon</code> object as a <code>double</code>
     */
    @Override
    public double area() {
        // Initialise the area value
        double area = 0.0;
        // Loop through each point with a counter
        for (int i = 0; i < this.points.length - 1; i++) {
            // Update area value using formula
            area += (this.points[i + 1].getX() + this.points[i].getX()) *
                    (this.points[i + 1].getY() - this.points[i].getY());
        }
        return Math.abs(area) * 0.5;
    }


    /**
     * Returns the calculated distance from the origin of the point which is closest to the origin (0,0)
     *
     * @return The calculated distance as a <code>double</code>
     */
    @Override
    public double originDistance() {
        // Initialize the shortest distance using the first point
        double closest = points[0].calcDistance();
        // Loop through each point
        for (Point point : points) {
            // Get distance from the origin of the point
            final double distance = point.calcDistance();
            // Update closest to this distance if it is closer to the origin
            if (distance < closest) {
                closest = distance;
            }
        }
        return closest;
    }
}
