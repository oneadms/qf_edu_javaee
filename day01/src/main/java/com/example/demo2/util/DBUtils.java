package com.example.demo2.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.sql.DataSource;

/**
 * @author cnmgb
 * @version 1.0
 * @date 2022/3/31
 **/
public class DBUtils {

  private static Properties properties;

  private static DataSource dataSource;

  static {
    InputStream is = DBUtils.class.getResourceAsStream("/jdbc.properties");
    properties = new Properties();
    try {
      properties.load(is);
      dataSource = DruidDataSourceFactory.createDataSource(properties);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static DataSource getDS() {
    return dataSource;
  }
}
