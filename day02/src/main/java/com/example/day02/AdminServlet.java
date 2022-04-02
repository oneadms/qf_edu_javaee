package com.example.day02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cnmgb
 * @version 1.0
 * @date 2022/4/1
 * 假如这是我的后台管理页面 用户访问该页面 必须先登录
 **/
@WebServlet(urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
//    if (req.getSession().getAttribute("username") == null) {
//      resp.getWriter().write("请登录");
//      return;
//    }
//
    resp.getWriter().write("hello admin");

  }
}
