package com.example.day01;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.media.sound.SoftTuning;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import org.jcp.xml.dsig.internal.SignerOutputStream;

/**
 *  jackson的使用
 * @author cnmgb
 * @date 2022/3/31
 **/
public class JsonDemo {
  public static void main(String[] args) throws JsonProcessingException {
    ObjectMapper om = new ObjectMapper();
    Book book = new Book(1, "三国演义", "罗贯中");
//      将一个对象转正JSON字符串 这个对象也可以是集合或者是数组
    String s = om.writeValueAsString(book);
    System.out.println(s);
    ArrayList<Book> books = new ArrayList<>();
    books.add(book);
    books.add(new Book(2, "红楼梦", "曹雪芹"));

    String s1 = om.writeValueAsString(books);
    System.out.println(s1);
    System.out.println("============================");

    List<Book> bookList = om.readValue(s1, new TypeReference<List<Book>>() {
    });
    bookList.forEach(b->{
      System.out.println("book.getName() = " + b.getName());
      System.out.println("book.getAuthor() = " + b.getAuthor());
    });

    Book b01 = om.readValue(s, Book.class);
    System.out.println(b01.toString());

  }

}
