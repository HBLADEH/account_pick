package com.pjboy.account_pick.service.impl;

import com.pjboy.account_pick.exception.AjaxResponse;
import com.pjboy.account_pick.exception.CustomExceptionType;
import com.pjboy.account_pick.exception.RrException;
import com.pjboy.account_pick.service.UploadService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class UploadServiceImpl implements UploadService {

  @Value("${file.img.imgList}")
  private List<String> list;

  @Override
  public boolean uploadImg(String uploadFolder, MultipartFile file, String newFileName) {
    String fileName = file.getOriginalFilename();
    if (StringUtils.isBlank(fileName))
      throw new RrException(CustomExceptionType.FILE_IS_NULL, "检测到上传的文件为空，请求失败！");

    String extensionName = fileName.substring(fileName.lastIndexOf("."));
    if (!list.contains(extensionName))
      throw new RrException(CustomExceptionType.FILE_IS_NULL, "检测到上传的文件类型错误，请求失败！");

    try {
      file.transferTo(new File(uploadFolder, newFileName));
    } catch (IOException e) {
      throw new RrException(CustomExceptionType.REQUEST_REFUSE, "上传文件失败！");
    }
    return true;
  }

  @Override
  public boolean saveInfo(MultipartFile file) {
    //String fileName = file.getOriginalFilename();
    //if (StringUtils.isBlank(fileName)) {
    //}
    //if (fileName != null && !"".equals(fileName)) {
    //  String prefix = fileName.substring(fileName.lastIndexOf(".") + 1).toUpperCase();
    //  String reString =
    //}
    return false;
  }
}
