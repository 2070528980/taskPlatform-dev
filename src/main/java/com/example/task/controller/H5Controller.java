package com.example.task.controller;


import com.example.task.common.msg.MessageResult;
import com.example.task.service.ITTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/api/H5")
public class H5Controller {


    @Autowired
    private ITTaskService taskService;

    private Logger logger = LoggerFactory.getLogger(H5Controller.class);


    @RequestMapping("/taskListAll")
    @ResponseBody
    public Object taskListAll(String keyword) {

        return MessageResult.success(taskService.list());
    }


    @RequestMapping("/taskByID")
    @ResponseBody
    public Object taskByID(Integer id) {

        return MessageResult.success(taskService.getById(id));
    }








}

