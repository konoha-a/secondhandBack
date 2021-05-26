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
 * @since 2021-04-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Favorite对象", description="")
public class Favorite implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "favoId", type = IdType.AUTO)
    private Long favoId;

    @TableField("goodsId")
    private Long goodsId;

    @TableField("userId")
    private Long userId;

//    @TableField("isFavo")
//    private Boolean isFavo;

    public Long getFavoId() {
        return favoId;
    }
    public Long getUserId() {
        return userId;
    }
    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId=goodsId;
    }

    public void setUserId(Long userId) {
        this.userId=userId;
    }

//    public void setIsFavo(Boolean isFavo) {
//        this.isFavo=isFavo;
//    }
}
