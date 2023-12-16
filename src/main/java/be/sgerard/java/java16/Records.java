package be.sgerard.java.java16;

public class Records {

    public static void main(String[] args) {
        final Person johnDoe = new Person("John Doe", 33);

        System.out.println("name " + johnDoe.name() + " age = " + johnDoe.age());
    }

    public record Person(String name, int age) {
        public Person {
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative");
            }
        }
    }
}
