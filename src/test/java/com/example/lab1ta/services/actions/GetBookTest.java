package com.example.lab1ta.services.actions;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.testng.Assert;

import java.io.IOException;

import static org.testng.Assert.*;

@SpringBootTest
@TestPropertySource(locations = "/applicationTest.properties")
class GetBookTest {
    @InjectMocks
    GetBook book;
    @Value("${book.isbn}")
    private String isbn;
    @Value("${url.base}")
    private String baseUrl;
    @Value("${endpoint.getBook}")
    private String getBookUrl;

    @Test
    void getBook() throws IOException {
        CloseableHttpResponse response = book.getBook(isbn, baseUrl, getBookUrl);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }
}