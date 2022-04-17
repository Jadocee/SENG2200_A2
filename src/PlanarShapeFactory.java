/**
 *
 */
public class PlanarShapeFactory {

    public PlanarShapeFactory() {
    }

    public PlanarShape create(final char type, final double[] values) throws IllegalArgumentException {
        switch (type) {
            case 'P' -> {
                if (values.length < 2) {
                    throw new IllegalArgumentException("Expected array of minimum length 2 but received array of length "
                            + values.length);
                }
                return new Polygon(values);
            }
            case 'S' -> {
                if (values.length != 4) {
                    throw new IllegalArgumentException("Expected array length 4 and received array length " + values.length);
                }
                return new SemiCircle(values[0], values[1], values[2], values[3]);
            }
            case 'C' -> {
                if (values.length != 3) {
                    throw new IllegalArgumentException("Expected array length 3 and received array length " + values.length);
                }
                return new Circle(values[0], values[1], values[2]);
            }
            default -> {
                return null;
            }
        }
    }
}
