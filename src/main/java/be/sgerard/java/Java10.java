package be.sgerard.java;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Sebastien Gerard
 */
public class Java10 {

    public static void main(String[] args) {
        varKeyword();
        toUnmodifiable();
    }

    private static void varKeyword() {
        var text = "Hello World!";

        System.out.println(text);
    }

    private static void toUnmodifiable() {
        List<Integer> evenList = IntStream.rangeClosed(0, 11)
                .boxed()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toUnmodifiableList());

        System.out.println(evenList);
    }
}
