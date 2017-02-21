package mite.handlers;

import mite.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class EchoRequestHandlerTest {

    EchoRequestHandler handler = EchoRequestHandler.of();

    @Test
    public void can_create() {
        assertNotNull(handler);
    }

    @Test
    public void is_RequestHandler() {
        assertTrue(handler instanceof HTTPRequestHandler);
    }

    @Test
    public void response_contains_request_components() throws Exception {
        HTTPRequest request = HTTPRequest.parse("GET /monkey.png");
        HTTPResponse response = handler.handle(request);
        String page = response.page;
        assertTrue(page.contains("GET"));
        assertTrue(page.contains("monkey.png"));
    }
}
