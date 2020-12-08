package mite;

import mite.handlers.CompositeRequestHandler;
import mite.handlers.EchoRequestHandler;
import mite.handlers.UnsupportedRequestHandler;

import java.io.IOException;

public final class Start {

    public static void main(String[] args) throws IOException {
        MiteHTTPServer.startListeningOnPort(
                8000,
                CompositeRequestHandler.of(
                    EchoRequestHandler.of(),
                    UnsupportedRequestHandler.of()
                )
         );
    }

}
