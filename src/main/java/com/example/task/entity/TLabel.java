package com.example.task.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 项目标签
 * </p>
 *
 * @author wto
 * @since 2021-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TLabel对象", description="项目标签")
public class TLabel implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("status")
    private Integer status;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @TableField("createDate")
    private Date createDate;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @TableField("updateDate")
    private Date updateDate;


}
