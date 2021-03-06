package com.pjboy.account_pick.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.account_pick.model.GoodsDO;
import com.pjboy.account_pick.model.vo.GoodsVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsMapper extends BaseMapper<GoodsDO> {
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
  IPage<GoodsVO> selectGoodsPage(Page<?> page,
                                 @Param("id") Integer id,
                                 @Param("goodsName") String goodsName,
                                 @Param("gameId") Integer gameId,
                                 @Param("channelId") Integer channelId,
                                 @Param("createTimeStart") String createTimeStart,
                                 @Param("createTimeEnd") String createTimeEnd);

  GoodsVO selectGoodsById(@Param("goodsId") Integer goodsId);
}
