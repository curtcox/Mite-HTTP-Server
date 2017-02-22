package mite.handlers;

import mite.*;
import org.junit.Test;
import java.io.*;
import static org.junit.Assert.*;

public class AbstractRequestHandlerTest {

static class TestHandler extends AbstractRequestHandler {

    @Override
    public boolean handles(HTTPRequest request) {
        return false;
    }

    @Override
    public HTTPResponse handle(HTTPRequest request) throws IOException {
        return null;
    }
}

    @Test
    public void is_a_RequestHandler() {
        assertTrue(new TestHandler() instanceof HTTPRequestHandler);
    }

}
