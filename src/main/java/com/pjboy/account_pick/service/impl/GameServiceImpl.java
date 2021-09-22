package com.pjboy.account_pick.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
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

import java.util.List;

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
  public GameDO findGameById(Integer id) {
    return gameMapper.selectById(id);
  }

  @Override
  public int addGame(GameFrom gameFrom) {
    GameDO gameDO = new GameDO(gameFrom.getId(), gameFrom.getName());
    if (gameMapper.insert(gameDO) > 0) {
      gameFrom.setId(gameDO.getId());
      int count = gameMapper.insertChannelsAndGameId(gameFrom);
      if (count > 0) return count;
      else {
        gameMapper.deleteById(gameDO.getId());
        return -1;
      }
    }
    return -1;
  }

  @Override
  public int deleteGameById(Integer gameId) {
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
      wrapper.eq("gameId", gameFrom.getId());
      gameChannelMapper.delete(wrapper);
      return gameMapper.insertChannelsAndGameId(gameFrom);
    }
    return -1;
  }
}
