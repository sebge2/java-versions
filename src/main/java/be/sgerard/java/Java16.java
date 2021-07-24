package be.sgerard.java;

/**
 * @author Sebastien Gerard
 */
public class Java16 {

    public static void main(String[] args) {
        records();
        patternMatchingTypeChecks();
    }

    private static void records() {
        final Person johnDoe = new Person("John Doe", 33);

        System.out.println("name " + johnDoe.name() + " age = " + johnDoe.age());
    }

    private static void patternMatchingTypeChecks() {
        final Shape shape1 = new Square(4.0f);
        final Shape shape2 = new Rectangle(4.0f, 3.0f);

        if (shape1 instanceof Square square) {
            System.out.println(square.getSize());
        } else if(shape2 instanceof Rectangle rectangle){
            System.out.println(rectangle.getLength() + "x" + rectangle.getWidth());
        }
    }

    public record Person(String name, int age) {
        public Person {
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative");
            }
        }
    }

    public static abstract class Shape {

        abstract float getSurface();
    }

    public static class Square extends Shape {

        private final float size;

        public Square(float size) {
            this.size = size;
        }

        public float getSize() {
            return size;
        }

        public float getSurface() {
            return getSize() * getSize();
        }
    }

    public static class Rectangle extends Shape {

        private final float length;
        private final float width;

        public Rectangle(float length, float width) {
            this.length = length;
            this.width = width;
        }

        public float getLength() {
            return length;
        }

        public float getWidth() {
            return width;
        }

        public float getSurface() {
            return getLength() * getWidth();
        }
    }
}
