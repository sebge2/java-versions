package be.sgerard.java.java19;

// JEP 427
// https://mkyong.com/java/what-is-new-in-java-19/#jep-427-pattern-matching-for-switch-third-preview
public class PatternMatchingSwitch {

    public static void main(String[] args) {
        testJava19("mkyong");
        testJava19("mkyongmkyong");
    }

    static void testJava19(Object o) {
        switch (o) {
            case String s
                    when s.length() > 10 ->
                    System.out.println("String's length longer than 10!");
            case String s ->
                    System.out.println("String's length is " + s.length());
            default -> {}
        }
    }
}
