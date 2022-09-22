package com.ibm.example.backendApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;
import java.util.List;


public class ErrorResponse implements Serializable {

    public String message;
    public List<String> details;
    public ErrorResponse(String message, List<String> details){
        super();
        this.message=message;
        this.details=details;
    }
}
