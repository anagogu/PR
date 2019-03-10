package com.ana;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpURLConnectionExample {
    private final String USER_AGENT = "Chrome/72.0.3626.81";

    public void sendGet() throws Exception {

        String url = "https://httpbin.org";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

    }

    // HTTP POST request
    public void sendPost() throws Exception {

        String url = "https://httpbin.org";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

    }

    // HTTP PUT request
    public void sendPut() throws Exception {
        URL url = null;
        URL obj = new URL("https://httpbin.org");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        try {
            url = new URL("https://httpbin.org");
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }
        HttpURLConnection httpURLConnection = null;
        DataOutputStream dataOutputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestMethod("PUT");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'PUT' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.flush();
                    dataOutputStream.close();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }
    // HTTP DELETE request
    public void sendDelete() throws Exception {
        URL url = null;

        try {
            url = new URL("https://httpbin.org");
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            httpURLConnection.setRequestMethod("DELETE");
            System.out.println("Response Code : " + httpURLConnection.getResponseCode());
            System.out.println("\nSending 'DELETE' request to URL : " + url);
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }
}


