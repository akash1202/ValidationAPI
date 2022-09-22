package com.ibm.example.backendApi.controller;

import com.ibm.example.backendApi.model.RequestPayload;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
class RegistrationControllerTest {

    @Mock
    RequestPayload requestPayload;

    @InjectMocks
    RegistrationController registrationController;

    private String username="akash";

    @Test
    @Disabled("Not Implemented yet!")
    void register() {
        Assertions.assertEquals(1,1);
    }

    @Test
    public void register_Test1() {
      //  Mockito.when(registrationController.register(Mockito.any())).thenReturn(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        ResponseEntity<Object> status=registrationController.register(new RequestPayload("akash","Akash@1111","69.158.56.56"));
        Assert.notNull(status);
    }
}