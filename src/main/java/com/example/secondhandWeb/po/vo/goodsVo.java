package com.example.secondhandWeb.po.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class goodsVo {
    @TableId(value = "goodsId", type = IdType.AUTO)
    private Long goodsId;

    @TableField("sellerId")
    private Long sellerId;

    @TableField("userId")
    private Long userId;

    @TableField("goodsName")
    private String goodsName;

    @TableField("goodsImage")
    private String goodsImage;

    @TableField("goodsOldNew")
    private String goodsOldNew;

    @TableField("goodsIntroduct")
    private String goodsIntroduct;

    @TableField("goodsPrice")
    private Double goodsPrice;

    @TableField("goodsMessage")
    private String goodsMessage;

    @TableField("goodsFavorite")
    private Integer goodsFavorite;

    @TableField("goodsClass")
    private String goodsClass;

    @TableField("goodsCar")
    private Double goodsCar;

    @TableField("userName")
    private String userName;

    @TableField("userSex")
    private Boolean userSex;

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

    @TableField("isSell")
    private Boolean isSell;
}
