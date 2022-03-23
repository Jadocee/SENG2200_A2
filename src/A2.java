/*
 * SENG2200 Assignment 2
 * Jaydon Cameron
 * C3329145
 * 22/03/2022
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class A2 {

    public static void main(String[] args) {
        final PlanarShapeFactory factory = new PlanarShapeFactory();
        final LinkedList<PlanarShape> unsortedList = new LinkedList<PlanarShape>();

        try (final Scanner scanner = new Scanner(new File(args[0]))) {
            PlanarShape shape = null;
            while (scanner.hasNext()) {
                switch (scanner.next()) {
                    case "P" -> {
                        double[] values = new double[scanner.nextInt()];
                        for (int i = 0; i < values.length; i++) {
                            values[i] = scanner.nextDouble();
                        }
                        shape = factory.create('P', values);
                    }
                    case "S" -> {
                        double[] values = new double[4];
                        for (byte i = 0; i < values.length; i++) {
                            values[i] = scanner.nextDouble();
                        }
                        shape = factory.create('S', values);
                    }
                    case "C" -> {
                        double[] values = new double[3];
                        for (byte i = 0; i < values.length; i++) {
                            values[i] = scanner.nextDouble();
                        }
                        shape = factory.create('C', values);
                    }
                }
                try {
                    unsortedList.insert(shape);
                } catch (UnsupportedOperationException e) {
                    e.printStackTrace();
                } catch (NullPointerException e) {

                } finally {
                    shape = null;
                }
            }

        } catch (IOException e) {

        } finally {
            System.out.println("Printing unsorted list...");
            System.out.println(unsortedList.toString());
        }
    }
}
