package mite;

import java.util.*;

public final class HTTPRequest {

    public final String string; // The entire unparsed request string we were sent
    public final String method; // GET, POST, etc...
    public final String filename;
    public final HTTPVersion httpVersion;

    public static HTTPRequest parse(String string) {
        try {
            StringTokenizer tokenizer = new StringTokenizer(string);
            String   method = tokenizer.nextToken();
            String filename = tokenizer.nextToken();
            return new HTTPRequest(string, method, filename, HTTPVersion.fromRequest(string));
        } catch (Exception e) {
            return new HTTPRequest(string,null,null,HTTPVersion.Unknown);
        }
    }

    private HTTPRequest(String string, String method, String filename, HTTPVersion httpVersion) {
        this.string = string;
        this.method = method;
        this.filename = filename;
        this.httpVersion = httpVersion;
    }
}
