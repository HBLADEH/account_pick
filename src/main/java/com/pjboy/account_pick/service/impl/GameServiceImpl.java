package com.pjboy.account_pick.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.account_pick.mapper.GameChannelMapper;
import com.pjboy.account_pick.mapper.GameMapper;
import com.pjboy.account_pick.mapper.GoodsMapper;
import com.pjboy.account_pick.model.GameChannelDO;
import com.pjboy.account_pick.model.GameDO;
import com.pjboy.account_pick.model.from.GameFrom;
import com.pjboy.account_pick.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

  @Autowired
  private GameMapper gameMapper;

  @Autowired
  private GameChannelMapper gameChannelMapper;

  @Override
  public List<GameDO> listGames() {
    return gameMapper.selectList(null);
  }

  @Override
  public IPage<GameDO> selectGamesPage(Page<?> page, String name) {
    return gameMapper.selectGamesPage(page, name);
  }

  @Override
  public GameDO selectGameByName(String name) {
    QueryWrapper<GameDO> wrapper = new QueryWrapper<>();
    wrapper.eq("name", name);
    return gameMapper.selectOne(wrapper);
  }

  @Override
  public GameFrom findGameFromById(Integer id) {
    GameDO gameDO = gameMapper.selectById(id);
    if (gameDO == null) return null;
    Integer[] channels = selectChannelsByGameId(id).toArray(new Integer[0]);
    return new GameFrom(gameDO.getId(), gameDO.getName(), channels);
  }

  /**
   * @Description: 获取渠道列表
   * @Param: [gameId]
   * @return: java.util.List<java.lang.Integer>
   * @Author: BLADE
   * @Date: 2021/9/23
   */
  private List<Integer> selectChannelsByGameId(Integer gameId) {
    QueryWrapper<GameChannelDO> wrapper = new QueryWrapper<>();
    wrapper.eq("game_id", gameId);
    return gameChannelMapper.selectList(wrapper).stream().map(GameChannelDO::getChannelId).collect(Collectors.toList());
  }

  @Override
  public int addGame(GameFrom gameFrom) {
    GameDO gameDO = new GameDO(gameFrom.getId(), gameFrom.getName());
    int gameCount = gameMapper.insert(gameDO);
    if (gameCount > 0) {
      if (gameFrom.getChannelList().length > 0){
        gameFrom.setId(gameDO.getId());
        int count = gameMapper.insertChannelsAndGameId(gameFrom);
        if (count > 0) return count;
        else {
          gameMapper.deleteById(gameDO.getId());
          return -1;
        }
      }
      return gameCount;
    }
    return -1;
  }

  @Override
  public int deleteGameById(Integer gameId) {
    QueryWrapper<GameChannelDO> wrapper = new QueryWrapper<>();
    wrapper.eq("game_id", gameId);
    gameChannelMapper.delete(wrapper); // 顺便清理下关联表
    return gameMapper.deleteById(gameId);
  }

  @Override
  public int deleteGameByIds(List<Integer> ids) {
    return gameMapper.deleteBatchIds(ids);
  }

  @Override
  public int updateGame(GameFrom gameFrom) {
    GameDO gameDO = new GameDO(gameFrom.getId(), gameFrom.getName());
    if (gameMapper.updateById(gameDO) > 0) {
      QueryWrapper<GameChannelDO> wrapper = new QueryWrapper<>();
      wrapper.eq("game_id", gameFrom.getId());
      gameChannelMapper.delete(wrapper);
      return gameMapper.insertChannelsAndGameId(gameFrom);
    }
    return -1;
  }
}
