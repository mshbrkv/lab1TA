package com.example.lab1ta.services.actions;

import com.example.lab1ta.services.dto.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.testng.Assert;

import java.io.IOException;
import java.util.UUID;

@SpringBootTest
@TestPropertySource(locations = "/applicationTest.properties")
class CreateUserTest {
    @InjectMocks
    CreateUser user;
    @Value("${user.trueUsername}")
    private String trueUsername;
    @Value("${user.truePassword}")
    private String truePassword;
    @Value("${user.falseUsername}")
    private String falseUsername;
    @Value("${user.falsePassword}")
    private String falsePassword;
    @Value("${url.base}")
    private String baseUrl;
    @Value("${endpoint.user}")
    private String createUserEndpoint;

    @Test
    void successfulCreation() throws IOException {
        CloseableHttpResponse response = user.userCreation(trueUsername, truePassword, baseUrl, createUserEndpoint);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), 201);

    }

    @Test
    void errorCreation() throws IOException {
        CloseableHttpResponse response = user.userCreation(falseUsername, falsePassword, baseUrl, createUserEndpoint);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), 400);
    }
}