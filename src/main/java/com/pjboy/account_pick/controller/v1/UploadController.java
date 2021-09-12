package com.pjboy.account_pick.controller.v1;

import com.pjboy.account_pick.exception.AjaxResponse;
import com.pjboy.account_pick.exception.CustomExceptionType;
import com.pjboy.account_pick.service.UploadService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/v1")
public class UploadController {

  //@Autowired
  //private UploadService uploadService;

  //@Value("${file.uploadFolder}")
  //private String uploadFolder;

  //@Value("${file.img.imgList}")
  //private String imgList;

  //@PostMapping("/uploadImg")
  //public AjaxResponse uploadImg(@RequestBody MultipartFile file) {
  //
  //  String fileName = file.getOriginalFilename();
  //  if (StringUtils.isBlank(fileName))
  //    return AjaxResponse.error(CustomExceptionType.FILE_IS_NULL, "检测到上传的文件为空，请求失败！");
  //
  //  String extensionName = fileName.substring(fileName.lastIndexOf("."));
  //  if (!imgList.contains(extensionName))
  //    return AjaxResponse.error(CustomExceptionType.FILE_IS_NULL, "检测到上传的文件类型错误，请求失败！");
  //
  //  String newFileName = new Date().getTime() + fileName;
  //  try {
  //    file.transferTo(new File(uploadFolder, newFileName));
  //  } catch (IOException e) {
  //    return AjaxResponse.error(CustomExceptionType.REQUEST_REFUSE, "上传文件失败！");
  //  }
  //
  //  return AjaxResponse.success();
  //}

}
