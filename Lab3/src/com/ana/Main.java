package com.ana;

public class Main {

    public static void main(String[] args) throws Exception {
            HttpURLConnectionExample http = new HttpURLConnectionExample();

            System.out.println("Testing 1 - Send Http GET request");
            http.sendGet();

            System.out.println("\nTesting 2 - Send Http POST request");
            http.sendPost();

            System.out.println("Testing 3 - Send Http PUT request");
            http.sendPut();

            System.out.println("\nTesting 4 - Send Http DELETE request");
            http.sendDelete();

    }
}
