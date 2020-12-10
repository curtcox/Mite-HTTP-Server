package mite;

import java.io.*;
import java.net.*;

final class SocketRequestHandler {

  final HTTPRequestHandler handler;

  private SocketRequestHandler(HTTPRequestHandler handler) {
      this.handler = handler;
  }

  static SocketRequestHandler of(HTTPRequestHandler handler) {
      return new SocketRequestHandler(handler);
  }

  final void handle(String request, Socket socket, OutputStream out) throws IOException {
      HTTPRequest httpRequest = HTTPRequest.parse(request);
      Writer           writer = new OutputStreamWriter(out);
      HTTPResponse   response = handler.handle(httpRequest);
      String             page = response.page;
      if (httpRequest.httpVersion.mimeAware) {
          ContentType.HTML.writeMIMEHeader(writer, response.status, page.length());
      }
      writer.write(page);
      writer.close();
      socket.close();
  }

  final boolean handles(String request) {
      return handler.handles(HTTPRequest.parse(request));
  }

}
