package mite.handlers;

import mite.*;

/**
 * Simple handler mostly for demonstration and debugging.
 */
public final class EchoRequestHandler
    extends AbstractRequestHandler
{

    public static EchoRequestHandler of() {
        return new EchoRequestHandler();
    }

    private EchoRequestHandler() {}

    public HTTPResponse handle(HTTPRequest request) {
        String R = "\r";
        String html = "<html>" +
                  "<body>" +
                      "<pre>" +
                          "request =" + request          + R +
                          "method  =" + request.method   + R +
                          "filename=" + request.filename + R +
                      "</pre>" +
                  "</body>" +
               "</html>";
        return HTTPResponse.of(html,StatusCode.OK);
    }

}
