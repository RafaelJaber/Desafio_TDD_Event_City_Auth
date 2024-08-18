package com.devsuperior.demo.dto.errors;


import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidationErrorResponse extends CustomErrorResponse {

    private final List<FieldMessageResponse> messages = new ArrayList<>();

    public List<FieldMessageResponse> getMessages() {
        return messages;
    }

    public ValidationErrorResponse(OffsetDateTime timestamp, Integer status, String error, String message, String path) {
        super(timestamp, status, error, message, path);
    }

    public void addError(String fieldName, String message) {
        messages.removeIf(x -> x.getFieldName().equals(fieldName));
        messages.add(new FieldMessageResponse(fieldName, message));
    }
}
