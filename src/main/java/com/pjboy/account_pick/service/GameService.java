package com.pjboy.account_pick.service;

import com.pjboy.account_pick.model.GameDO;
import com.pjboy.account_pick.model.GoodsDO;

import java.util.List;

public interface GameService {
  GameDO selectGameByName(String name);
  int addGame(GameDO gameDO);
  int deleteGameById(Integer gameId);
  int deleteGameByIds(List<Integer> ids);
  int updateGame(GameDO gameDO);
}
