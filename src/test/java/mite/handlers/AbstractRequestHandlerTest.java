package mite.handlers;

import mite.*;
import org.junit.Test;
import java.io.*;
import static org.junit.Assert.*;

public class AbstractRequestHandlerTest {

static class TestHandler extends AbstractRequestHandler {
    @Override
    protected boolean handles(HTTPRequest request) {
        return false;
    }

    @Override
    protected String handle(HTTPRequest request) throws IOException {
        return null;
    }
}

    @Test
    public void is_a_RequestHandler() {
        assertTrue(new TestHandler() instanceof RequestHandler);
    }

    @Test
    public void handles_returns_false_when_request_parsing_fails() {
        RequestHandler handler = new TestHandler();
        assertFalse(handler.handles(""));
        assertFalse(handler.handles("What?"));
        assertFalse(handler.handles("What the?"));
        assertFalse(handler.handles("What the smeg?"));
        assertFalse(handler.handles("Dude, this is so not valid."));
    }
}
