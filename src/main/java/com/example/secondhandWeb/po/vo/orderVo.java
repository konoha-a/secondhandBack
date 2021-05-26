package com.example.secondhandWeb.po.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class orderVo {
    @TableId(value = "orderId", type = IdType.AUTO)
    private Long orderId;

    @TableField("goodsId")
    private Long goodsId;

    @TableField("buyerId")
    private Long buyerId;

    @TableField("adderId")
    private Long adderId;

    @TableField("orderPrice")
    private Double orderPrice;

    @TableField("orderState")
    private String orderState;

    @TableField("orderCreaT")
    private Date orderCreaT;

    @TableField("orderPayT")
    private Date orderPayT;

    @TableField("orderDelT")
    private Date orderDelT;

    @TableField("orderConfT")
    private Date orderConfT;

    @TableField("goodsImage")
    private String goodsImage;

    @TableField("sellerId")
    private Long sellerId;

    @TableField("goodsName")
    private String goodsName;

    @TableField("goodsPrice")
    private Double goodsPrice;

    @TableField("goodsCar")
    private Double goodsCar;

    @TableField("goodsIntroduct")
    private String goodsIntroduct;

    @TableField("userName")
    private String userName;

    @TableField("userImage")
    private String userImage;

    @TableField("recName")
    private String recName;

    @TableField("recPhone")
    private String recPhone;

    @TableField("recAdder")
    private String recAdder;

    public Long getOrderId() {
        return orderId;
    }
}
