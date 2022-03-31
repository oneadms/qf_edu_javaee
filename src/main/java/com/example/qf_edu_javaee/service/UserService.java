package com.example.qf_edu_javaee.service;

import com.example.qf_edu_javaee.common.ApiAssert;
import com.example.qf_edu_javaee.common.exception.ApiException;
import com.example.qf_edu_javaee.dao.UserDao;
import com.example.qf_edu_javaee.entity.User.User;

/**
 * @author cnmgb
 * @date 2022/3/31
 **/

public class UserService   {

  private UserDao userDao=new UserDao();
  public boolean login(String username, String password) throws ApiException {
    User user = userDao.getUserByUsername(username);
    if (user == null) {
      ApiAssert.fail("账号不存在");
    }
    return userDao.login(username, password);
  }


}
