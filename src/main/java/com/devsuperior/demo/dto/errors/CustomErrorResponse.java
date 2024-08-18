package com.devsuperior.demo.dto.errors;

import java.time.OffsetDateTime;

public class CustomErrorResponse {
    private OffsetDateTime timestamp;
    private int httpStatus;
    private String httpError;
    private String message;
    private String path;

    // Construtor
    public CustomErrorResponse(OffsetDateTime timestamp, int httpStatus, String httpError, String message, String path) {
        this.timestamp = timestamp;
        this.httpStatus = httpStatus;
        this.httpError = httpError;
        this.message = message;
        this.path = path;
    }

    // Getters e Setters
    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getHttpError() {
        return httpError;
    }

    public void setHttpError(String httpError) {
        this.httpError = httpError;
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
}
