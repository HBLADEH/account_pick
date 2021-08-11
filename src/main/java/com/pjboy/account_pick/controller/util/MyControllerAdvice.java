package com.pjboy.account_pick.controller.util;

import com.pjboy.account_pick.exception.AjaxResponse;
import com.pjboy.account_pick.exception.CustomExceptionType;
import com.pjboy.account_pick.exception.RrException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * controller 增强器
 */
@ControllerAdvice
public class MyControllerAdvice {
  /**
   * 全局异常捕捉处理
   *
   * @param ex
   * @return
   */
  @ResponseBody
  @ExceptionHandler(value = RrException.class)
  public AjaxResponse errorHandler(RrException ex) {
    return AjaxResponse.error(CustomExceptionType.SYSTEM_ERROR, ex.getMessage());
  }

}