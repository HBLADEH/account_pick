package com.pjboy.account_pick.model.vo;

import com.pjboy.account_pick.model.BaseModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class AdminVO extends BaseModel implements Serializable {


  /**
   * 用户名，唯一
   */
  private String username;

  /**
   * 用户昵称
   */
  private String nickname;

  /**
   * 用户密码 隐藏
   */
  //private String password;


  ///**
  // * 头像url
  // */
  //private String avatar;
  //
  ///**
  // * 邮箱
  // */
  //private String email;
}
