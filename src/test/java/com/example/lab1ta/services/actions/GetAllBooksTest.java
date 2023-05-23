package com.example.lab1ta.services.actions;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

@SpringBootTest
@TestPropertySource(locations = "/applicationTest.properties")
class GetAllBooksTest {
    @InjectMocks
    GetAllBooks books;

    @Value("${url.base}")
    private String baseUrl;
    @Value("${endpoint.getInfoAboutAllBooks}")
    private String getBooksUrl;

    @Test
    void getBook() throws IOException {
        CloseableHttpResponse response = books.getBooks(baseUrl, getBooksUrl);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }
}