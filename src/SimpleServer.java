import java.net.InetSocketAddress;
import java.nio.file.Path;

import com.sun.net.httpserver.SimpleFileServer;
import com.sun.net.httpserver.SimpleFileServer.OutputLevel;

public class SimpleServer {
    public static void main(String[] args) {
        // create the server
        var server = SimpleFileServer.createFileServer(
                new InetSocketAddress(8081),
                Path.of("C://Users//gopin/staticJson/"),
                OutputLevel.VERBOSE);

        // start the server
        server.start();
    }
}
