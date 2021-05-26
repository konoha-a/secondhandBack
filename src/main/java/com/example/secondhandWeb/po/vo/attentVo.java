package com.example.secondhandWeb.po.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class attentVo {

    @TableId(value = "attentId", type = IdType.AUTO)
    private Long attentId;

    @TableField("userId")
    private Long userId;

    @TableField("beAttentId")
    private Long beAttentId;

    @TableField("userName")
    private String userName;

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

    public Long getAttentId(){
        return attentId;
    }
}
