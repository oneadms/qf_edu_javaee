package com.example.day02.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author cnmgb
 * @version 1.0
 * @date 2022/4/3
 **/

public class MySessionListener implements ServletContextListener {

  private int count = 0;
//  @Override
//  public void attributeAdded(HttpSessionBindingEvent event) {
//    System.out.println("MySessionListener.attributeAdded");
//    count++;
//    System.out.println("count = " + count);
//    event.getSession().invalidate();
//  }
//
//  @Override
//  public void attributeRemoved(HttpSessionBindingEvent event) {
//    System.out.println("MySessionListener.attributeRemoved");
//  }
//
//  @Override
//  public void attributeReplaced(HttpSessionBindingEvent event) {
//    System.out.println("MySessionListener.attributeReplaced");
//  }


//  @Override
//  public void sessionDestroyed(HttpSessionEvent se) {
//    System.out.println("MySessionListener.sessionDestroyed");
//  }
//
//  @Override
//  public void sessionCreated(HttpSessionEvent se) {
//    System.out.println("MySessionListener.sessionCreated");
//        count++;
//    System.out.println("count = " + count);
//  }


  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("MySessionListener.contextInitialized");
  }


  @Override
  public void contextDestroyed(ServletContextEvent sce) {

  }
}
