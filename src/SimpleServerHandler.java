import com.sun.net.httpserver.*;
import com.sun.net.httpserver.SimpleFileServer.OutputLevel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Predicate;

public class SimpleServerHandler {
    public static void main(String[] args) throws IOException {
        Predicate<Request> IS_GET = r -> r.getRequestMethod().equals("GET");
        var jsonHandler = HttpHandlers.of(200, Headers.of("Content-type", "application/json"), Files.readString(Path.of("C:/Users/gopin/staticJson/sample.json")));
        var notAllowedHandler = HttpHandlers.of(400, Headers.of("Allow", "GET"), "");
        HttpHandler handler = HttpHandlers.handleOrElse(IS_GET, jsonHandler, notAllowedHandler);

        var filter = SimpleFileServer.createOutputFilter(System.out, OutputLevel.VERBOSE);
        var server = HttpServer.create(new InetSocketAddress(8082), 10, "/", handler, filter);
        server.start();

    }
}
