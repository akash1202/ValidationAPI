package com.ibm.example.backendApi.model;

import com.fasterxml.jackson.annotation.*;
import com.ibm.example.backendApi.constraint.ValidPassword;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;


public class RequestPayload implements Serializable {

    private static final long serialVersionUID= 1123391075778321362L;
    @NotBlank(message = "username must not be blank")
    private String username;

    @NotBlank(message = "password must not be blank")
    @Size(min = 8,message="password need to be longer than 8 characters")
    @ValidPassword(message = "password must contain atleast 1 Uppercase,1 Number,1 Special Character")
    private String password;


    @NotBlank(message = "IP address must not be blank")
    private String ipAddress;

    public RequestPayload(String username, String password, String ipAddress) {
        super();
        this.username = username;
        this.password = password;
        this.ipAddress = ipAddress;
    }

    public RequestPayload(){
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }


    @Override
    public String toString() {
        return "RequestPayload: "+username+" "+ password+" "+ipAddress;
    }
}
