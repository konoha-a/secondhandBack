package com.example.secondhandWeb.po.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class favoVo {
    @TableId(value = "favoId", type = IdType.AUTO)
    private Long favoId;

    @TableField("goodsId")
    private Long goodsId;

    @TableField("userId")
    private Long userId;

//    @TableField("isFavo")
//    private Boolean isFavo;

    @TableField("goodsName")
    private String goodsName;

    @TableField("goodsImage")
    private String goodsImage;

    @TableField("goodsPrice")
    private Double goodsPrice;

    @TableField("goodsFavorite")
    private Integer goodsFavorite;

    public void setGoodsFavorite(Integer goodsFavorite){
        this.goodsFavorite=goodsFavorite;
    }

    public Long getGoodsId() {
        return goodsId;
    }
    public Long getUserId() {
        return userId;
    }
    public Integer getGoodsFavorite(){
        return goodsFavorite;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId=goodsId;
    }

    public void setUserId(Long userId) {
        this.userId=userId;
    }

    public String getGoodsName() {
        return goodsName;
    }
}
