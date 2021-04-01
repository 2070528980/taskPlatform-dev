package com.example.task.controller;


import com.alibaba.fastjson.JSON;
import com.example.task.common.msg.MessageResult;
import com.example.task.common.utils.DateUtil;
import com.example.task.common.utils.JsonUtil;
import com.example.task.entity.TTask;
import com.example.task.entity.TUser;
import com.example.task.service.ITTaskService;
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
 *  前端控制器
 * </p>
 *
 * @author wto
 * @since 2021-03-31
 */
@RestController
@RequestMapping("/api/index/task")
public class TTaskController {


    @Autowired
    private ITTaskService taskService;

    private Logger logger = LoggerFactory.getLogger(TTaskController.class);

    @RequestMapping("/save")
    public Object save(String jsonStr) {

        System.out.println("-----------save--------------");
        TTask tTask = JSON.toJavaObject(JSON.parseObject(jsonStr),TTask.class);
        tTask.setProjectState(1);
        tTask.setCreateDate(DateUtil.getSNDate());
        tTask.setUpdateDate(DateUtil.getSNDate());

        System.out.println(tTask);

        return  MessageResult.error();

//        return MessageResult.success(taskService.save(tTask));

    }

    @RequestMapping("/")
    public Object test() {
        return  MessageResult.success();

//        return MessageResult.success(taskService.save(tTask));

    }






}

