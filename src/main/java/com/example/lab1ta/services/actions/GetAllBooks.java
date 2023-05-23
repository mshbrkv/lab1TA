package com.example.lab1ta.services.actions;

import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class GetAllBooks {


    public CloseableHttpResponse getBooks(String baseUrl, String getBooksUrl) throws IOException {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(baseUrl + getBooksUrl);
        get.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        return client.execute(get);
    }

}
