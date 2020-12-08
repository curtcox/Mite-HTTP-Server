package mite;

import java.util.*;

/**
 * HTTP version.
 */
public final class HTTPVersion {

    public final boolean mimeAware;
    public final String version;
    public static final HTTPVersion Unknown = new HTTPVersion("Unknown",false);

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
        return "Unknown";
    }

    public String toString() {
        return version;
    }
}
