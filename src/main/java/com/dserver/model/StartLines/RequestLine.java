package com.dserver.model.StartLines;

public class RequestLine {
    private HttpMethod method;
    private String requestUrl;

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getHttpVersion() {
        return httpVersion;
    }

    public void setHttpVersion(String httpVersion) {
        this.httpVersion = httpVersion;
    }

    private String httpVersion;

    public RequestLine(String[] requestLineParameters) {
        this.method = HttpMethod.valueOf(requestLineParameters[0]);
        this.requestUrl = requestLineParameters[1];
        this.httpVersion = requestLineParameters[2];
    }
}
