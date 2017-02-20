package mite;

import java.io.*;
import java.net.*;

/**
 * This interface is used to define what a GenericHTTPServer does.
 */
public interface RequestHandler {

    /**
     * Return true if this handler handles this request.
     */
    boolean handles(String request);

    /**
     * Handle this request.
     * Note that this method may well be called again from a different
     * thread before it return.  It is the responsibility of the implementer to
     * ensure that that doesn't cause any problems.
     */
    void handle(String request, Socket socket, InputStream in, OutputStream out) throws IOException;

}
