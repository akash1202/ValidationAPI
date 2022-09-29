package com.ibm.example.backendApi.api;

import com.ibm.example.backendApi.model.ErrorResponse;
import com.ibm.example.backendApi.model.RegisterResponse;
import com.ibm.example.backendApi.model.RequestPayload;
import com.ibm.example.backendApi.service.GeoLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.*;

@RequestMapping("/")
@RestController
public class RegistrationController {

    @Autowired
    GeoLocationService geoLocationService;

    @PostMapping(value = "register")
    public ResponseEntity<Object> register(@Valid @RequestBody RequestPayload request) {
        final HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        String ip = request.getIpAddress();
        System.out.println(request.toString());
        //  String ip="142.118.214.165";    //for hard cording we could pass any ip of canada
        //String ip="66.249.69.182";  //other ip
        if (!geoLocationService.isValidLocation(ip)) {
            List<String> errors = new ArrayList<>();
            errors.add("User can register only in canada!");
            ErrorResponse errorResponse=new ErrorResponse("User is not eligible to register", errors);
            return ResponseEntity.ok().body(errorResponse);
            //return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
        } else {

            return ResponseEntity.ok().headers(header).body(new RegisterResponse(UUID.randomUUID().toString(), "welcome " + request.getUsername(), geoLocationService.getCityName()));
        }
    }
}
