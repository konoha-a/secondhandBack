package com.example.secondhandWeb.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
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
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "userId", type = IdType.AUTO)
    private Long userId;

    @TableField("userName")
    private String userName;

    @TableField("userPassword")
    private String userPassword;

    @TableField("userEmail")
    private String userEmail;

    @TableField("userSex")
    private Boolean userSex;

    @TableField("userAdder")
    private String userAdder;

    @TableField("userPhone")
    private String userPhone;

    @TableField("userImage")
    private String userImage;

    @TableField("userSchool")
    private String userSchool;

    @TableField("attentCount")
    private Integer attentCount;

    @TableField("fansCount")
    private Integer fansCount;

    @TableField("publishCount")
    private Integer publishCount;


    public void setUserName(String userName) {
        this.userName=userName;
    }
    public void setUserPhone(String userPhone) {
        this.userPhone=userPhone;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail=userEmail;
    }
    public void setUserSex(Boolean userSex) {
        this.userSex=userSex;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword=userPassword;
    }
    public void setUserAdder(String userAdder){this.userAdder=userAdder;}
    public void setUserImage(String userImage){this.userImage=userImage;}
    public void setUserSchool(String userSchool){this.userSchool=userSchool;}
    public void setAttentCount(Integer attentCount){this.attentCount=attentCount;}
    public void setFansCount(Integer fansCount){this.fansCount=fansCount;}
    public void setPublishCount(Integer publishCount){this.publishCount=publishCount;}

    public Long getUserId(){return userId;}
    public String getUserName() {
        return userName;
    }
    public String getUserPhone() {
        return userPhone;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public Boolean getUserSex() {
        return userSex;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public String getUserSchool(){
        return userSchool;
    }
    public String getUserImage(){
        return userImage;
    }
    public String getUserAdder(){
        return userAdder;
    }
    public Integer getAttentCount(){return attentCount;}
    public Integer getFansCount(){return fansCount;}
    public Integer getPublishCount(){return publishCount;}
}
