package com.pjboy.account_pick.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.account_pick.mapper.GameMapper;
import com.pjboy.account_pick.mapper.GoodsMapper;
import com.pjboy.account_pick.model.GameDO;
import com.pjboy.account_pick.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

  @Autowired
  private GameMapper gameMapper;

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
  public int addGame(GameDO gameDO) {
    return gameMapper.insert(gameDO);
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
  public int updateGame(GameDO gameDO) {
    return gameMapper.updateById(gameDO);
  }
}
