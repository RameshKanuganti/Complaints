package com.valuepack.complaints.complaints.util;

import org.springframework.http.HttpStatus;

import java.sql.Timestamp;
import java.util.Date;

public class CompliantResponse {

    private long timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
    private Object resultObject;

    public CompliantResponse(int status, String error, String message, String path, Object resultObject) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.resultObject = resultObject;
        this.timestamp = new Timestamp(new Date().getTime()).getTime();
    }

    public CompliantResponse() {
        this.timestamp = new Timestamp(new Date().getTime()).getTime();
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Object getResultObject() {
        return resultObject;
    }

    public void setResultObject(Object resultObject) {
        this.resultObject = resultObject;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StarLeadResponse{" +
                "timestamp=" + timestamp +
                ", status=" + status +
                ", error='" + error + '\'' +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                ", resultObject=" + resultObject +
                '}';
    }

}