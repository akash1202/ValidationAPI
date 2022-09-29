package com.ibm.example.backendApi.api;

import com.ibm.example.backendApi.model.ErrorResponse;
import com.ibm.example.backendApi.model.RegisterResponse;
import com.ibm.example.backendApi.model.RequestPayload;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

public interface RegistrationApi {

    @ApiOperation(value="Use this endpoint to register the user",nickname = "register", tags={})
    @ApiResponses(value={
            @ApiResponse(code= HttpServletResponse.SC_OK,message = "Success",response = RegisterResponse.class),
            @ApiResponse(code= HttpServletResponse.SC_BAD_REQUEST,message = "Bad Request",response = Object.class)
    })
    @PostMapping(value = "register",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> register(@Valid @RequestBody RequestPayload request);
}
