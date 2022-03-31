package com.example.qf_edu_javaee;

import com.example.qf_edu_javaee.common.exception.ApiException;
import com.example.qf_edu_javaee.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cnmgb
 * @date 2022/3/31
 **/
@WebServlet(urlPatterns = "/login")
public class LoginServlet  extends HttpServlet {

  private UserService userService = new UserService();
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html;charset=utf8");
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    PrintWriter writer = resp.getWriter();
    boolean flag = false;
    try {
      flag = userService.login(username, password);
      if (flag) {
        writer.println("登录成功");
      }else{
        writer.println("登录失败");
      }
    } catch (ApiException e) {
      writer.println(e.getMessage());
    }finally {
      writer.close();
    }

  }
}
