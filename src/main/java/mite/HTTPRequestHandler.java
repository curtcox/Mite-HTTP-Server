package mite;

import java.io.*;

/**
 * This interface is used to define what a HTTP Server does.
 * Implementors may want to use AbstractRequestHandler, so that they only need implement handle.
 */
public interface HTTPRequestHandler {

    /**
     * Return true if this handler handles this request.
     */
    boolean handles(HTTPRequest request);

    /**
     * Handle this request.
     * Note that this method may well be called again from a different
     * thread before it returns.  It is the responsibility of the implementer to
     * ensure that that doesn't cause any problems.
     */
    HTTPResponse handle(HTTPRequest request) throws IOException;

}
