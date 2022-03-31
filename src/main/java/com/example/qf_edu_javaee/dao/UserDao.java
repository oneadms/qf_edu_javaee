package com.example.qf_edu_javaee.dao;

import com.example.qf_edu_javaee.entity.User.User;
import com.example.qf_edu_javaee.util.DBUtils;
import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 * @author cnmgb
 * @date 2022/3/31
 **/
public class UserDao {

  private final QueryRunner queryRunner;

  public UserDao() {
    queryRunner = new QueryRunner(DBUtils.getDataSource());
  }

  public boolean login(String username, String password) {
    try {
      return queryRunner.query("select * from user where username= ? and password= ?;",
          new BeanHandler<>(User.class),username,password) != null;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }
  public User getUserByUsername(String username) {
    try {
      return queryRunner.query("select * from user where username= ?;",
          new BeanHandler<User>(User.class),username);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }
}
