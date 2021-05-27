package com.example.secondhandWeb.po.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class symessVo {
    @TableId(value = "symessId", type = IdType.ID_WORKER)
    private Long symessId;

    @TableField("managerId")
    private Long managerId;

    @TableField("userId")
    private Long userId;

    @TableField("goodsId")
    private Long goodsId;

    @TableField("goodsName")
    private String goodsName;

    @TableField("isGoods")
    private Integer isGoods;

    @TableField("symessName")
    private String symessName;

    @TableField("symessCont")
    private String symessCont;

    @TableField("symessT")
    private Date symessT;

    @TableField("symessWhy")
    private String symessWhy;

    @TableField("symessImp")
    private String symessImp;

    @TableField("isRead")
    private Integer isRead;

    @TableField("goodsImage")
    private String goodsImage;

    @TableField("goodsPrice")
    private Double goodsPrice;
}
