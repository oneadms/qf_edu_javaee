package com.example.day02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author cnmgb
 * @version 1.0
 * @date 2022/4/1
 **/
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
//    解决POST请求乱码
    req.setCharacterEncoding("UTF-8");
//    解决响应乱码
    resp.setContentType("text/html;charset=utf-8");

    String username = (String) req.getParameter("username");
    String password = (String) req.getParameter("password");
    System.out.println("username+password = " + username + password);
//    username=zhansan&password=123
    if ("zhansan".equals(username) && "123".equals(
        password)) {
      resp.getWriter().write("登陆成功");
      HttpSession session = req.getSession();
      session.setAttribute("username",username);
      resp.sendRedirect("/day02/admin");
    } else {
      resp.getWriter().write("login error");
    }
  }
}
