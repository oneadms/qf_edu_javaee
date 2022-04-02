package com.example.day02.fitter;


import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletResponseWrapper;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cnmgb
 * @version 1.0
 * @date 2022/4/1
 **/
@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=utf-8");
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;
//    获取当前请求地址
    String requestURI = req.getRequestURI();
    if (requestURI.contains("login")) {
      chain.doFilter(req, res);
    } else {
//      如果有username则表示已经登录
      Object username = req.getSession().getAttribute("username");
      if (username == null) {
//        没有登陆跳转到登录页面
        res.sendRedirect("/day02/login.html");
      }else{

        chain.doFilter(request, response);
      }
    }

  }


  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void destroy() {
  }
}
