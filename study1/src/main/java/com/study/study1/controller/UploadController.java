package com.study.study1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
public class UploadController {

    @RequestMapping("uploadOneFile")
    public String upload(MultipartFile file, HttpServletRequest request) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("/") + "/upload";
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }
        String fileName = file.getOriginalFilename();
        File uploadFile = new File(path,fileName);
        file.transferTo(uploadFile);
        return "1";
    }

}
