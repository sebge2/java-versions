package be.sgerard.java.java19;

public class NestedRecordMatching {

    record Point(int x, int y) {
    }

    record Total(Point p1, Point p2) {
    }

    public static void main(String[] args) {
        final Object o = new Total(new Point(10, 5), new Point(2, 3));

        if (o instanceof Total(Point(int x, int y), Point(int x2, int y2))) {
            System.out.println(x + y + x2 + y2);
        }
    }

}
