package mite.handlers;

import mite.*;
import java.io.*;
import java.net.*;

public abstract class AbstractRequestHandler
    implements RequestHandler
{
    final public void handle(String request, Socket socket, InputStream in, OutputStream out) throws IOException {
        HTTPRequest httpRequest = HTTPRequest.parse(request);
        Writer writer = new OutputStreamWriter(out);
        String page = handle(httpRequest);
        if (httpRequest.httpVersion.mimeAware) {
            ContentType.HTML.writeMIMEHeader(writer, StatusCode.OK, page.length());
        }
        writer.write(page);
        writer.close();
        socket.close();
    }

    final public boolean handles(String request) {
        return handles(HTTPRequest.parse(request));
    }

    protected abstract boolean handles(HTTPRequest request);
    protected abstract String handle(HTTPRequest request) throws IOException;

}
