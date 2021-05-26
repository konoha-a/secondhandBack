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
 * @since 2021-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Adderss对象", description="")
public class Adderss implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "adderId", type = IdType.AUTO)
    private Long adderId;

    @TableField("userId")
    private Long userId;

    @TableField("recName")
    private String recName;

    @TableField("recPhone")
    private String recPhone;

    @TableField("recAdder")
    private String recAdder;

    public void setUserId(Long userId){this.userId=userId;}
    public void setRecName(String recName){this.recName=recName;}
    public void setRecPhone(String recPhone){this.recPhone=recPhone;}
    public void setRecAdder(String recAdder){this.recAdder=recAdder;}

    public Long getAdderId(){return adderId;}
    public Long getUserId(){return userId;}
    public String getRecName(){return recName;}
    public String getRecPhone(){return recPhone;}
    public String getRecAdder(){return recAdder;}
}
