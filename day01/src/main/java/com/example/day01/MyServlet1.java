package com.example.day01;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 四种访问方式的读取和存储方式
 * @author cnmgb
 * @version 1.0
 * @date 2022/3/31
 **/
@WebServlet(urlPatterns = "/MyServlet1")
public class MyServlet1 extends HttpServlet {

  /**
   * 四种格式 x-www-from-urlencoded 是以键值对的方式发送 json格式直接接收json字符串
   */
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
//    字符流
    BufferedReader br = req.getReader();
//    字节流
//    ServletInputStream is = req.getInputStream();
    String line = null;
    while ((line = br.readLine()) != null) {
/**
 *  x-www-from-urlencoded
 *  name=24680&age=18
 *
 *
 *  form-data
 *  ----------------------------731797437188082875584863
 * Content-Disposition: form-data; name="name"
 *
 * oenamd
 * ----------------------------731797437188082875584863
 * Content-Disposition: form-data; name="age"
 *
 * 1010
 * ----------------------------731797437188082875584863--
 *
 *
 * JSON
 * {
 * "name":"xiaoe",
 * "age":20
 * }
 * 二进制
 * ?PNG
  */

      System.out.println(line);
    }
    br.close();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
  }

  @Override
  protected void doPut(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    ObjectMapper objectMapper = new ObjectMapper();
    Book book = objectMapper.readValue(req.getReader(), Book.class);
    System.out.println(book);

  }

  @Override
  protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
  }
}
