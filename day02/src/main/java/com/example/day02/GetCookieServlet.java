package com.example.day02;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.Thread.UncaughtExceptionHandler;
import java.net.CookieManager;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.function.BiConsumer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cnmgb
 * @version 1.0
 * @date 2022/4/1
 **/
@WebServlet(urlPatterns = "/getcookie")
public class GetCookieServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Cookie[] cookies = req.getCookies();
    Arrays.stream(cookies).forEach((cookie) -> {
      BiConsumer biConsumer = (o, o2) -> {
        if ("address".equals(o)) {
          try {
            System.out.println(URLDecoder.decode((String) o2, "UTF-8"));
          } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
          }
        } else {

          System.out.println(o+" "+o2);
        }
      };
    biConsumer.accept(cookie.getName(),cookie.getValue());


    });
  }
}
