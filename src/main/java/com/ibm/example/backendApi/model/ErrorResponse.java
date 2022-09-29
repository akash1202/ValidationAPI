package com.ibm.example.backendApi.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter @Setter
public class ErrorResponse implements Serializable{

    private static final long serialVersionUID= 1223391075778321342L;
    private String message;
    private List<String> details;

    public ErrorResponse() {
    }

    public ErrorResponse(String message, List<String> details) {
        super();
        this.message = message;
        this.details = details;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
