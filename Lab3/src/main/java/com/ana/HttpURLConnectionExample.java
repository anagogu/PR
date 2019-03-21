package com.ana;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpURLConnectionExample {
     private final String USER_AGENT = "Chrome/72.0.3626.81";


    public void sendGet() throws Exception {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet getRequest = new HttpGet("https://httpbin.org/get");

        try (CloseableHttpResponse httpResponse = httpClient.execute(getRequest)) {
            statusMetode(httpResponse);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // HTTP POST request
    public void sendPost() throws Exception {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost postRequest = new HttpPost("https://httpbin.org/post");

        try (CloseableHttpResponse httpResponse = httpClient.execute(postRequest)) {
            statusMetode(httpResponse);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // HTTP PUT request
    public void sendPut() {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPut putRequest = new HttpPut("https://httpbin.org/put");

            try (CloseableHttpResponse httpResponse = httpClient.execute(putRequest)) {
                statusMetode(httpResponse);

            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    // HTTP DELETE request
    public void sendDelete() {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpDelete deleteRequest = new HttpDelete("https://httpbin.org/delete");

        try (CloseableHttpResponse httpResponse = httpClient.execute(deleteRequest)) {
            statusMetode(httpResponse);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void statusMetode(HttpResponse httpResponse) throws Exception {

        String content = EntityUtils.toString(httpResponse.getEntity());

        String url = "https://httpbin.org";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        System.out.println("statusCode = " + statusCode);
        System.out.println("content = " + content);
        System.out.println("User-Agent = " + USER_AGENT);
        wr.flush();
        wr.close();
    }
}


