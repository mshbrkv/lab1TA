package com.example.lab1ta.services.actions;

import com.example.lab1ta.services.dto.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.UUID;

public class CreateUser {

    public CloseableHttpResponse userCreation(String username, String password, String baseUrl, String createUserEndpoint) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        UserDTO userDTO = new UserDTO();
        String randomUUID = UUID.randomUUID().toString();
        userDTO.setUserName(username + randomUUID);
        userDTO.setPassword(password);
        String json = objectMapper.writeValueAsString(userDTO);
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(baseUrl + createUserEndpoint);
        post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        post.setEntity(new StringEntity(json));

        return client.execute(post);
    }
}
