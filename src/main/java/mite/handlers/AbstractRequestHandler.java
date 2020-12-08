package mite.handlers;

import mite.*;

public abstract class AbstractRequestHandler
    implements HTTPRequestHandler
{

    public boolean handles(HTTPRequest request) {
        try {
            return handle(request)!=null;
        } catch (Throwable t) {
            return false;
        }
    }

}
