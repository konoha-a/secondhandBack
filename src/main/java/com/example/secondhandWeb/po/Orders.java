package com.example.secondhandWeb.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.DelayQueue;

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
 * @since 2021-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Orders对象", description="")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

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
    private Integer orderState;

    @TableField("orderEvalu")
    private String orderEvalu;

    @TableField("orderCreaT")
    private Date orderCreaT;

    @TableField("orderPayT")
    private Date orderPayT;

    @TableField("orderDelT")
    private Date orderDelT;

    @TableField("orderConfT")
    private Date orderConfT;

    public Long getOrderId() {
        return orderId;
    }
    public Long getGoodsId(){return goodsId;}
    public Long getBuyerId(){return buyerId;}
    public Long getAdderId(){return adderId;}
    public Integer getOrderState() {return orderState;}

    public void setGoodsId(Long goodsId) {
        this.goodsId=goodsId;
    }
    public void setBuyerId(Long buyerId){this.buyerId=buyerId;}
    public void setAdderId(Long adderId){this.adderId=adderId;}
    public void setOrderPrice(Double orderPrice){this.orderPrice=orderPrice;}
    public void setOrderCreaT(Date orderCreaT){this.orderCreaT=orderCreaT;}
    public void setOrderState(Integer orderState){this.orderState=orderState;}
    public void setOrderPayT(Date orderPayT){this.orderPayT=orderPayT;}
    public void setOrderDelT(Date orderDelT){this.orderDelT=orderDelT;}
    public void setOrderConfT(Date orderConfT){this.orderConfT=orderConfT;}


}
