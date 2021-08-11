package com.pjboy.account_pick.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pjboy.account_pick.mapper.ChannelMapper;
import com.pjboy.account_pick.model.ChannelDO;
import com.pjboy.account_pick.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ChannelServiceImpl implements ChannelService {

  @Autowired
  private ChannelMapper channelMapper;

  @Override
  public ChannelDO selectChannelByName(String name) {
    QueryWrapper<ChannelDO> wrapper = new QueryWrapper<>();
    wrapper.eq("name", name);
    return channelMapper.selectOne(wrapper);
  }

  @Override
  public int addChannel(ChannelDO channelDO) {
    return channelMapper.insert(channelDO);
  }

  @Override
  public int deleteChannelById(Integer channelId) {
    return channelMapper.deleteById(channelId);
  }

  @Override
  public int deleteChannelByIds(List<Integer> ids) {
    return channelMapper.deleteBatchIds(ids);
  }

  @Override
  public int updateChannel(ChannelDO channelDO) {
    return channelMapper.updateById(channelDO);
  }
}
