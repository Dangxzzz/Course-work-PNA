package com.example.kp_psp.RequestResponse;

import java.util.Map;

public class Request {
    private RequestType type;
    private Map<String, String> data;

    public Request(RequestType type, Map<String, String> data) {
        this.type = type;
        this.data = data;
    }

    public RequestType getType() {
        return type;
    }

    public Map<String, String> getData() {
        return data;
    }
}
