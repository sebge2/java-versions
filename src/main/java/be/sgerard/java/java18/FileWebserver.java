package be.sgerard.java.java18;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.SimpleFileServer;

import java.net.InetSocketAddress;
import java.nio.file.Path;

public class FileWebserver {

    public static void main(String[] args) throws Exception {
        fileWebServer();
    }

    public static void fileWebServer() {
        HttpServer server = SimpleFileServer.createFileServer(new InetSocketAddress(8080), Path.of("/tmp"), SimpleFileServer.OutputLevel.INFO);

        server.start();
    }
}
