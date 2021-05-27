package com.example.secondhandWeb.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.Date;

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
@ApiModel(value = "Goods对象", description = "")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "goodsId", type = IdType.AUTO)
    private Long goodsId;

    @TableField("sellerId")
    private Long sellerId;

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

    @TableField("goodsClass")
    private String goodsClass;

    @TableField("goodsNum")
    private Integer goodsNum;

    @TableField("goodsMessage")
    private String goodsMessage;

    @TableField("goodsFavorite")
    private Integer goodsFavorite;

    @TableField("goodsCar")
    private Double goodsCar;

    @TableField("isSell")
    private Integer isSell;

    @TableField("isDelete")
    private Integer isDelete;

    @TableField("isManage")
    private Integer isManage;

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    public void setGoodsOldNew(String goodsOldNew) {
        this.goodsOldNew = goodsOldNew;
    }
    public void setGoodsIntroduct(String goodsIntroduct) {
        this.goodsIntroduct = goodsIntroduct;
    }
    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
    public void setGoodsClass(String goodsClass) {
        this.goodsClass = goodsClass;
    }
    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }
    public void setGoodsMessage(String goodsMessage) {
        this.goodsMessage = goodsMessage;
    }
    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
    public void setGoodsFavorite(Integer goodsFavorite){
        this.goodsFavorite=goodsFavorite;
    }
    public void setGoodsCar(Double goodsCar){this.goodsCar=goodsCar;}
    public void setIsSell(Integer isSell){this.isSell=isSell;}
    public void setIsDelete(Integer isDelete){this.isDelete=isDelete;}
    public void setIsManage(Integer isManage){this.isManage=isManage;}

    public Long getGoodsId() {
        return goodsId;
    }
    public Long getSellerId(){return sellerId;}
    public String getGoodsName() {
        return goodsName;
    }
    public String getGoodsOldNew() {
        return goodsOldNew;
    }
    public String getGoodsIntroduct() {
        return goodsIntroduct;
    }
    public Double getGoodsPrice() {return goodsPrice;}
    public String getGoodsClass() {
        return goodsClass;
    }
    public Integer getGoodsNum() {
        return goodsNum;
    }
    public String getGoodsMessage() {
        return goodsMessage;
    }
    public Integer getGoodsFavorite(){
        return goodsFavorite;
    }
    public Double getGoodsCar(){return goodsCar;}
    public Integer getIsSell(){return isSell;}
    public Integer getIsDelete(){return isDelete;}
    public String getGoodsImage(){return goodsImage;}
    public Integer getIsManage(){return isManage;}

}
