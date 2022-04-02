package com.example.demo2.service;

import com.example.demo2.dao.UserDao;
import com.example.demo2.entity.User;
import java.util.List;

/**
 * @author cnmgb
 * @version 1.0
 * @date 2022/3/31
 **/
public class UserService {
  private UserDao userDao = new UserDao();

  public int login(String username, String password) {
    User user = userDao.getUserByUsername(username);
    if (user == null) {
      return -1;
    } else {
      if (user.getPassword().equals(password)) {
        return 1;
      } else {
        return -1;
      }
    }
  }

  public List<User> getAllUser() {
    return userDao.getAllUser();
  }

  public int addUser( String username, String password, String nickname,
      String str, String grade,String sex) {
    return userDao.addUser(username, password, nickname, str, grade,sex);
  }
}
