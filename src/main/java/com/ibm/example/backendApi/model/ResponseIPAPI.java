package com.ibm.example.backendApi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ResponseIPAPI{
    public String status;
    public String country;
    public String countryCode;
    public String region;
    public String regionName;
    public String city;
    public String zip;
    public double lat;
    public double lon;
    public String timezone;
    public String isp;
    public String org;
    public String as;
    public String query;

    @Override
    public String toString() {
        return super.toString();
    }
}
