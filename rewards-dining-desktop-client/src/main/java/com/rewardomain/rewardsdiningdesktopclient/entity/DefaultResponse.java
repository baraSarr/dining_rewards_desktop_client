package com.rewardomain.rewardsdiningdesktopclient.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DefaultResponse {
    @JsonProperty("status_code")
    private int code;
    private String message;

    private String executionChain;

    public DefaultResponse() {
    }

    public DefaultResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getExecutionChain() {
        return executionChain;
    }

    public void setExecutionChain(String executionChain) {
        this.executionChain = executionChain;
    }
}
