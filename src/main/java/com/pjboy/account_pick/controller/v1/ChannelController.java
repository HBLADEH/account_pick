package com.pjboy.account_pick.controller.v1;

import com.pjboy.account_pick.controller.util.BasicCheck;
import com.pjboy.account_pick.exception.AjaxResponse;
import com.pjboy.account_pick.exception.CustomExceptionType;
import com.pjboy.account_pick.model.ChannelDO;
import com.pjboy.account_pick.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ChannelController {
  @Autowired
  private ChannelService channelService;

  @PostMapping("/channels")
  private AjaxResponse addChannel(@RequestBody ChannelDO channelDO) {
    BasicCheck.checkLogin(); // 检测登录
    String ErrorAdd = "添加渠道失败!";
    String ErrorName = "渠道名称已存在!";
    if (channelService.selectChannelByName(channelDO.getName()) != null)
      return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorName);
    if (channelService.addChannel(channelDO) > 0) return AjaxResponse.success();
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorAdd);
  }

  @PutMapping("/channels")
  public AjaxResponse updateChannelById(@RequestBody ChannelDO channelDO) {
    BasicCheck.checkLogin(); // 检测登录
    String ErrorUpdate = "修改渠道失败!";
    if (channelService.updateChannel(channelDO) > 0) return AjaxResponse.success();
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorUpdate);
  }


  @DeleteMapping("/channels/{channelId}")
  public AjaxResponse deleteChannelById(@PathVariable Integer channelId) {
    BasicCheck.checkLogin(); // 检测登录
    String ErrorDelete = "删除渠道失败!";
    if (channelService.deleteChannelById(channelId) > 0) return AjaxResponse.success();
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorDelete);
  }

  @DeleteMapping("/channels")
  public AjaxResponse deleteChannelByIds(@RequestBody List<Integer> ids) {
    BasicCheck.checkLogin(); // 检测登录
    String ErrorDelete = "删除渠道失败!";
    if (channelService.deleteChannelByIds(ids) > 0) return AjaxResponse.success();
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorDelete);
  }
}
