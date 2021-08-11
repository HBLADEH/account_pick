package com.pjboy.account_pick.controller.util;

import cn.dev33.satoken.stp.StpUtil;
import com.pjboy.account_pick.exception.RrException;

public class BasicCheck {

  public static void checkLogin() {
    String errorLogin = "未检测到用户登陆，请先登陆!";
    if (!StpUtil.isLogin()) throw new RrException(errorLogin);
  }

  public static void checkRole(String role) {
    checkLogin();
    String errorAuthority = "权限不足!";
    if (!StpUtil.hasRole(role)) throw new RrException(errorAuthority);
  }
}
