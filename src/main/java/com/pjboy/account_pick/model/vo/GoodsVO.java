package com.pjboy.account_pick.model.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.pjboy.account_pick.model.BaseModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class GoodsVO extends BaseModel implements Serializable {
  private String coverImg; /* 商品封面图 */
  private String name; /* 商品名称 */
  private BigDecimal price; /* 商品价格 */
  private String gameId; /* 游戏ID */
  private String gameName; /* 游戏名称 */
  private String channelId; /* 渠道ID */
  private String channelName; /* 渠道名称 */
  private String content; /* 商品内容 */
}
