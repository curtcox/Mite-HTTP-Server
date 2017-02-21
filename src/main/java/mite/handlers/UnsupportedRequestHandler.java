package mite.handlers;

import mite.*;
import java.io.*;
import java.net.*;

/**
 * To report to the client that the request is unsupported.
 */
public final class UnsupportedRequestHandler
    implements HTTPRequestHandler
{

    public static UnsupportedRequestHandler of() {
        return new UnsupportedRequestHandler();
    }

    private UnsupportedRequestHandler() {}

    private static final String NOT_IMPLEMENTED_PAGE =
            "<HTML>" +
                    "<HEAD> <TITLE>Not Implemented</TITLE> </HEAD>" +
                    "<BODY> <H1>HTTP Error 501: Not Implemented</H1> </BODY>" +
            "</HTML>";

    public HTTPResponse handle(HTTPRequest request)
        throws IOException
    {
        return HTTPResponse.of(NOT_IMPLEMENTED_PAGE,StatusCode.NOT_IMPLEMENTED);
    }

    public boolean handles(HTTPRequest request) {
        return true;
    }

}
