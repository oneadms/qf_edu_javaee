package com.example.day02;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import sun.net.www.http.HttpClient;

/**
 * @author cnmgb
 * @version 1.0
 * @date 2022/4/1
 **/
public class Test {

  public static void main(String[] args) throws IOException {
    for (int i =0  ;i<1000;i++) {
      URL url = new URL("http://localhost:8080/day02/hello-servlet");
      URLConnection urlConnection = url.openConnection();
      urlConnection.getInputStream();
      urlConnection.connect();
    }

  }

}
