package com.example.secondhandWeb.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author testjava
 * @since 2021-04-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Manager对象", description="")
public class Manager implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "managerId", type = IdType.AUTO)
    private Long managerId;

    @TableField("managerName")
    private String managerName;

    @TableField("managerPassword")
    private String managerPassword;

    @TableField("managerSex")
    private Boolean managerSex;

    @TableField("managerEmail")
    private String managerEmail;

    @TableField("managerPhone")
    private String managerPhone;

    @TableField("managerAdder")
    private String managerAdder;

    @TableField("managerImage")
    private String managerImage;


}
