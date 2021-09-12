package com.pjboy.account_pick.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
  boolean uploadImg(String uploadFolder, MultipartFile file, String newFileName);

  boolean saveInfo(MultipartFile file);
}
