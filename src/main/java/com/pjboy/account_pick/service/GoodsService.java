package com.pjboy.account_pick.service;

import com.pjboy.account_pick.model.GoodsDO;

import java.util.List;

public interface GoodsService {
  GoodsDO selectGoodsByName(String name);

  int addGoods(GoodsDO goodsDO);

  int deleteGoodsById(Integer goodsId);
  int deleteGoodsByIds(List<Integer> ids);

  int updateGoods(GoodsDO goodsDO);

}
