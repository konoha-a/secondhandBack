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
 * @since 2021-04-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Attention对象", description="")
public class Attention implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "attentId", type = IdType.AUTO)
    private Long attentId;

    @TableField("userId")
    private Long userId;

    @TableField("beAttentId")
    private Long beAttentId;


    public Long getUserId() {
        return userId;
    }
    public Long getBeAttentId(){
        return beAttentId;
    }
    public Long getAttentId(){
        return attentId;
    }

    public void setUserId(Long userId){
        this.userId=userId;
    }
    public void setBeAttentId(Long beAttentId){
        this.beAttentId=beAttentId;
    }
}
