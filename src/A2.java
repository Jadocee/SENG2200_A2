/*
 * SENG2200 Assignment 2
 * Jaydon Cameron
 * C3329145
 * 22/03/2022
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class A2 {

    public static PlanarShape createShape(final char type, final double[] values) throws IllegalArgumentException {
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

    public static void main(String[] args) {
        final LinkedList<PlanarShape> unsortedList = new LinkedList<PlanarShape>();
        final SortedLinkedList<PlanarShape> sortedList = new SortedLinkedList<PlanarShape>();

        try (final Scanner scanner = new Scanner(new File(args[0]))) {
            PlanarShape shape = null;
            while (scanner.hasNext()) {
                switch (scanner.next()) {
                    case "P" -> {
                        double[] values = new double[scanner.nextInt() * 2];
                        for (int i = 0; i < values.length; i++) {
                            values[i] = scanner.nextDouble();
                        }
                        shape = createShape('P', values);
                    }
                    case "S" -> {
                        double[] values = new double[4];
                        for (byte i = 0; i < values.length; i++) {
                            values[i] = scanner.nextDouble();
                        }
                        shape = createShape('S', values);
                    }
                    case "C" -> {
                        double[] values = new double[3];
                        for (byte i = 0; i < values.length; i++) {
                            values[i] = scanner.nextDouble();
                        }
                        shape = createShape('C', values);
                    }
                }
                unsortedList.insert(shape);
                sortedList.insert(shape);
                shape = null;
            }
        } catch (IOException | NullPointerException | UnsupportedOperationException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Unsorted List");
            System.out.println(unsortedList);
            System.out.println("Sorted List");
            System.out.print(sortedList);
        }
    }
}
