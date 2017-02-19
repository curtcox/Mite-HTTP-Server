package mite;

import java.util.StringTokenizer;

public final class HTTPRequest {

    public final String string;
    public final String method;
    public final String filename;
    public final HTTPVersion httpVersion;
    public final Exception error;

    public static HTTPRequest parse(String string) {
        try {
            StringTokenizer tokenizer = new StringTokenizer(string);
            String method = tokenizer.nextToken();
            String filename = tokenizer.nextToken();
            return new HTTPRequest(string, method, filename, HTTPVersion.fromRequest(string),null);
        } catch (Exception e) {
            return new HTTPRequest(string,null,null,HTTPVersion.Unknown,e);
        }
    }

    private HTTPRequest(String string, String method, String filename, HTTPVersion httpVersion, Exception error) {
        this.string = string;
        this.method = method;
        this.filename = filename;
        this.httpVersion = httpVersion;
        this.error = error;
    }
}
