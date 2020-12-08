package mite.handlers;

import mite.*;
import java.io.*;

/**
 * Handler that defers to other handlers.
 * It uses the first handler that says it can handle the given request.
 */
public final class CompositeRequestHandler
    implements HTTPRequestHandler
{

    public static CompositeRequestHandler of(HTTPRequestHandler... handlers) {
        return new CompositeRequestHandler(handlers);
    }

    private final HTTPRequestHandler[] handlers;

    private CompositeRequestHandler(HTTPRequestHandler... handlers) {
        this.handlers = handlers;
    }

    public HTTPResponse handle(HTTPRequest request)
        throws IOException
    {
        for (HTTPRequestHandler handler : handlers) {
            if (handler.handles(request)) {
                return handler.handle(request);
            }
        }
        return null;
    }

    public boolean handles(HTTPRequest request) {
        for (HTTPRequestHandler handler : handlers) {
            if (handler.handles(request)) {
                return true;
            }
        }
        return false;
    }

}
