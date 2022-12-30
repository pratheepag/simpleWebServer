import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.SimpleFileServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Path;

public class SimpleServerHandler {
    public static void main(String[] args) throws IOException {
        var handler = SimpleFileServer.createFileHandler(Path.of("C:/Users/gopin/staticJson/"));
        var server = HttpServer.create(new InetSocketAddress(8080),10, "/", handler);
        server.start();

    }
}
