/*
 *  SENG2200 Assignment 2
 *  Jaydon Cameron
 *  C3329145
 *  22/03/2022
 *  This file contains the Point class which is used to store the x and y coordinates for
 *  a vertex of a Polygon object
 */

/**
 * Structure representing a point on the cartesian plane.
 */
public class Point {
  // Instance variables
  private final double x;
  private final double y;

  /**
   * Constructor specifying the values for the x and y coordinates.
   *
   * @param x The {@code double} value for the x-coordinate.
   * @param y The {@code double} value for the y-coordinate.
   */
  public Point(final double x, final double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Calculate the distance from the origin (0,0) of this {@link Point}.
   *
   * @return The calculated distance as a {@code double}.
   */
  public double calcDistance() {
    return Math.sqrt(x * x + y * y);
  }

  /**
   * Get the x-coordinate for this {@link Point}.
   *
   * @return The x-coordinate value of this {@link Point}.
   */
  public double getX() {
    return x;
  }

  /**
   * Get the y-coordinate of this {@link Point}.
   *
   * @return The y-coordinate value of this {@link Point}.
   */
  public double getY() {
    return y;
  }

  /**
   * Get string representation of this {@link Point}.
   * <p>Satisfies the format: <span style="font-weight: 600;">(x , y)</span></p>
   *
   * @return The {@link String} representing this {@link Point}.
   */
  @Override
  public String toString() {
    return String.format("(%4.2f , %4.2f)", this.x, this.y);
  }
}
