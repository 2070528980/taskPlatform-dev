package com.example.task.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.task.common.enums.CodeStatus;
import com.example.task.common.msg.MessageResult;
import com.example.task.common.utils.DrmFileUtils;
import com.example.task.common.utils.MD5Utils;
import com.example.task.common.utils.MinioUtil;
import com.example.task.service.ITUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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



    @RequestMapping("/uploadApi")
    public Object uploadApi(
            HttpServletRequest request) throws IOException {

        try {
            StandardMultipartHttpServletRequest mureq = (StandardMultipartHttpServletRequest) request;
            MultipartFile app = mureq.getFile("file");
            if(app == null){
                return MessageResult.error("上传文件为空");
            }
            String objectName = UUID.randomUUID().toString();
            String originalFilename = app.getOriginalFilename(); // 原名称
            String suffix = DrmFileUtils.getSuffix(originalFilename);
            String bucketName = "task";
            objectName = objectName + '.' + suffix;

            // 上传文件
            MinioUtil.uploadFile_InputStream(objectName, app.getInputStream(),
                    app.getSize(), app.getContentType(),bucketName);

            JSONObject result = new JSONObject();
            result.put("code", 0);
            result.put("msg", "success");
            JSONObject data = new JSONObject();
            data.put("src",  bucketName + File.separator + objectName);
            data.put("url",  bucketName + File.separator + objectName);
            data.put("title", originalFilename);
            result.put("data", data);

            return result;
        } catch (Exception e) {
            return MessageResult.error(e.getMessage());
        }
    }



}
