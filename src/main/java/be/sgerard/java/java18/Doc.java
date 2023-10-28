package be.sgerard.java.java18;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@SuppressWarnings("unused")
public class Doc {

    /**
     * {@snippet :
     * try (BufferedWriter writer = Files.newBufferedWriter(path)) {
     *   writer.write(text);  // @highlight substring="text"
     * }
     *}
     */
    public static void doc() {

    }

    public static void docWithRegion() {
        // @start region="writeFile"
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(""))) {
            writer.write("text");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
// @end
    }

    /**
     * How to write a text file with Java 7:
     * <p>
     * {@snippet file = "Java18.java" region = "writeFile"}
     */
    public static void docWithReference() {

    }
}
