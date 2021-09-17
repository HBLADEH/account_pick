package com.pjboy.account_pick.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.account_pick.model.GameDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GameMapper extends BaseMapper<GameDO> {

  /**
  * @Description: 分页查询游戏列表
  * @Param: [page, name]
  * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.pjboy.account_pick.model.GameDO>
  * @Author: BLADE
  * @Date: 2021/9/17
  */
  IPage<GameDO> selectGamesPage(Page<?> page,
                                @Param("name") String name);
}
