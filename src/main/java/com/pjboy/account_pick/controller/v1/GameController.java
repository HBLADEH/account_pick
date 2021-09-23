package com.pjboy.account_pick.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.account_pick.controller.util.BasicCheck;
import com.pjboy.account_pick.exception.AjaxResponse;
import com.pjboy.account_pick.exception.CustomExceptionType;
import com.pjboy.account_pick.model.GameDO;
import com.pjboy.account_pick.model.GoodsDO;
import com.pjboy.account_pick.model.from.GameFrom;
import com.pjboy.account_pick.model.vo.GoodsVO;
import com.pjboy.account_pick.service.GameService;
import com.pjboy.account_pick.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class GameController {
  @Autowired
  private GameService gameService;

  @GetMapping("/games")
  private AjaxResponse listGames() {
    List<GameDO> gameList = gameService.listGames();
    String ErrorSelect = "获取游戏列表失败!";
    if (gameList != null) return AjaxResponse.success(gameList);
    return AjaxResponse.error(CustomExceptionType.SYSTEM_ERROR, ErrorSelect);
  }

  @GetMapping("/games/listAll")
  public AjaxResponse selectGamesPage(@RequestParam() Integer pageSize,
                                      @RequestParam() Integer currentPage,
                                      @RequestParam(required = false) String name
  ) {
    BasicCheck.checkLogin(); // 检测登录
    String ErrorEmpty = "未查询到游戏!";
    Page<GameDO> page = new Page<>(currentPage, pageSize);
    IPage<GameDO> gameDOIPage = gameService.selectGamesPage(page, name);
    if (gameDOIPage != null) return AjaxResponse.success(gameDOIPage);
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorEmpty);
  }

  @GetMapping("/games/{gameId}")
  private AjaxResponse findGameById(@PathVariable Integer gameId) {
    BasicCheck.checkLogin(); // 检测登录
    String ErrorEmpty = "未查询到游戏!";
    GameFrom gameFrom = gameService.findGameFromById(gameId);
    if (gameFrom != null) return AjaxResponse.success(gameFrom);
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorEmpty);
  }

  @PostMapping("/games")
  private AjaxResponse addGame(@RequestBody GameFrom gameFrom) {
    BasicCheck.checkLogin(); // 检测登录
    String ErrorAdd = "添加游戏失败!";
    String ErrorName = "游戏名称已存在!";
    if (gameService.selectGameByName(gameFrom.getName()) != null)
      return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorName);
    if (gameService.addGame(gameFrom) > 0) return AjaxResponse.success();
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorAdd);
  }

  @PutMapping("/games/{gamesId}")
  public AjaxResponse updateGameById(@PathVariable Integer gamesId, @RequestBody GameFrom gameFrom) {
    gameFrom.setId(gamesId);
    BasicCheck.checkLogin(); // 检测登录
    String ErrorUpdate = "修改游戏失败!";
    if (gameService.updateGame(gameFrom) > 0) return AjaxResponse.success();
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
