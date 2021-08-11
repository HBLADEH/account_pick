package com.pjboy.account_pick.controller.v1;

import com.pjboy.account_pick.controller.util.BasicCheck;
import com.pjboy.account_pick.exception.AjaxResponse;
import com.pjboy.account_pick.exception.CustomExceptionType;
import com.pjboy.account_pick.model.GameDO;
import com.pjboy.account_pick.model.GoodsDO;
import com.pjboy.account_pick.service.GameService;
import com.pjboy.account_pick.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class GameController {
  @Autowired
  private GameService gameService;

  @PostMapping("/games")
  private AjaxResponse addGame(@RequestBody GameDO gameDO) {
    BasicCheck.checkLogin(); // 检测登录
    String ErrorAdd = "添加游戏失败!";
    String ErrorName = "游戏名称已存在!";
    if (gameService.selectGameByName(gameDO.getName()) != null)
      return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorName);
    if (gameService.addGame(gameDO) > 0) return AjaxResponse.success();
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorAdd);
  }

  @PutMapping("/games")
  public AjaxResponse updateGameById(@RequestBody GameDO gameDO) {
    BasicCheck.checkLogin(); // 检测登录
    String ErrorUpdate = "修改游戏失败!";
    if (gameService.updateGame(gameDO) > 0) return AjaxResponse.success();
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorUpdate);
  }


  @DeleteMapping("/games/{gameId}")
  public AjaxResponse deleteGameById(@PathVariable Integer gameId) {
    BasicCheck.checkLogin(); // 检测登录
    String ErrorDelete = "删除游戏失败!";
    if (gameService.deleteGameById(gameId) > 0) return AjaxResponse.success();
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorDelete);
  }

  @DeleteMapping("/games")
  public AjaxResponse deleteGameByIds(@RequestBody List<Integer> ids) {
    BasicCheck.checkLogin(); // 检测登录
    String ErrorDelete = "删除游戏失败!";
    if (gameService.deleteGameByIds(ids) > 0) return AjaxResponse.success();
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorDelete);
  }
}
