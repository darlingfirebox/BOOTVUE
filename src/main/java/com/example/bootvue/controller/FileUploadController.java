package com.example.bootvue.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
public class FileUploadController {

    @PostMapping(value = "/upload")
    public String up_suc(String nickname, MultipartFile photo, HttpServletRequest request) throws IOException {
        System.out.println("nickname:" + nickname);
        System.out.println(photo.getOriginalFilename());
        System.out.println(photo.getContentType());
        String path = request.getServletContext().getRealPath("/upload/");
        System.out.println(path);

        saveFile(photo,path);
        return "上传成功！";
    }

    public void saveFile(MultipartFile photo, String path) throws IOException {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }
        File file = new File(path+photo.getOriginalFilename());
        photo.transferTo(file);
    }
}
