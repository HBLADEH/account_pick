package com.pjboy.account_pick.controller.v1;

import com.pjboy.account_pick.exception.AjaxResponse;
import com.pjboy.account_pick.exception.CustomExceptionType;
import com.pjboy.account_pick.model.ChannelDO;
import com.pjboy.account_pick.model.GameDO;
import com.pjboy.account_pick.service.ChannelService;
import com.pjboy.account_pick.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/initial")
public class InitialController {


  @Autowired
  private GameService gameService;

  @Autowired
  private ChannelService channelService;

  /**
   * @Description: 获取商品页面的一些输入框数据
   * @Param: []
   * @return: com.pjboy.account_pick.exception.AjaxResponse
   * @Author: BLADE
   * @Date: 2021/8/21
   */
  //@GetMapping("/goods")
  //private AjaxResponse getGoodsInitial() {
  //  List<GameDO> gameList = gameService.listGames();
  //  List<ChannelDO> channelList = channelService.listChannel();
  //  if (!gameList.isEmpty() && !channelList.isEmpty()) {
  //    Map<String, Object> map = new HashMap<>();
  //    map.put("GameList", gameList);
  //    map.put("ChannelList", channelList);
  //    return AjaxResponse.success(map);
  //  }
  //  return AjaxResponse.error(CustomExceptionType.SYSTEM_ERROR, "未完全获取到下拉框数据!");
  //}

}
