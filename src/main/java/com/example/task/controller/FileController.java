package com.example.task.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.task.common.enums.CodeStatus;
import com.example.task.common.enums.PathFormat;
import com.example.task.common.msg.MessageResult;
import com.example.task.common.utils.DrmFileUtils;
import com.example.task.common.utils.MD5Utils;
import com.example.task.common.utils.MinioUtil;
import com.example.task.service.ITUserService;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

//@Controller
//@RequestMapping("/api/login")

@RestController
@RequestMapping("/api/index/file")
public class FileController {

    private Logger logger = LoggerFactory.getLogger(FileController.class);

    @Value("${drmPath}")
    private String drmPath;


    @ResponseBody
    @RequestMapping("/uploadApi")
    public Object character_uploadFile(@RequestPart(name = "edit", required = false) MultipartFile file) {


//        System.out.println("------------uploadApi-----------");
        String originalFilename = file.getOriginalFilename(); // 原名称
        String suffix = DrmFileUtils.getSuffix(originalFilename); //获取文件后缀名
        String format = "/images/{yyyy}{mm}{dd}/{time}{rand:6}";
        String fileName = PathFormat.parse(format) + '.' + suffix;
//        上传图片返回地址
        MinioUtil.uploadFile(file, fileName, "task");
//        判断是否图片且大小是否超过1024kb
        if (DrmFileUtils.isImage(DrmFileUtils.MultipartFileToFile(file)) && file.getSize() / 1024 > 1024) {
            try {
                //              压缩图片
//                of("原图文件的路径")
//              scale 1f就是原图长宽，0.5就是原图的一半长宽
//              outputQuality是图片的质量 越接近于1质量越好，越接近于0质量越差。
//                toFile("压缩后文件的路径");
                Thumbnails.of(drmPath + "/task" + fileName).scale(1f).outputQuality(0.25f).toFile(drmPath + "/task" + fileName);
                logger.info("压缩成功");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        JSONObject result = new JSONObject();
        result.put("code", 0);
        result.put("msg", "success");
        JSONObject data = new JSONObject();
        data.put("src", "/task" + fileName);
        data.put("title", "task");
        result.put("data", data);
        return result;
    }



}
