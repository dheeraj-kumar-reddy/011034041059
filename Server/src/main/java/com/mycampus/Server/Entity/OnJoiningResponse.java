package com.mycampus.Server.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OnJoiningResponse {
    private String id;

    private int status;

    private int errorCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "OnJoiningResponse{" +
                "id='" + id + '\'' +
                ", status=" + status +
                ", errorCode=" + errorCode +
                '}';
    }
}
