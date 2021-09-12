package com.pjboy.account_pick.controller.util;

import com.pjboy.account_pick.exception.AjaxResponse;
import com.pjboy.account_pick.exception.CustomExceptionType;
import com.pjboy.account_pick.exception.RrException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;


/**
 * controller 增强器
 */
@Slf4j
@RestControllerAdvice
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

  /**
   * 处理空指针的异常
   *
   * @param req
   * @param e
   * @return
   */
  @ExceptionHandler(value = NullPointerException.class)
  public AjaxResponse exceptionHandler(HttpServletRequest req, NullPointerException e) {
    log.error("发生空指针异常！原因是:", e);
    return AjaxResponse.error(CustomExceptionType.SYSTEM_ERROR, "发生空指针异常！原因是:" + e);
  }

}