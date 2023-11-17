package com.example.RequestResponse;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Response implements Serializable {
    private ResponseStatus status;
    private Object data;

    public Response(ResponseStatus status, Object data) {
        this.status = status;
        this.data = data;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public Object getData() {
        return data;
    }
}