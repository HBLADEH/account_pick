package com.pjboy.account_pick.controller.v1;

import cn.dev33.satoken.stp.StpUtil;
import com.pjboy.account_pick.controller.util.BasicCheck;
import com.pjboy.account_pick.exception.AjaxResponse;
import com.pjboy.account_pick.exception.CustomExceptionType;
import com.pjboy.account_pick.model.AdminDO;
import com.pjboy.account_pick.model.vo.AdminVO;
import com.pjboy.account_pick.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 管理员控制器
 * @Author: BLADE
 * @Date: 2021/4/5
 */
@RestController
@RequestMapping("/v1")
public class AdminController {

  @Autowired
  private AdminService adminService;

  @PostMapping("/admin/login")
  public AjaxResponse adminLogin(@RequestBody AdminDO adminDO) {
    AdminDO admin = adminService.checkLogin(adminDO.getUsername(), adminDO.getPassword());
    if (admin != null) {
      StpUtil.login(admin.getId());

      /* 返回 Token */
      Map<String, String> map = new HashMap<>();
      map.put("token",StpUtil.getTokenValue());

      return AjaxResponse.success(map, "登陆成功!");
    }
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, "登陆失败,请检查用户名或者密码!");
  }

  @GetMapping("/admin/info")
  public AjaxResponse adminInfo() {
    BasicCheck.checkLogin(); // 检测登录
    Integer adminId = StpUtil.getLoginIdAsInt();
    AdminVO adminVO = adminService.getById(adminId);
    if (adminVO != null) return AjaxResponse.success(adminVO);
    return AjaxResponse.error(CustomExceptionType.SYSTEM_ERROR, "获取用户信息失败!");
  }

  @PostMapping("/admin/doLogout")
  public AjaxResponse logout() {
    StpUtil.logout();
    return AjaxResponse.success();
  }
}
