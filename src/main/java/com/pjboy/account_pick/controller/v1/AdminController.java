package com.pjboy.account_pick.controller.v1;

import cn.dev33.satoken.stp.StpUtil;
import com.pjboy.account_pick.exception.AjaxResponse;
import com.pjboy.account_pick.exception.CustomExceptionType;
import com.pjboy.account_pick.model.AdminDO;
import com.pjboy.account_pick.model.vo.AdminVO;
import com.pjboy.account_pick.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    AdminVO adminVO = adminService.checkLogin(adminDO.getUsername(), adminDO.getPassword());
    if (adminVO != null) {
      StpUtil.login(adminVO.getId());
      return AjaxResponse.success(adminVO, "登陆成功!");
    }
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, "登陆失败,请检查用户名或者密码!");
  }

  @PostMapping("/admin/doLogout")
  public AjaxResponse logout() {
    StpUtil.logout();
    return AjaxResponse.success();
  }


}
