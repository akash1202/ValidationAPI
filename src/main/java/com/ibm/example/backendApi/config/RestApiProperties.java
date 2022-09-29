package com.ibm.example.backendApi.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "info")
@Getter @Setter
public class RestApiProperties {
    private String title;
    private String description;
    private String version;
}
