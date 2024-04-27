package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class FileCtrl {
    @ResponseBody
    @PostMapping("/uploadFile")
    public String uploadFile(MultipartFile file){
        String fileName= file.getOriginalFilename();
        System.out.println(fileName);
        fileName = UUID.randomUUID()+"_"+fileName;
        System.out.println(fileName);

        File path = null;
        try {
            // 保存至项目中
//            File savePos = new File("src/main/resources/static/local/image/goods/");
//            if(!savePos.exists()){  // 不存在，则创建该文件夹
//                savePos.mkdir();
//            }
//            String realPath = savePos.getCanonicalPath();
//
//            file.transferTo(new File(realPath+"/"+fileName));

            // 保存至target目录下
            path = new File(ResourceUtils.getURL("classpath:").getPath());
            File uploadpath = new File(path.getAbsolutePath(),"static/local/image/goods/");

            File f = new File(uploadpath,fileName);
            file.transferTo(f);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
