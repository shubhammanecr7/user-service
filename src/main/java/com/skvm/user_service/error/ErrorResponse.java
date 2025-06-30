package com.skvm.user_service.error;

import java.time.LocalDateTime;

public class ErrorResponse {

    private LocalDateTime timestamp;
    private String message;
    private int status;
    private String path;

    public ErrorResponse(LocalDateTime timestamp, String message, int status, String path) {
        this.timestamp = timestamp;
        this.message = message;
        this.status = status;
        this.path = path;
    }

    public LocalDateTime getLocalDateTime() {
        return timestamp;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.timestamp = localDateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
