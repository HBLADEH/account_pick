package com.pjboy.account_pick.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.account_pick.controller.util.BasicCheck;
import com.pjboy.account_pick.exception.AjaxResponse;
import com.pjboy.account_pick.exception.CustomExceptionType;
import com.pjboy.account_pick.model.GoodsDO;
import com.pjboy.account_pick.model.vo.GoodsVO;
import com.pjboy.account_pick.service.GoodsService;
import com.pjboy.account_pick.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class GoodsController {
  @Autowired
  private GoodsService goodsService;

  @Autowired
  private UploadService uploadService;


  @Value("${file.img.goodsContentImgSource}")
  private String goodsContentImgSource;

  @Value("${file.img.goodsContentImgURL}")
  private String goodsContentImgURL;

  @Value("${file.img.goodsCoverImgSource}")
  private String goodsCoverImgSource;
  @Value("${file.img.goodsCoverImgURL}")
  private String goodsCoverImgURL;


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

  @GetMapping("/goods/listAll")
  public AjaxResponse selectAllByList(@RequestParam() Integer pageSize,
                                      @RequestParam() Integer currentPage,
                                      @RequestParam(required = false) String name,
                                      @RequestParam(required = false)
                                      @DateTimeFormat(pattern = "yyyy-MM-dd") Date createTimeStart,
                                      @RequestParam(required = false)
                                      @DateTimeFormat(pattern = "yyyy-MM-dd") Date createTimeEnd) {
    BasicCheck.checkLogin(); // 检测登录
    String ErrorEmpty = "未查询到商品!";
    Page<GoodsVO> page = new Page<>(currentPage, pageSize);
    IPage<GoodsVO> goodsVOIPage = goodsService.selectGoodsPage(page, name, createTimeStart, createTimeEnd);
    if (goodsVOIPage != null) return AjaxResponse.success(goodsVOIPage);
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorEmpty);
  }

  @GetMapping("/goods/{goodsId}")
  public AjaxResponse selectGoodsById(@PathVariable Integer goodsId) {
    BasicCheck.checkLogin(); // 检测登录
    String ErrorEmpty = "未查询到商品!";
    GoodsVO goodsVO = goodsService.selectGoodsById(goodsId);
    if (goodsVO != null) return AjaxResponse.success(goodsVO);
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorEmpty);
  }

  @PostMapping("/goods/uploadContentImg")
  public AjaxResponse uploadContentImg(@RequestBody MultipartFile file) {
    return doUploadImg(file, goodsContentImgSource, goodsContentImgURL);
  }

  @PostMapping("/goods/uploadCoverImg")
  public AjaxResponse uploadCoverImg(@RequestBody MultipartFile file) {
    return doUploadImg(file, goodsCoverImgSource, goodsCoverImgURL);
  }

  /**
  * @Description: 执行上传文件操作
  * @Param: [file, goodsCoverImgSource, goodsCoverImgURL]
  * @return: com.pjboy.account_pick.exception.AjaxResponse
  * @Author: BLADE
  * @Date: 2021/9/11
  */
  private AjaxResponse doUploadImg(MultipartFile file, String goodsCoverImgSource, String goodsCoverImgURL) {
    String newFileName = new Date().getTime() + file.getOriginalFilename();
    if (uploadService.uploadImg(goodsCoverImgSource, file, newFileName)) {
      Map<String, String> map = new HashMap<>();
      map.put("url", goodsCoverImgURL + newFileName);
      return AjaxResponse.success(map);
    }
    return AjaxResponse.error(CustomExceptionType.REQUEST_REFUSE, "上传文件失败");
  }


}
