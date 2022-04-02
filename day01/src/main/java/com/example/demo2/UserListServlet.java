package com.example.demo2;

import com.example.demo2.entity.User;
import com.example.demo2.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(urlPatterns = "/userList")
public class UserListServlet extends HttpServlet {

  private UserService userService=new UserService();
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html;charset=utf8");
    PrintWriter writer = resp.getWriter();
    List<User> userList = userService.getAllUser();
    writer.write("<table border=\"1\">");
    writer.write("<tr>");
    writer.write("<td>");
    writer.write("用户编号");
    writer.write("</td>");
    writer.write("<td>");
    writer.write("用户名");
    writer.write("</td>");
    writer.write("<td>");
    writer.write("昵称");
    writer.write("</td>");
    writer.write("</tr>");

    for (User user : userList) {
      writer.write("<tr>");
      writer.write("<td>");
      writer.write(user.getId()+"");
      writer.write("</td>");
      writer.write("<td>");
      writer.write(user.getUsername());
      writer.write("</td>");
      writer.write("<td>");
      writer.write(user.getNickname());
      writer.write("</td>");
      writer.write("</tr>");
    }
    writer.write("</table>");
    writer.close();
  }
}
