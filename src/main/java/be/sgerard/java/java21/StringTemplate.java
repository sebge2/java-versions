package be.sgerard.java.java21;

public class StringTemplate {

    public static void main(String[] args) {
        String name = "Joan";
        String info = STR."My name is \{name}";

        System.out.println(info);
    }
}
