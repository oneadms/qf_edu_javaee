package com.example.demo2.dao;

import com.example.demo2.entity.User;
import com.example.demo2.util.DBUtils;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 * @author cnmgb
 * @version 1.0
 * @date 2022/3/31
 **/
public class UserDao {

  private QueryRunner queryRunner = new QueryRunner(DBUtils.getDS());
  public User getUserByUsername(String username) {
    User user = null;
    try {
      user = queryRunner.query("select * from user where username= ?;",
          new BeanHandler<>(User.class),username);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return user;
  }

  public List<User> getAllUser() {
    try {
      return queryRunner.query("select * from user;", new BeanListHandler<User>(User.class));
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public int addUser(String username, String password, String nickname, String str,
      String grade,String sex) {
    try {
      return queryRunner.update(
          "insert into user (username, password, nickname, favorites, grade,sex) values (?,?,?,?,?,?);",
          username, password, nickname, str, grade,sex);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return -1;
  }
}
