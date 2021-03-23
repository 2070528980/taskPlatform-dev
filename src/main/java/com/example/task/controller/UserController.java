package com.example.task.controller;


import com.example.task.common.msg.MessageResult;
import com.example.task.entity.DrmUser;
import com.example.task.service.IDrmUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2018/9/5.
 */
@RestController
@RequestMapping("/api/index/user")
public class UserController {

    @Autowired
    private IDrmUserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);


    /**
     * 获取当前登录用户
     *
     * @return
     */
    @RequestMapping("/info")
    public Object findUser() {
        Subject subject = SecurityUtils.getSubject();
        PrincipalCollection collection = subject.getPrincipals();
        DrmUser user = (DrmUser) collection.iterator().next();
//            System.out.println("获取当前登录用户" + userName);
        return userService.findOneByUserName(user.getPhoneNumber()).toString();

    }



    @RequestMapping("/update")
    public Object update() {

        return MessageResult.success("6666666666");

    }









}
