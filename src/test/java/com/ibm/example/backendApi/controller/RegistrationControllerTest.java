package com.ibm.example.backendApi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.example.backendApi.model.RequestPayload;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class RegistrationControllerTest {


    @Autowired
    WebApplicationContext webApplicationContext;
    protected MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void registerUser() throws Exception {
        RequestPayload requestPayload = new RequestPayload("Akash", "Akash@1111", "25.28.251.23");
        String inputJson = new ObjectMapper().writeValueAsString(requestPayload);
        String uri = "/register";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType("application/json").content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Assertions.assertNotEquals("", content);
    }

    @Test
    public void registerUserFailPassword() throws Exception {
        RequestPayload requestPayload = new RequestPayload("Akash", "akash@1", "25.28.251.23");
        String inputJson = new ObjectMapper().writeValueAsString(requestPayload);
        String uri = "/register";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType("application/json").content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(400, status);
        String content = mvcResult.getResponse().getContentAsString();
        Assertions.assertNotEquals("", content);
    }

    @Test
    void registerUserEmptyUserName() throws Exception {
        RequestPayload requestPayload = new RequestPayload("", "Akash@1111", "25.28.251.23");
        String inputJson = new ObjectMapper().writeValueAsString(requestPayload);
        String uri = "/register";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType("application/json").content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(400, status);
        String content = mvcResult.getResponse().getContentAsString();
        Assertions.assertNotEquals("", content);
    }


    private String username = "akash";

    @Test
    @Disabled("Not Implemented yet!")
    void register() {
        Assertions.assertEquals(1, 1);
    }
}

//    @Test
//    public void register_Test1() {
//      //  Mockito.when(registrationController.register(Mockito.any())).thenReturn(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
//        ResponseEntity<Object> status=registrationController.register(new RequestPayload("akash","Akash@1111","69.158.56.56"));
//        Assert.notNull(status);
//    }
//}