package com.example.qf_edu_javaee.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.example.qf_edu_javaee.MyServlet1;
import java.io.InputStream;
import java.util.Properties;
import javax.sql.DataSource;

/**
 * @author cnmgb
 * @date 2022/3/31
 **/
public class DBUtils {

  private static Properties properties;

  private static DataSource dataSource;

  static {
    InputStream is = MyServlet1.class.getResourceAsStream("/jdbc.properties");
    properties = new Properties();
    try {
      properties.load(is);
      dataSource = DruidDataSourceFactory.createDataSource(properties);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static DataSource getDataSource() {
    return dataSource;
  }
}
