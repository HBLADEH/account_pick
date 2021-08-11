package com.pjboy.account_pick.service;


import com.pjboy.account_pick.model.ChannelDO;

import java.util.List;

public interface ChannelService {
  ChannelDO selectChannelByName(String name);
  int addChannel(ChannelDO channelDO);
  int deleteChannelById(Integer channelId);
  int deleteChannelByIds(List<Integer> ids);
  int updateChannel(ChannelDO channelDO);
}
