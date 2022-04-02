package com.example.day02;

import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletException;
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
@WebServlet(urlPatterns = "/cookie")
public class CookieServlet  extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Cookie cookie = new Cookie("name", "zhangsan");
    Cookie cookie2 = new Cookie("address", URLEncoder.encode("广州", "UTF-8"));

//    设置cookie过期时间 为0 则cookie会被删除 -1则浏览器关闭后cookie过期    如果需要删除cookie则设置maxage为0 则服务端收到请求后会删除
//    默认为0
    cookie.setMaxAge(-1);
//    由于我们可以通过服务端往浏览器的cookie中写入数据，也可以通过js往浏览器的cookie中写入数据
//    当设置httponly为true的时候 就表示这个cookie一旦写入到浏览器之后 无法通过js操作它
    cookie.setHttpOnly(true);
//    可以设置多个cookie对象
    resp.addCookie(cookie);
    resp.addCookie(cookie2);
    resp.getWriter().write("hellocookie");

  }
}
