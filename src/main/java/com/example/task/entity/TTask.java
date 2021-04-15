package com.example.task.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author wto
 * @since 2021-03-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TTask对象", description="")
public class TTask implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "项目名称")
    @TableField("projectName")
    private String projectName;

    @ApiModelProperty(value = "项目简介")
    @TableField("projectIntroduce")
    private String projectIntroduce;

    @ApiModelProperty(value = "项目标签")
    @TableField("projectLabel")
    private String projectLabel;

    @ApiModelProperty(value = "金额")
    @TableField("amount")
    private String amount;

    @ApiModelProperty(value = "项目步骤")
    @TableField("ueditorContent")
    private String ueditorContent;

    @ApiModelProperty(value = "项目状态")
    @TableField("projectState")
    private Integer projectState;

    @ApiModelProperty(value = "推荐指数")
    @TableField("recommendedIndex")
    private Integer recommendedIndex;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @TableField("createDate")
    private Date createDate;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @TableField("updateDate")
    private Date updateDate;


}
