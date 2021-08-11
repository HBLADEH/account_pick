package com.pjboy.account_pick.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("tb_channel")
public class ChannelDO implements Serializable {
  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  private String name; /* 渠道名称 */
}
