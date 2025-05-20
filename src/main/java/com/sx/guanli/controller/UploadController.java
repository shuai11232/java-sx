package com.sx.guanli.controller;

import com.sx.guanli.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.sx.guanli.common.CosUtil;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/upload")
public class UploadController {
    @PostMapping()
    public Result<String> upload(MultipartFile file)throws IOException {
        //保证文件名字唯一
        String filename= UUID.randomUUID()+"predelete"+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        CosUtil.upload(file.getInputStream(),filename);
        String URL="https://bucket.pyzjxpro.cn/"+filename;
        return Result.success(URL);
    }
}
