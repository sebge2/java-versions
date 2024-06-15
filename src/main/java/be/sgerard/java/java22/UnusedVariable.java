package be.sgerard.java.java22;

public class UnusedVariable {

    @SuppressWarnings({"ConstantValue", "DataFlowIssue"})
    public static void main() {
        record Point(int x, int y) {
        }

        Point point = new Point(10, 5);

        if (point instanceof Point(int x, int _)) {
            System.out.printf("Point object with value of x: %s%n", x);
        }

        var s = "myNumber";
        try {
            int i = Integer.parseInt(s);

            System.out.println(i);
        } catch (NumberFormatException _) {
            System.out.printf("Invalid Number: %s%n", s);
        }
    }
}
