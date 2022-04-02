package com.example.day02;

import java.io.IOException;
import java.lang.reflect.Proxy;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cnmgb
 * @version 1.0
 * @date 2022/4/1
 **/
@WebServlet("/context")
public class ContextServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
//    由于servletcontext是一个全局对象，一个web应用里面只有一个servletcontext对象 无论通过那种方式获取 获取的都是同一个servletcontext
    ServletContext sc1 = req.getServletContext();

    ServletContext sc2 = getServletContext();

    System.out.println(sc1 == sc2);
    String contextPath = sc1.getContextPath();
//    获取项目的上下文地址 即项目的部署名称
    System.out.println("contextPath = " + contextPath);
//    获取项目的真实路径
    String realPath = sc1.getRealPath("/");
    System.out.println("realPath = " + realPath);





  }
}
