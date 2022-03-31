package com.example.qf_edu_javaee.entity.User;

import java.io.Serializable;

/**
 * @author cnmgb
 * @date 2022/3/31
 **/
public class User  implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String nickname;

  public User() {

  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }
}
