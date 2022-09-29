package com.ibm.example.backendApi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter @Setter @NoArgsConstructor
public class RegisterResponse implements Serializable {

    private static final long serialVersionUID= 1223591075778321345L;
    public String uuid;
    public String message;
    public String cityName;

    public RegisterResponse(String uuid, String message, String cityName) {
        super();
        this.uuid = uuid;
        this.message = message;
        this.cityName = cityName;
    }
}
