/*
 * SENG2200 Assignment 2
 * Jaydon Cameron
 * C3329145
 * 22/03/2022
 */

/** Representation of a circle that extends {@link PlanarShape}. */
public class Circle extends PlanarShape {
  // Instance variables
  private final Point centre;
  private final double r;

  /**
   * Constructor specifying the centre and radius.
   *
   * @param x The x-coordinate of the centre of the circle.
   * @param y The y-coordinate of the centre of the circle.
   * @param r The radius of the circle.
   */
  public Circle(final double x, final double y, final double r) {
    this.centre = new Point(x, y);
    this.r = r;
  }

  /**
   * Get a string representation of this {@link Circle}
   *
   * <p>Satisfies the format: <code style="font-weight: 500;">CIRC=[point<sub>0</sub> r]: area_value
   * </code>
   *
   * @return The {@link String} representing this {@link Circle}.
   */
  @Override
  public String toString() {
    return String.format("CIRC=[%s %3.2f] : %5.2f", centre, r, area());
  }

  /**
   * Calculate the area of this {@link Circle}.
   *
   * @return The calculated area as a {@code double}.
   */
  @Override
  public double area() {
    return Math.pow(Math.PI * r, 2);
  }

  /**
   * Calculate the distance from the origin to the center of this {@link Circle}.
   *
   * @return The calculated distance as a {@code double}.
   */
  @Override
  public double originDistance() {
    return centre.calcDistance() - r;
  }
}
