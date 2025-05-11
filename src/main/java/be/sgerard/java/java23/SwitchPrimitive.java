package be.sgerard.java.java23;

public class SwitchPrimitive {

    public static void main() {
        System.out.println(processInput(10));    // Integer value: 10
        System.out.println(processInput(5.5));   // Double value: 5.5
    }

    private static String processInput(Object obj) {
        return switch (obj) {
            case Integer i -> "Integer value: %s".formatted(i);
            case Double d -> "Double value: %s".formatted(d);
            default -> "Unknown type";
        };
    }
}
