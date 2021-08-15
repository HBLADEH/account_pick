package com.pjboy.account_pick.service;

import com.pjboy.account_pick.model.AdminDO;
import com.pjboy.account_pick.model.vo.AdminVO;

public interface AdminService {
  AdminDO checkLogin(String username, String password);

  AdminVO getById(Integer id);
}
