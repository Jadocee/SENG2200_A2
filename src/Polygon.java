/*
 * SENG2200 Assignment 2
 * Jaydon Cameron
 * C3329145
 * 22/03/2022
 */

/** Representation of a polygon shape that extends {@link PlanarShape}. */
public class Polygon extends PlanarShape {
  // Instance variable
  private final Point[] points;

  /**
   * Constructor specifying the vertices.
   *
   * @param values An array of {@code double} values corresponding to the x and y coordinates
   *     of a vertex/point.
   */
  public Polygon(final double[] values) {
    this.points = new Point[values.length / 2 + 1];
    for (int i = 0, j = 0; i < values.length; i += 2, j++) {
      this.points[j] = new Point(values[i], values[i + 1]);
    }

    this.points[this.points.length - 1] = this.points[0];
  }

  /**
   * Get a string representation of this {@link Polygon}.
   * <p>Uses the format: <code style="font-weight: 500;">POLY=[point<sub>0</sub>point<sub>1</sub>
   * ...point<sub>n-2</sub>]: area_value</span></p>
   *
   * @return The {@link String} representing this {@link Polygon}.
   **/
  @Override
  public String toString() {
    // Create new StringBuilder object
    final StringBuilder stringBuilder = new StringBuilder("POLY=[");
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
   * Calculate the area of this {@link Polygon}.
   *
   * @return The calculated area as a {@code double}.
   */
  @Override
  public double area() {
    // Initialise the area value
    double area = 0.0;
    // Loop through each point with a counter
    for (int i = 0; i < this.points.length - 1; i++) {
      // Update area value using formula
      area +=
          (this.points[i + 1].getX() + this.points[i].getX())
              * (this.points[i + 1].getY() - this.points[i].getY());
    }
    return Math.abs(area) * 0.5;
  }

  /**
   * Calculate distance from the origin of the point which is closest to the origin
   * (0,0).
   *
   * @return The calculated distance as a {@code double}.
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
