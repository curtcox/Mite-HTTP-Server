package mite;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class HTTPRequestTest {

    @Test
    public void error_is_set_when_parsing_fails() {
        String string = toString();
        HTTPRequest request = HTTPRequest.parse(string);
        assertTrue(request.error instanceof NoSuchElementException);
    }

    @Test
    public void httpVersion_is_set_when_parsing_fails() {
        String string = toString();
        HTTPRequest request = HTTPRequest.parse(string);
        assertEquals("Unknown",request.httpVersion.version);
        assertFalse(request.httpVersion.mimeAware);
    }

    @Test
    public void string_is_set_when_parsing_fails() {
        String string = toString();
        HTTPRequest request = HTTPRequest.parse(string);
        assertSame(string, request.string);
    }

    @Test
    public void method_is_set_from_request() {
        assertEquals("GET",HTTPRequest.parse("GET /").method);
        assertEquals("GET",HTTPRequest.parse("GET /whatever").method);
        assertEquals("GET",HTTPRequest.parse("GET /foo HTTP/1.0").method);
        assertEquals("GET",HTTPRequest.parse("GET / HTTP/1.1").method);
    }

    @Test
    public void filename_is_set_from_request() {
        assertEquals("/",        HTTPRequest.parse("GET /").filename);
        assertEquals("/whatever",HTTPRequest.parse("GET /whatever").filename);
        assertEquals("/foo",     HTTPRequest.parse("GET /foo HTTP/1.0").filename);
        assertEquals("/",        HTTPRequest.parse("GET / HTTP/1.1").filename);
    }

    @Test
    public void httpVersion_is_set_from_request() {
        assertEquals("Unknown",  HTTPRequest.parse("GET /").httpVersion.toString());
        assertEquals("Unknown",  HTTPRequest.parse("GET /whatever").httpVersion.toString());
        assertEquals("HTTP/1.0", HTTPRequest.parse("GET /foo HTTP/1.0").httpVersion.toString());
        assertEquals("HTTP/1.1", HTTPRequest.parse("GET / HTTP/1.1").httpVersion.toString());
    }

}