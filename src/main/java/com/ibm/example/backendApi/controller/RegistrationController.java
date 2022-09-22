package com.ibm.example.backendApi.controller;

import com.ibm.example.backendApi.model.RequestPayload;
import com.ibm.example.backendApi.service.GeoLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;


@RequestMapping("/")
@RestController
public class RegistrationController {

    @Autowired
    GeoLocationService geoLocationService;

//    @Autowired
//    ValidatorService validatorService;

//    @RequestMapping("/register2")
//    public ResponseEntity<String> register2(@RequestParam String username, @RequestParam String password, HttpServletRequest request){
//        String s="";
//        //String ip=request.getRemoteAddr();
//        String ip="142.118.214.165";    //for hard cording we could pass any ip of canada
//        //String ip="66.249.69.182";
//
//        if(username==null || username.isEmpty() ) {
//            s= "{\r\n" +
//                    "\"error\":"+"username parameter is required"+" \r\n" +
//                    "}";
//        }
//        else if(password==null || password.isEmpty()){
//            s= "{\r\n" +
//                    "\"error\":"+"password parameter is required"+" \r\n" +
//                    "}";
//        }else if(!validatorService.isValidPassword(password)){
//            s= "{\r\n" +
//                    "\"error\":"+"password parameter is invalid"+" \r\n" +
//                    "}";
//        }else if(!geoLocationService.isValidLocation(ip)){
//            s= "{\r\n" +
//                    "\"error\":"+"user is not eligible to register"+" \r\n" +
//                    "}";
//        }else{
//            s= "{\r\n" +
//                    "\"uuid\":"+ UUID.randomUUID().toString() +", \r\n" +
//                    "\"message\":"+"welcome " +username+ ", \r\n" +
//                    "\"cityName\":"+geoLocationService.getCityName()+" \r\n" +
//                    "}";
//            final HttpHeaders header=new HttpHeaders();
//            header.setContentType(MediaType.APPLICATION_JSON);
//            return new ResponseEntity<>(s,HttpStatus.OK);
//        }
//        return new ResponseEntity<>(s,HttpStatus.BAD_REQUEST);
//    }


    @RequestMapping(value = "register")
    public ResponseEntity<Object> register(@Valid @RequestBody RequestPayload request){
        String s="";
        String ip=request.getIpAddress();
        System.out.println(request.toString());
      //  String ip="142.118.214.165";    //for hard cording we could pass any ip of canada
      //String ip="66.249.69.182";  //other ip
            if (!geoLocationService.isValidLocation(ip)) {
                s = "{\r\n" +
                        "\"error\":" + "user is not eligible to register" + " \r\n" +
                        "}";
            } else {
                s = "{\r\n" +
                        "\"uuid\":" + UUID.randomUUID().toString() + ", \r\n" +
                        "\"message\":" + "welcome " + request.getUsername() + ", \r\n" +
                        "\"cityName\":" + geoLocationService.getCityName() + " \r\n" +
                        "}";
                final HttpHeaders header = new HttpHeaders();
                header.setContentType(MediaType.APPLICATION_JSON);
                return new ResponseEntity<>(s, HttpStatus.OK);
            }
        return new ResponseEntity<>(s,HttpStatus.BAD_REQUEST);
    }

}
