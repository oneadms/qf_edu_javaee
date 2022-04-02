package com.example.demo2.entity;

/**
 * @author cnmgb
 * @version 1.0
 * @date 2022/3/31
 **/
public class User {

  private String favorites;

  @Override
  public String toString() {
    return "User{" +
        "favorites='" + favorites + '\'' +
        ", sex=" + sex +
        ", id=" + id +
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", nickname='" + nickname + '\'' +
        '}';
  }

  private Integer sex;

  public int getSex() {
    return sex;
  }

  public void setSex(int sex) {
    this.sex = sex;
  }

  public void setFavorites(String favorites) {
    this.favorites = favorites;
  }

  public String getFavorites() {
    return favorites;
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

  public User() {

  }

  public User(Integer id, String username, String password, String nickname) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.nickname = nickname;
  }

  private Integer id;
  private String username;
  private String password;
  private String nickname;

}
