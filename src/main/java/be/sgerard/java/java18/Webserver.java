package be.sgerard.java.java18;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpHandlers;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;

public class Webserver {

    public static void main(String[] args) throws Exception {
        handlerWebServer();
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
}
