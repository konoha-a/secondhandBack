package com.example.secondhandWeb.po.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class messVo {
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

    @TableField("isRead")
    private Integer isRead;

    @TableField("userName")
    private String userName;

    @TableField("userImage")
    private String userImage;

    @TableField("goodsImage")
    private String goodsImage;

}
