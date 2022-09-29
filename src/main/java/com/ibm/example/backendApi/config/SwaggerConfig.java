package com.ibm.example.backendApi.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.RequestHandlerSelectors.withClassAnnotation;
import static springfox.documentation.builders.RequestHandlerSelectors.withMethodAnnotation;

@Configuration
public class SwaggerConfig {

    @Autowired
    private  RestApiProperties restApiProperties;

    @Bean
    public Docket mainApi(){
        return getCommonDocketBuilder(restApiProperties.getTitle()).build().useDefaultResponseMessages(false);
        //default message adds 201 and other response to Swagger docs
    }
    /*
    * only exposing those methods that are explicitly annotated as API opeartion
    * */
    private ApiSelectorBuilder getCommonDocketBuilder(String groupName){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(groupName)
                .apiInfo(apiInfo())
                .select()
                .apis(withClassAnnotation(Api.class))
                .apis(withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any());
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Registration Rest API")
                .description("Rest API which validate User Registeration Request by valid IP")
                .termsOfServiceUrl("thisisrestapi.test/service")
                .version("0.0.1")
                .contact(getContact())
                .build();
    }

    private Contact getContact(){
        return new Contact("Rest API Support","test.ibm.com/support","support@restapi.test");
    }
}
