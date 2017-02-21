package mite;

import mite.handlers.*;
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

    private static SocketRequestHandler handler() {
        return SocketRequestHandler.of(
                 CompositeRequestHandler.of(
                     EchoRequestHandler.of(), UnsupportedRequestHandler.of()));
    }

    private static void startListeningOnPort(int port) throws IOException {
        log("Accepting connections on port " + port);
        MiteHTTPServer server = new MiteHTTPServer(port,handler());
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

    public static void main(String[] args) throws IOException {
        startListeningOnPort(8000);
    }

    private static void log(Throwable t) {
        t.printStackTrace();
    }

    private static void log(String message) {
        System.out.println("MiteHTTPServer : " + message);
    }

}
