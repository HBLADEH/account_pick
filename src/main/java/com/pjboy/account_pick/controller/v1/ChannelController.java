package com.pjboy.account_pick.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.account_pick.controller.util.BasicCheck;
import com.pjboy.account_pick.exception.AjaxResponse;
import com.pjboy.account_pick.exception.CustomExceptionType;
import com.pjboy.account_pick.model.ChannelDO;
import com.pjboy.account_pick.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.css.CSSUnknownRule;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ChannelController {
  @Autowired
  private ChannelService channelService;

  @GetMapping("/channels")
  private AjaxResponse listChannels() {
    String ErrorEmpty = "未查询到渠道!";
    List<ChannelDO> channelDOList = channelService.listChannels();
    if (channelDOList != null) return AjaxResponse.success(channelDOList);
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorEmpty);
  }


  @GetMapping("/channels/listAll")
  private AjaxResponse selectChannelsPage(@RequestParam() Integer pageSize,
                                          @RequestParam() Integer currentPage,
                                          @RequestParam(required = false) String name) {
    BasicCheck.checkLogin(); // 检测登录
    String ErrorEmpty = "未查询到渠道!";
    Page<ChannelDO> page = new Page<>(currentPage, pageSize);
    IPage<ChannelDO> channelDOPage = channelService.selectChannelsPage(page, name);
    if (channelDOPage != null) return AjaxResponse.success(channelDOPage);
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorEmpty);
  }

  @GetMapping("/channels/{channelId}")
  private AjaxResponse findChannelById(@PathVariable Integer channelId) {
    String ErrorEmpty = "未查询到渠道!";
    ChannelDO channelDO = channelService.findChannelById(channelId);
    if (channelDO != null) return AjaxResponse.success(channelDO);
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorEmpty);
  }


  @GetMapping("/channelsByGame/{gameId}")
  private AjaxResponse listChannelsByGame(@PathVariable Integer gameId) {
    List<ChannelDO> channelList = channelService.listChannelByGameId(gameId);
    String ErrorSelect = "获取渠道列表失败!";
    if (channelList != null) return AjaxResponse.success(channelList);
    return AjaxResponse.error(CustomExceptionType.SYSTEM_ERROR, ErrorSelect);

  }

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

  @PutMapping("/channels/{channelId}")
  public AjaxResponse updateChannelById(@PathVariable Integer channelId, @RequestBody ChannelDO channelDO) {
    BasicCheck.checkLogin(); // 检测登录
    channelDO.setId(channelId);
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
