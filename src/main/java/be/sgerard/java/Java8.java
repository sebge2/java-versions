package be.sgerard.java;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author Sebastien Gerard
 */
public class Java8 {

    public static void main(String[] args) {
        lambda();
        stream();
        methodReference();
        defaultMethodInInterface();
        staticMethodInInterface();
        optional();
    }

    private static void lambda(){
        Supplier<String> lambda = () -> "Hello World";

        System.out.println(lambda.get());
    }

    private static void stream(){
        Stream.of("one", "two", "three")
                .forEach(value -> System.out.println("Value = " + value));
    }

    private static void methodReference(){
        saySomething(Java8::hello);
    }

    private static void defaultMethodInInterface() {
        final MyInterfaceWithDefault myInterface = new MyInterfaceWithDefault() {
        };

        System.out.println(myInterface.sayHello());
    }

    private static void staticMethodInInterface() {
        final MyInterfaceWithStatic myInterface = new MyInterfaceWithStatic() {
            @Override
            public String sayHello() {
                return hello();
            }
        };

        System.out.println(myInterface.sayHello());
    }

    private static void optional() {
        final Optional<String> optional = Optional.of("test");

        optional.ifPresent(System.out::println);
    }

    private static String hello(){
        return "Hello World";
    }

    private static void saySomething(Supplier<String> supplier){
        System.out.println(supplier.get());
    }

    public interface MyInterfaceWithDefault {

        default String sayHello(){
            return "Hello";
        }
    }

    public interface MyInterfaceWithStatic {

        static String hello(){
            return "hello";
        }

        String sayHello();
    }
}
