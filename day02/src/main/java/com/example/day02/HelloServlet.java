package com.example.day02;

import java.io.*;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * SingleThreadModel 实现了对service方法的同步
 */

@WebServlet(name = "helloServlet", value = "/hello-servlet")

public class HelloServlet extends HttpServlet  {

  public static int globalVar = 10;
  public HelloServlet() {
    System.out.println( "HelloServlet");
  }

  private String message;
  @Override
  public void init() {
    message = "Hello World!";
  }
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
    System.out.println("this.hashCode() = " + this.hashCode());


    globalVar--;
    System.out.println(globalVar);
    response.setContentType("text/html;charset=utf8");

    // Hello
    PrintWriter out = response.getWriter();
    out.println("<html><body>");
    out.println("<h1>" + message + "</h1>");
    out.println("</body></html>");
  }

  @Override
  public void destroy() {
  }
}