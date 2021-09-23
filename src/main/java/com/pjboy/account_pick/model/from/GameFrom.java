package com.pjboy.account_pick.model.from;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameFrom implements Serializable {
  private Integer id;
  private String name;
  private Integer[] channelList;
}
