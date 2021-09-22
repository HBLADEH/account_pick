package com.pjboy.account_pick.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.account_pick.model.ChannelDO;
import com.pjboy.account_pick.model.from.GameFrom;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelMapper extends BaseMapper<ChannelDO> {
  List<ChannelDO> listChannelByGameId(@Param("gameId") Integer gameId);
  IPage<ChannelDO> selectChannelsPage(Page<?> page, @Param("name") String name);
}
