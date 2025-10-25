package be.sgerard.java.java25;

public class IfPrimitive {

    static void main() {
        final Object obj = 3;

        if (obj instanceof int i) {
            System.out.println("It's an int: " + i);
        }
    }
}
