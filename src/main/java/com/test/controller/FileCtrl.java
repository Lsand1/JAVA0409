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
    // 假设配置的文件上传路径
    private static final String UPLOAD_DIR = "/path/to/upload/directory";

    @ResponseBody
    @PostMapping("/uploadFile")
    public String uploadFile(MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                // 获取原始文件名
                String fileName = file.getOriginalFilename();
                // 使用UUID生成新的文件名
                String newFileName = UUID.randomUUID() + "_" + fileName;

                // 构建上传路径
                File uploadDir = new File(UPLOAD_DIR);
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs(); // 创建目录
                }

                // 构建完整的文件路径
                File uploadedFile = new File(uploadDir, newFileName);

                // 保存文件
                file.transferTo(uploadedFile);

                // 检查transferTo是否成功执行
                if (uploadedFile.exists()) {
                    return "File uploaded successfully: " + newFileName;
                } else {
                    return "File upload failed.";
                }
            } catch (Exception e) {
                // 记录异常信息
                System.err.println("Error occurred during file upload: " + e.getMessage());
                return "Error occurred during file upload.";
            }
        } else {
            return "Please select a file to upload.";
        }
    }
}