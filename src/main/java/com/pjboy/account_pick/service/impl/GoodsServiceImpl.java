package com.pjboy.account_pick.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pjboy.account_pick.mapper.GoodsMapper;
import com.pjboy.account_pick.model.GoodsDO;
import com.pjboy.account_pick.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

  @Autowired
  private GoodsMapper goodsMapper;

  @Override
  public GoodsDO selectGoodsByName(String name) {
    QueryWrapper<GoodsDO> wrapper = new QueryWrapper<>();
    wrapper.eq("name", name);
    return goodsMapper.selectOne(wrapper);
  }

  @Override
  public int addGoods(GoodsDO goodsDO) {
    return goodsMapper.insert(goodsDO);
  }

  @Override
  public int deleteGoodsById(Integer goodsId) {
    return goodsMapper.deleteById(goodsId);
  }

  @Override
  public int deleteGoodsByIds(List<Integer> ids) {
    return goodsMapper.deleteBatchIds(ids);
  }

  @Override
  public int updateGoods(GoodsDO goodsDO) {
    return goodsMapper.updateById(goodsDO);
  }
}
