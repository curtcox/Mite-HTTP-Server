package mite;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

/**
 * Opens a server socket and hands off any requests to another thread.
 */
public final class MiteHTTPServer
    extends Thread
{

    private final ServerSocket server;
    private final SocketRequestHandler handler;
    private final Executor executor = Executors.newFixedThreadPool(3);
    static  final String NAME = "MiteHTTPServer 0.1";

    public MiteHTTPServer(int port, SocketRequestHandler handler)
        throws IOException
    {
        this.server = new ServerSocket(port);
        this.handler = handler;
    }

    static void startListeningOnPort(int port,HTTPRequestHandler http) throws IOException {
        log("Accepting connections on port " + port);
        MiteHTTPServer server = new MiteHTTPServer(port,SocketRequestHandler.of(http));
        server.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                executor.execute(new RequestProcessor(server.accept(),handler));
            } catch (IOException e) {
                log(e);
            }
        }
    }

    private static void log(Throwable t) {
        t.printStackTrace();
    }

    private static void log(String message) {
        System.out.println("MiteHTTPServer : " + message);
    }

}
