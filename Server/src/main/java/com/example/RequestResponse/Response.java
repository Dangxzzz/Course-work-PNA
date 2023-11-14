package com.example.RequestResponse;

import java.util.Map;

public class Response {
    private ResponseStatus status;
    private Map<String, String> data;

    public Response(ResponseStatus status, Map<String, String> data) {
        this.status = status;
        this.data = data;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public Map<String, String> getData() {
        return data;
    }
}
