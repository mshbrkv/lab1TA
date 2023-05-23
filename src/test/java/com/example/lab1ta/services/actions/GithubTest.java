package com.example.lab1ta.services.actions;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.testng.Assert;

import java.io.IOException;
import java.util.UUID;

@SpringBootTest
@TestPropertySource(locations = "/applicationTest.properties")
class GithubTest {

    @Value("${gitHub.urlReposPost}")
    private String postUrl;
    @Value("${gitHub.urlReposGet}")
    private String getUrl;
    @Value("${gitHub.urlReposDelete}")
    private String deleteUrl;

    @Test()
    void testPostAndDeleteRepo() throws IOException {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        String randomUUID = UUID.randomUUID().toString();
        String token = "Bearer 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";
        String json = "{\"name\": \"" + randomUUID + "\", \"description\": \"" + "repository for lab 1 (POST)" + "\", \"private\": false}";

        HttpPost post = new HttpPost(postUrl);
        post.setHeader(HttpHeaders.AUTHORIZATION, token);
        post.setEntity(new StringEntity(json));
        CloseableHttpResponse responsePost = client.execute(post);
        Assert.assertEquals(responsePost.getStatusLine().getStatusCode(), HttpStatus.SC_CREATED, "check status after creat repo");

        HttpGet get = new HttpGet(getUrl);
        CloseableHttpResponse responseGet = client.execute(get);
        String jsonBody = EntityUtils.toString(responseGet.getEntity());
        Assert.assertTrue(jsonBody.contains(randomUUID));

        HttpDelete delete = new HttpDelete(deleteUrl + randomUUID);
        delete.setHeader(HttpHeaders.AUTHORIZATION, token);
        delete.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        CloseableHttpResponse responseDelete = client.execute(delete);
        Assert.assertEquals(responseDelete.getStatusLine().getStatusCode(), HttpStatus.SC_NO_CONTENT);
    }
}
