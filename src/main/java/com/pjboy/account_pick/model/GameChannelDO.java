package com.pjboy.account_pick.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_game_channel")
public class GameChannelDO {
  private Integer gameId;
  private Integer channelId;
}
