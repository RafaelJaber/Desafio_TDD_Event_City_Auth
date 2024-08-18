package com.devsuperior.demo.dto.errors;


import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidationErrorResponse extends CustomErrorResponse {

    private final List<FieldMessageResponse> errors = new ArrayList<>();

    public List<FieldMessageResponse> getErrors() {
        return errors;
    }

    public ValidationErrorResponse(OffsetDateTime timestamp, Integer status, String error, String message, String path) {
        super(timestamp, status, error, message, path);
    }

    public void addError(String fieldName, String message) {
        errors.removeIf(x -> x.getFieldName().equals(fieldName));
        errors.add(new FieldMessageResponse(fieldName, message));
    }
}
