package com.mvc.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("file")
public class Controller_file {
    /**
     * 文件上传
     */
    @RequestMapping("upload")
    public String upload(MultipartFile file) {
        if (file.getSize() > 0) {
            String path = "D:/Upload";
            File f = new File(path);
            if (!f.exists()) {
                f.mkdir();
            }
            //获取上传的文件名称
            String oldName = file.getOriginalFilename();
            f = new File(path + "\\" + oldName);
            try {
                file.transferTo(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "success";
        } else {
            return "error";
        }
    }

    /**
     * 文件下载
     */
    @RequestMapping("download")
    public ResponseEntity<byte[]> download(String fileName, String filePath) throws IOException {
        HttpHeaders httpHeaders = new HttpHeaders();
        //指定文件打开方式，下载方式
        httpHeaders.setContentDispositionFormData("attachment", fileName);
        //指定响应文件数据类型，流数据
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        File file = new File(filePath);
        //把文件转为字节数组
        byte[] bytes = FileUtils.readFileToByteArray(file);
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }
}
