package com.pjboy.account_pick.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@TableName("tb_goods")
public class GoodsDO extends BaseModel implements Serializable {
  private String coverImg; /* 商品封面图 */
  private String name; /* 商品名称 */
  private BigDecimal price; /* 商品价格 */
  private String content; /* 商品内容 */
}
