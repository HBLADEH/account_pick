package com.pjboy.account_pick.model.from;

import lombok.Data;

import java.io.Serializable;

@Data
public class GameFrom implements Serializable {
  private Integer id;
  private String name;
  private Integer[] channelList;
}
