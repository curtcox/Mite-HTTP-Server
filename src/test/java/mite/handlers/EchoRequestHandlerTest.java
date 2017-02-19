package mite.handlers;

import mite.HTTPRequest;
import mite.RequestHandler;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class EchoRequestHandlerTest {

    EchoRequestHandler handler = EchoRequestHandler.of();

    @Test
    public void can_create() {
        assertNotNull(handler);
    }

    @Test
    public void is_RequestHandler() {
        assertTrue(handler instanceof RequestHandler);
    }

    @Test
    public void response_contains_request_components() throws Exception {
        HTTPRequest request = HTTPRequest.parse("GET /monkey.png");
        String response = handler.handle(request);
        assertTrue(response.contains("GET"));
        assertTrue(response.contains("monkey.png"));
    }
}