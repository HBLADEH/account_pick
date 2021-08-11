package com.pjboy.account_pick;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pjboy.account_pick.mapper")
public class AccountPickApplication {
  public static void main(String[] args) {
    SpringApplication.run(AccountPickApplication.class, args);
  }
}
