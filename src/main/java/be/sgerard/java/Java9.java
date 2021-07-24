package be.sgerard.java;

/**
 * @author Sebastien Gerard
 */
public class Java9 {

    public static void main(String[] args) throws Exception {
        tryWithResources();
        diamondInnerClass();
        interfacePrivateMethod();
    }

    private static void tryWithResources() {
        MyAutoCloseable mac = new MyAutoCloseable();
        try (mac) {
            // do some stuff with mac
        }
    }

    private static void interfacePrivateMethod() {
        final InterfaceWithPrivateMethods pvt = new InterfaceWithPrivateMethods() {
            // anonymous class
        };

        System.out.println(pvt.check());
    }

    private static void diamondInnerClass() {
        FooClass<Integer> fc = new FooClass<>(1) { // anonymous inner class
        };
        System.out.println(fc.getArg());

        FooClass<? extends Integer> fc0 = new FooClass<>(1) {
            // anonymous inner class
        };
        System.out.println(fc0.getArg());

        FooClass<?> fc1 = new FooClass<>(1) { // anonymous inner class
        };
        System.out.println(fc1.getArg());
    }

    private static class FooClass<I> {

        private final I arg;

        public FooClass(I arg) {
            this.arg = arg;
        }

        public I getArg() {
            return arg;
        }
    }

    interface InterfaceWithPrivateMethods {

        private static String staticPrivate() {
            return "static private";
        }

        private String instancePrivate() {
            return "instance private";
        }

        default String check() {
            return staticPrivate() + " " + instancePrivate();
        }
    }


    private static class MyAutoCloseable implements AutoCloseable {

        @Override
        public void close() {
            System.out.println("close");
        }
    }
}
