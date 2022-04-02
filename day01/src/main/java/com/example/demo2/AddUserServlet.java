package com.example.demo2;

import com.example.demo2.service.UserService;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cnmgb
 * @version 1.0
 * @date 2022/3/31
 **/
@WebServlet(urlPatterns = "/AddUserServlet")
public class AddUserServlet extends HttpServlet {

  private UserService userService = new UserService();
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    String nickname = req.getParameter("nickname");
    String sex = req.getParameter("sex");
    String[] favorites = req.getParameterValues("favorites");
    String grade = req.getParameter("grade");
    String str = Arrays.stream(favorites).map(f -> f + ";").collect(Collectors.joining());
    System.out.println(username+password+nickname+str+grade);
    int i = userService.addUser(username, password, nickname, str, grade,sex);
    if (i > 0) {
      System.out.println("添加成功");
    }else{

      System.out.println("添加失败");
    }

  }
}
