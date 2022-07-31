package be.sgerard.java;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpHandlers;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.SimpleFileServer;

import static com.sun.net.httpserver.SimpleFileServer.OutputLevel;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

public class Java18 {

    public static void main(String[] args) throws Exception {
       // fileWebServer();
        handlerWebServer();
        doc();
    }

    public static void fileWebServer() {
        HttpServer server = SimpleFileServer.createFileServer(
                new InetSocketAddress(8080),
                Path.of("/tmp"),
                OutputLevel.INFO
        );

        server.start();
    }

    public static void handlerWebServer() throws IOException {
        var handler = HttpHandlers.handleOrElse(
                r -> r.getRequestMethod().equals("GET") && r.getRequestURI().compareTo(URI.create("/")) == 0,
                HttpHandlers.of(
                        200,
                        Headers.of("Content-Type", "application/json"),
                        """
                                {
                                    "hello": "world"
                                }
                                """
                ),
                HttpHandlers.of(405, Headers.of("Allow", "GET"), "You are not allowed :(")
        );

        var server = HttpServer.create(new InetSocketAddress(8080), 10, "/", handler);
        server.start();
    }

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
