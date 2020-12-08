package mite;

public final class HTTPResponse {

    public final String page;
    public final StatusCode status;

    public static HTTPResponse of(String page, StatusCode status) {
        return new HTTPResponse(page,status);
    }

    private HTTPResponse(String page, StatusCode status) {
        this.page = page;
        this.status = status;
    }
}
