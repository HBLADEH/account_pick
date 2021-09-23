package com.pjboy.account_pick.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.account_pick.model.GameDO;
import com.pjboy.account_pick.model.GoodsDO;
import com.pjboy.account_pick.model.from.GameFrom;

import java.util.List;

public interface GameService {

  List<GameDO> listGames();
  IPage<GameDO> selectGamesPage(Page<?> page, String name);
  GameDO selectGameByName(String name);
  GameFrom findGameFromById(Integer id);
  int addGame(GameFrom gameFrom);
  int deleteGameById(Integer gameId);
  int deleteGameByIds(List<Integer> ids);
  int updateGame(GameFrom gameFrom);
}
