package com.example.qf_edu_javaee;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author cnmgb
 * @date 2022/3/30
 **/
public class GenerateServlet extends GenericServlet {

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
  }

  @Override
  public void service(ServletRequest servletRequest, ServletResponse servletResponse)
      throws ServletException, IOException {
    servletResponse.setContentType("text/html;charset=utf8");
    PrintWriter writer = servletResponse.getWriter();
    writer.println("好你");
    writer.println("好=个");
    writer.println("好你个");
    writer.println("好你个");
    writer.println("好你个");
    writer.close();
  }
}
