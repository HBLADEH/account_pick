package com.pjboy.account_pick.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.account_pick.mapper.ChannelMapper;
import com.pjboy.account_pick.mapper.GameChannelMapper;
import com.pjboy.account_pick.model.ChannelDO;
import com.pjboy.account_pick.model.GameChannelDO;
import com.pjboy.account_pick.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ChannelServiceImpl implements ChannelService {

  @Autowired
  private ChannelMapper channelMapper;

  @Autowired
  private GameChannelMapper gameChannelMapper;

  @Override
  public List<ChannelDO> listChannels() {
    return channelMapper.selectList(null);
  }

  @Override
  public ChannelDO selectChannelByName(String name) {
    QueryWrapper<ChannelDO> wrapper = new QueryWrapper<>();
    wrapper.eq("name", name);
    return channelMapper.selectOne(wrapper);
  }

  @Override
  public ChannelDO findChannelById(Integer channelId) {
    return channelMapper.selectById(channelId);
  }

  @Override
  public IPage<ChannelDO> selectChannelsPage(Page<?> page, String name) {
    return channelMapper.selectChannelsPage(page, name);
  }

  @Override
  public int addChannel(ChannelDO channelDO) {
    return channelMapper.insert(channelDO);
  }

  @Override
  public int deleteChannelById(Integer channelId) {
    QueryWrapper<GameChannelDO> wrapper = new QueryWrapper<>();
    wrapper.eq("channel_id", channelId);
    gameChannelMapper.delete(wrapper); // 顺便清理下关联表
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

  @Override
  public List<ChannelDO> listChannelByGameId(Integer gameId) {

    return channelMapper.listChannelByGameId(gameId);
  }
}
