package be.sgerard.java.java24;

import java.util.List;
import java.util.stream.Gatherers;

public class Gatherer {

    public static void main() {
        final List<String> words = List.of("Java", "JDK", "Generational", "GC", "Shenandoah");

        final List<List<String>> grouped = words.stream()
                .gather(Gatherers.windowFixed(2))
                .toList();

        System.out.println(grouped);
    }
}
