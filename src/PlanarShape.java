/*
 * SENG2200 Assignment 2
 * Jaydon Cameron
 * C3329145
 * 22/03/2022
 */

/** */
abstract class PlanarShape implements Comparable<PlanarShape> {

  /**
   * Gets the <code>PlanarShape</code> object as a <code>String</code> in the format <span
   * style="font-weight: 500;">[point<sub>0</sub>point<sub>1</sub>...point<sub>n-2</sub>]:
   * area</span>
   *
   * @return A <code>String</code> representation of the <code>PlanarShape</code> object
   */
  public abstract String toString();

  /**
   * Calculates the area of the <code>PlanarShape</code> object
   *
   * @return The area of the <code>PlanarShape</code> object a <code>double</code>
   */
  public abstract double area();

  /**
   * Calculates the distance from the origin of the point which is closest to the origin (0,0)
   *
   * @return The calculated distance as a <code>double</code>
   */
  public abstract double originDistance();

  /**
   * Implementation of the <code>compareTo()</code> method in the <code>Comparable&#60;T&#62;</code>
   * interface.
   *
   * <p>Compares <code>PlanarShape</code> objects to determine which comes before.
   *
   * @param o The <code>PlanarShape</code> object being compared to
   * @return <code>-1</code> if this <code>PlanarShape</code> object has a smaller area<br>
   *     <code>0</code> if <code>PlanarShape</code> objects have equal area<br>
   *     <code>1</code> if this <code>PlanarShape</code> object has a larger area
   */
  @Override
  public int compareTo(PlanarShape o) {
    if (this == o) {
      return 0;
    }
    final double thisArea = this.area();
    final double thatArea = o.area();
    if (Math.abs(thisArea - thatArea) <= (0.0005 * Math.min(thisArea, thatArea))) {
      final double thisDistance = this.originDistance();
      final double thatDistance = o.originDistance();
      // Could be replaced with Double.compare(d1, d2)
      if (thisDistance < thatDistance) {
        return 1;
      } else if (thisDistance > thatDistance) {
        return -1;
      } else {
        return 0;
      }
    } else if (thisArea < thatArea) {
      return -1;
    } else {
      return 1;
    }
  }
}
