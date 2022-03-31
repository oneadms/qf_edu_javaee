package com.example.qf_edu_javaee.common;

import com.example.qf_edu_javaee.common.exception.ApiException;

/**
 * @author cnmgb
 * @date 2022/3/31
 **/
public class ApiAssert {

  public static void fail(String msg) throws ApiException {
    throw new ApiException(msg);
  }

}
