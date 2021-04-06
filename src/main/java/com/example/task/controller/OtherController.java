package com.example.task.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.task.common.msg.MessageResult;
import com.example.task.common.utils.DateUtil;
import com.example.task.entity.TTask;
import com.example.task.service.ITTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
@RequestMapping("/api/other")
public class OtherController {


    @Autowired
    private ITTaskService taskService;

    private Logger logger = LoggerFactory.getLogger(OtherController.class);


    @RequestMapping("/taskListAll")
    @ResponseBody
    public Object taskListAll(String keyword) {

        return MessageResult.success(taskService.list());
    }








}

