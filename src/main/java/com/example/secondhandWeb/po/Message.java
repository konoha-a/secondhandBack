package com.example.secondhandWeb.po;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
 * @since 2021-05-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Message对象", description="")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "messageId", type = IdType.AUTO)
    private Long messageId;

    @TableField("userId")
    private Long userId;

    @TableField("ortherId")
    private Long ortherId;

    @TableField("senderId")
    private Long senderId;

    @TableField("recerId")
    private Long recerId;

    @TableField("goodsId")
    private Long goodsId;

    @TableField("meContent")
    private String meContent;

    @TableField("sendT")
    private Date sendT;

    @TableField("isShow")
    private Integer isShow;

    @TableField("isSender")
    private Integer isSender;

    @TableField("isRead")
    private Integer isRead;

    public void setGoodsId(Long goodsId) {
        this.goodsId=goodsId;
    }
    public void setUserId(Long userId){this.userId=userId;}
    public void setOrtherId(Long ortherId){this.ortherId=ortherId;}
    public void setIsShow(Integer isShow){this.isShow=isShow;}
    public void setIsSender(Integer isSender){this.isSender=isSender;}
    public void setMeContent(String meContent) {
        this.meContent=meContent;
    }
    public void setSendT(Date sendT){this.sendT=sendT;}
    public void setSenderId(Long senderId){this.senderId=senderId;}
    public void setRecerId(Long recerId){this.recerId=recerId;}
    public void setIsRead(Integer isRead){this.isRead=isRead;}

    public int getIsShow() {
        return isShow;
    }


}
