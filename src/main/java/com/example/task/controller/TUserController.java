package com.example.task.controller;


import com.example.task.entity.TUser;
import com.example.task.service.ITUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author wto
 * @since 2021-03-24
 */
@RestController
@RequestMapping("/api/index/user")
public class TUserController {

    @Autowired
    private ITUserService userService;

    private Logger logger = LoggerFactory.getLogger(TUserController.class);

    /**
     * 获取当前登录用户
     *
     * @return
     */
    @RequestMapping("/info")
    public Object findUser() {
        Subject subject = SecurityUtils.getSubject();
        PrincipalCollection collection = subject.getPrincipals();
        TUser user = (TUser) collection.iterator().next();
//            System.out.println("获取当前登录用户" + userName);
        return userService.findOneByUserName(user.getSloginname()).toString();

    }




}

