package com.ibm.example.backendApi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.example.backendApi.model.ResponseIPAPI;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeoLocationService {
    private static boolean isValidLocation=false;
    private static ResponseIPAPI responseIPAPI=null;
    private static String URL_IP_API="http://ip-api.com/json/";
    public boolean isValidLocation(String ip){
        String result= new RestTemplate().getForObject(URL_IP_API+ip,String.class);
        try{
            responseIPAPI=new ObjectMapper().readValue(result,ResponseIPAPI.class);
            if (responseIPAPI.getCountryCode().equalsIgnoreCase("CA")) isValidLocation=true;
            else isValidLocation=false;
        }catch (JsonMappingException e){
            e.printStackTrace();
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return isValidLocation;
    }

    public String getCityName(){
            if (isValidLocation&&responseIPAPI.getCity()!=null)
                return responseIPAPI.getCity();
        return null;
    }

}
