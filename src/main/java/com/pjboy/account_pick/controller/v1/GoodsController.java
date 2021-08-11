package com.pjboy.account_pick.controller.v1;

import cn.dev33.satoken.stp.StpUtil;
import com.pjboy.account_pick.controller.util.BasicCheck;
import com.pjboy.account_pick.exception.AjaxResponse;
import com.pjboy.account_pick.exception.CustomExceptionType;
import com.pjboy.account_pick.model.GoodsDO;
import com.pjboy.account_pick.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class GoodsController {
  @Autowired
  private GoodsService goodsService;

  @PostMapping("/goods")
  private AjaxResponse addGoods(@RequestBody GoodsDO goodsDO) {
    BasicCheck.checkLogin(); // 检测登录
    String ErrorAdd = "添加商品失败!";
    String ErrorName = "商品名称已存在!";
    if (goodsService.selectGoodsByName(goodsDO.getName()) != null)
      return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorName);
    if (goodsService.addGoods(goodsDO) > 0) return AjaxResponse.success();
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorAdd);
  }

  @PutMapping("/goods")
  public AjaxResponse updateGoodsById(@RequestBody GoodsDO goodsDO) {
    BasicCheck.checkLogin(); // 检测登录
    String ErrorUpdate = "修改商品失败!";
    if (goodsService.updateGoods(goodsDO) > 0) return AjaxResponse.success();
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorUpdate);
  }


  @DeleteMapping("/goods/{goodsId}")
  public AjaxResponse deleteGoods(@PathVariable Integer goodsId) {
    BasicCheck.checkLogin(); // 检测登录
    String ErrorDelete = "删除商品失败!";
    if (goodsService.deleteGoodsById(goodsId) > 0) return AjaxResponse.success();
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorDelete);
  }

  @DeleteMapping("/goods")
  public AjaxResponse deleteGoodsByIds(@RequestBody List<Integer> ids) {
    BasicCheck.checkLogin(); // 检测登录
    String ErrorDelete = "删除商品失败!";
    if (goodsService.deleteGoodsByIds(ids) > 0) return AjaxResponse.success();
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorDelete);
  }

}
