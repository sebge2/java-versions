package be.sgerard.java.java24;

public class SwitchPrimitive {

    public static void main() {

        print(3);
        print(3.5);
    }

    private static void print(Object obj) {
        switch (obj) {
            case Integer i -> System.out.println("Integer: " + i);
            case Double d -> System.out.println("Double: " + d);
            default -> System.out.println("Other type");
        }
    }
}
