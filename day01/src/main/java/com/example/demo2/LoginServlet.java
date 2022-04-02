package com.example.demo2;

import com.example.demo2.service.UserService;
import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * 处理用户登录的servlet
 * @author cnmgb
 * @version 1.0
 * @date 2022/3/31
 **/

@WebServlet(urlPatterns = "/login")
public class LoginServlet  extends HttpServlet {

  private UserService userService = new UserService();
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String username = null;
    String password = null;
    if (req.getContentType().contains("urlencoded")) {
      username = req.getParameter("username");
      password = req.getParameter("password");
    } else if (req.getContentType().contains("json")) {

    }
    System.out.println("req.getContentType() = " + req.getContentType());
    System.out.println("username = " + username);
    System.out.println("password = " + password);
    int login = userService.login(username, password);
    if (login == 1) {
      System.out.println("登陆成功");
//      resp.sendRedirect("userList");
//     上面语句相当于下面两句
      resp.setStatus(302);
      resp.addHeader("Location", "userList");
    } else {
      System.out.println("登录失败");
    }


  }

}
