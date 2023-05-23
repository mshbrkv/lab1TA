package com.example.lab1ta.services.actions;

import com.example.lab1ta.services.dto.BookDTO;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

public class GetBook {

    public CloseableHttpResponse getBook(String isbn, String baseUrl, String getBookUrl) throws IOException {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(baseUrl + getBookUrl+"?ISBN="+isbn);
        get.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        return client.execute(get);
    }
}
