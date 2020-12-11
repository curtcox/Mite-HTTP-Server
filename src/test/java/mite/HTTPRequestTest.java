package mite;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class HTTPRequestTest {

    @Test
    public void httpVersion_is_set_when_parsing_fails() {
        String string = toString();
        HTTPRequest request = parse(string);
        assertEquals("Unknown",request.httpVersion.version);
        assertFalse(request.httpVersion.mimeAware);
    }

    @Test
    public void string_is_set_when_parsing_fails() {
        String string = toString();
        HTTPRequest request = parse(string);
        assertSame(string, request.string);
    }

    @Test
    public void method_is_set_from_request() {
        assertEquals("GET",parse("GET /").method);
        assertEquals("GET",parse("GET /whatever").method);
        assertEquals("GET",parse("GET /foo HTTP/1.0").method);
        assertEquals("GET",parse("GET / HTTP/1.1").method);
    }

    @Test
    public void filename_is_set_from_request() {
        assertEquals("/",        parse("GET /").filename);
        assertEquals("/whatever",parse("GET /whatever").filename);
        assertEquals("/foo",     parse("GET /foo HTTP/1.0").filename);
        assertEquals("/",        parse("GET / HTTP/1.1").filename);
    }

    @Test
    public void httpVersion_is_set_from_request() {
        assertEquals("Unknown",  parse("GET /").httpVersion.toString());
        assertEquals("Unknown",  parse("GET /whatever").httpVersion.toString());
        assertEquals("HTTP/1.0", parse("GET /foo HTTP/1.0").httpVersion.toString());
        assertEquals("HTTP/1.1", parse("GET / HTTP/1.1").httpVersion.toString());
    }

    static HTTPRequest parse(String request) {
        return HTTPRequest.parse(request);
    }
}
