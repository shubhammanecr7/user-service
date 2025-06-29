package com.skvm.user_service.error;

import java.time.LocalDateTime;

public class ErrorResponse {

    private LocalDateTime localDateTime;
    private String message;
    private int status;
    private String path;

    public ErrorResponse(LocalDateTime localDateTime, String message, int status, String path) {
        this.localDateTime = localDateTime;
        this.message = message;
        this.status = status;
        this.path = path;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
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
