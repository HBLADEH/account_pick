package com.pjboy.account_pick.service;

import com.pjboy.account_pick.model.AdminDO;
import com.pjboy.account_pick.model.vo.AdminVO;

public interface AdminService {
  AdminVO checkLogin(String username, String password);

  AdminDO getById(Long id);
}
