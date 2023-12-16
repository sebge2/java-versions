package be.sgerard.java.java20;

import java.util.List;

import static java.util.Arrays.asList;

// JEP 432
public class RecordForEachPattern {

    public static void main(String[] args) {
        final List<Rectangle> rectangles = asList(
                new Rectangle(
                        new ColoredPoint(new Point(0, 0), Color.BLUE),
                        new ColoredPoint(new Point(1, 2), Color.RED)
                ),
                new Rectangle(
                        new ColoredPoint(new Point(1, 1), Color.GREEN),
                        new ColoredPoint(new Point(3, 2), Color.RED)
                )
        );

        for (Rectangle(ColoredPoint(Point(int xUpperLeft, int yUpperLeft), Color colorUpperLeft), ColoredPoint lowerRight) : rectangles) {
            System.out.printf("The point %s,%s has color %s.\n", xUpperLeft, yUpperLeft, colorUpperLeft);
        }
    }

    record Point(int x, int y) {
    }

    enum Color {RED, GREEN, BLUE}

    record ColoredPoint(Point p, Color c) {
    }

    record Rectangle(ColoredPoint upperLeft, ColoredPoint lowerRight) {
    }
}
