package mite;

import org.junit.Test;
import static org.junit.Assert.*;

public class HTTPVersionTest {

    @Test
    public void version_is_version_name_when_given() {
        assertEquals("HTTP/11", HTTPVersion.fromRequest("GET / HTTP/11").version);
        assertEquals("HTTP/1.1",HTTPVersion.fromRequest("GET /monkeys HTTP/1.1").version);
    }

    @Test
    public void mimeAware_is_true_is_when_version_is_given() {
        assertTrue(HTTPVersion.fromRequest("GET / HTTP/1").mimeAware);
        assertTrue(HTTPVersion.fromRequest("GET /filthy HTTP/1.7").mimeAware);
    }

    @Test
    public void version_is_unknown_when_not_given() {
        assertEquals("Unknown", HTTPVersion.fromRequest("GET /").version);
        assertEquals("Unknown", HTTPVersion.fromRequest("GET /moo").version);
    }

    @Test
    public void mimeAware_is_false_when_no_version_given() {
        assertFalse(HTTPVersion.fromRequest("GET /").mimeAware);
        assertFalse(HTTPVersion.fromRequest("GET /moo").mimeAware);
    }

    @Test
    public void toString_is_version_name() {
        assertEquals("HTTP/11",HTTPVersion.fromRequest("GET / HTTP/11").toString());
        assertEquals("HTTP/1.1",HTTPVersion.fromRequest("GET /monkeys HTTP/1.1").toString());
    }

}
