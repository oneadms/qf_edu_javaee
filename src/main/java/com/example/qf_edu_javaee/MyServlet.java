package com.example.qf_edu_javaee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * @author cnmgb
 * @date 2022/3/30
 **/

@WebServlet(name="myServlet",value = "/myServlet")
public class MyServlet implements Servlet {

  @Override
  public void init(ServletConfig servletConfig) throws ServletException {
    System.out.println("servletConfig = " + servletConfig);
  }

  @Override
  public ServletConfig getServletConfig() {
    return null;
  }

  @Override
  public void service(ServletRequest servletRequest, ServletResponse servletResponse)
      throws ServletException, IOException {
        servletResponse.setContentType("text/html;charset=utf-8");
    PrintWriter writer = servletResponse.getWriter();
    writer.println("你十七张牌能秒我?");
  }

  @Override
  public String getServletInfo() {
    return MyServlet.class.getName();
  }

  @Override
  public void destroy() {
    System.out.println("销毁");
  }
}
