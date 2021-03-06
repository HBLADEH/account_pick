package com.pjboy.account_pick.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.account_pick.model.GoodsDO;
import com.pjboy.account_pick.model.vo.GoodsVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface GoodsService {
  GoodsDO selectGoodsByName(String name);

  int addGoods(GoodsDO goodsDO);

  int deleteGoodsById(Integer goodsId);

  int deleteGoodsByIds(List<Integer> ids);

  int updateGoods(GoodsDO goodsDO);

  /**
   * <p>
   * 查询 : 根据state状态查询商品列表，分页显示
   * </p>
   *
   * @param page            分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
   * @param goodsName       名称
   * @param createTimeStart 创建时间起点
   * @param createTimeEnd   创建时间终点
   * @return 分页对象
   */
  IPage<GoodsVO> selectGoodsPage(Page<?> page, Integer id, String goodsName, Integer gameId, Integer channelId, Date createTimeStart, Date createTimeEnd);

    /**
     * 根据 id 查询对应的商品
     *
     * @param goodsId id
     * @return GoodsVO
     */
  GoodsVO selectGoodsById(Integer goodsId);
}
