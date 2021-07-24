package be.sgerard.java;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Sebastien Gerard
 */
public class Java12 {

    public static void main(String[] args) throws Exception {
        newStringMethods();
        mismatchBetweenFiles();
        teeingCollector();
    }

    private static void newStringMethods() {
        String text = "Hello Baeldung!\nThis is Java 12 article.";

        text = text.indent(4);
        System.out.println(text);

        text = text.indent(-10);
        System.out.println(text);


        String text2 = "Baeldung";
        String transformed = text2.transform(value ->
                new StringBuilder(value).reverse().toString()
        );

        System.out.println(text2 + " => " + transformed);
    }

    private static void mismatchBetweenFiles() throws Exception{
        Path filePath1 = Files.createTempFile("file1", ".txt");
        Path filePath2 = Files.createTempFile("file2", ".txt");
        Files.writeString(filePath1, "Java 12 Article");
        Files.writeString(filePath2, "Java 12 Article");

        long mismatch = Files.mismatch(filePath1, filePath2);

        System.out.println("Mismatch = " + mismatch);
    }

    private static void teeingCollector() {
        double mean = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.teeing(Collectors.summingDouble(i -> i),
                        Collectors.counting(), (sum, count) -> sum / count));

        System.out.println(mean);
    }
}
