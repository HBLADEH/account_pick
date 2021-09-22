package com.pjboy.account_pick.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.account_pick.model.ChannelDO;

import java.util.List;

public interface ChannelService {

  List<ChannelDO> listChannels();
  ChannelDO selectChannelByName(String name);
  ChannelDO findChannelById(Integer channelId);
  IPage<ChannelDO> selectChannelsPage(Page<?> page, String name);
  int addChannel(ChannelDO channelDO);
  int deleteChannelById(Integer channelId);
  int deleteChannelByIds(List<Integer> ids);
  int updateChannel(ChannelDO channelDO);
  List<ChannelDO> listChannelByGameId(Integer gameId);
}
