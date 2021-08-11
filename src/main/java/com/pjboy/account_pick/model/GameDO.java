package com.pjboy.account_pick.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@TableName("tb_game")
public class GameDO implements Serializable {
  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  private String name; /* 商品名称 */
}
