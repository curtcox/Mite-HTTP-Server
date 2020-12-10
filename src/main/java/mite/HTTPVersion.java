package mite;

import java.util.*;

/**
 * HTTP version.
 */
public final class HTTPVersion {

    public final boolean mimeAware;
    public final String version;
    private static final String UNKNOWN = "Unknown";
    public static final HTTPVersion Unknown = new HTTPVersion(UNKNOWN,false);

    private HTTPVersion(String version,boolean mimeAware) {
        this.version = version;
        this.mimeAware = mimeAware;
    }

    public static HTTPVersion fromRequest(String request) {
        String versionString = versionString(request);
        return new HTTPVersion(versionString,versionString.startsWith("HTTP"));
    }

    private static String versionString(String request) {
        final StringTokenizer st = new StringTokenizer(request);
        st.nextToken(); // we don't care about the method
        st.nextToken(); // or what is being requested
        if (st.hasMoreTokens()) {
            return st.nextToken();
        }
        return UNKNOWN;
    }

    public String toString() {
        return version;
    }
}
