package com.pjboy.account_pick.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pjboy.account_pick.model.AdminDO;
import com.pjboy.account_pick.model.vo.AdminVO;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper extends BaseMapper<AdminDO> {
  //AdminVO getVOByName(String username);
}
