package be.sgerard.java.java22;

import java.util.List;
import java.util.stream.Stream;
import java.util.Optional;

@SuppressWarnings("preview")
public class StreamGatherer {

    public static void main() {
        final List<List<Integer>> fixedWindows = Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .gather(java.util.stream.Gatherers.windowFixed(3))
                .toList();
        System.out.println(fixedWindows);

        final List<List<Integer>> slidingWindows = Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .gather(java.util.stream.Gatherers.windowSliding(2))
                .toList();
        System.out.println(slidingWindows);

        final Optional<String> numberString = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                        .gather(java.util.stream.Gatherers.fold(() -> "", (string, number) -> string + number))
                        .findFirst();
        System.out.println(numberString);
    }
}
