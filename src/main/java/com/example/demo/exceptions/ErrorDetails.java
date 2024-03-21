package com.example.demo.exceptions;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ErrorDetails {
    private Date timestamp;
    private Number status;
    private String message;
    // private String details;
    private List<String> details;

    public ErrorDetails(Date timestamp, Number status, String message, List<String> details) {
        super();
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.details = details;
    }

    public ErrorDetails(Date timestamp, Number status, String message, String detail) {
        super();
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.details = Arrays.asList(detail);
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public Number getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getDetails() {
        return details;
    }
}
