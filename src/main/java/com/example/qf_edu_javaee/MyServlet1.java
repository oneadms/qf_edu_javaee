package com.example.qf_edu_javaee; /**
 * @author cnmgb
 * @date 2022/3/30
 **/

import com.sun.media.sound.SoftTuning;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MyServlet1", urlPatterns = {"/MyServlet1/*"})
public class MyServlet1 extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doMsg(request);
  }

  private void doMsg(HttpServletRequest request) {
    System.out.println("request.getClass().getName() = " + request.getClass().getName());

    String contextPath = request.getContextPath();
    String servletPath = request.getServletPath();
    String pathInfo = request.getPathInfo();
    log("contextPath = " + contextPath);

    log("servletPath = " + servletPath);
    log("pathInfo = " + pathInfo);
    String[] urlVar = pathInfo.split("/");
    for (int i = 1; i < urlVar.length; i++) {
      log(urlVar[i]);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doMsg(request);
  }

  @Override
  protected void doPut(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    doMsg(req);
  }

  @Override
  protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    doMsg(req);
  }
}
