package be.sgerard.java.java24;

@SuppressWarnings("preview")
public class Scoped {

    private static final ScopedValue<String> X = ScopedValue.newInstance();

    public static void main(String[] args) {
        foo();
    }

    static void foo() {
        ScopedValue.where(X, "foo").run(Scoped::bar);
    }

    static void bar() {
        System.out.println("Printing X from bar(): " + X.get());
        ScopedValue.where(X, "bar").run(Scoped::baz);
        System.out.println("Printing X from bar(): " + X.get());
    }

    static void baz() {
        System.out.println("Printing X from baz(): " + X.get());
    }
}
