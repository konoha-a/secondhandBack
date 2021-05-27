package com.example.secondhandWeb.po;

import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

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
 * @since 2021-05-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Symess对象", description = "")
public class Symess implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "symessId", type = IdType.AUTO)
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

    public Long getSymessId() {
        return symessId;
    }
    public Long getManagerId() {
        return managerId;
    }
    public Long getUserId() {
        return userId;
    }
    public Long getGoodsId() {
        return goodsId;
    }
    public String getGoodsName() {
        return goodsName;
    }
    public Integer getIsGoods() {
        return isGoods;
    }
    public String getSymessName() {
        return symessName;
    }
    public String getSymessCont() {
        return symessCont;
    }
    public Date getSymessT() {
        return symessT;
    }
    public String getSymessWhy() {
        return symessWhy;
    }
    public String getSymessImp() {
        return symessImp;
    }
    public Integer getIsRead() {
        return isRead;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    public void setIsGoods(Integer isGoods) {
        this.isGoods = isGoods;
    }
    public void setSymessName(String symessName) {
        this.symessName = symessName;
    }
    public void setSymessCont(String symessCont) {
        this.symessCont = symessCont;
    }
    public void setSymessT(Date symessT) {
        this.symessT = symessT;
    }
    public void setSymessWhy(String symessWhy) {
        this.symessWhy = symessWhy;
    }
    public void setSymessImp(String symessImp) {
        this.symessImp = symessImp;
    }
    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }
}
