package be.sgerard.java;

public class Java17 {

    public static void main(String[] args) {
        sealedClasses();
    }

    private static void sealedClasses() {
        final Circle circle = new Circle(42.0d);

        System.out.println("Area: " + circle.getArea());
    }

    public abstract static sealed class Shape permits Circle, Rectangle, Square {

        public abstract double getArea();
    }

    public final static class Circle extends Shape {

        private final double radius;

        public Circle(double diameter) {
            this.radius = diameter;
        }

        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }
    }

    public final static class Rectangle extends Shape {

        private final double length;
        private final double width;

        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        @Override
        public double getArea() {
            return length * width;
        }
    }

    public final static class Square extends Shape {

        private final double length;

        public Square(double size) {
            this.length = size;
        }

        @Override
        public double getArea() {
            return length * length;
        }
    }

    public final static class NonShape /* extends Shape */ {

    }
}
