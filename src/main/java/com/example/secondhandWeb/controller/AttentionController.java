package com.example.secondhandWeb.controller;


import com.example.secondhandWeb.po.Attention;
import com.example.secondhandWeb.po.vo.attentVo;
import com.example.secondhandWeb.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-04-26
 */
@RestController
@RequestMapping("/secondhandWeb/attention")
public class AttentionController {
    @Autowired
    private AttentionService attentionService;

    //加关注
    @PostMapping("addAttent")
    public int addAttent(Long userId,Long beAttentId){
        Attention attention=new Attention();
        attention.setUserId(userId);
        attention.setBeAttentId(beAttentId);
        return attentionService.addAttent(attention);
    }

    //取消关注
    @PostMapping("cancelAttent")
    public int cancelAttent(Long userId,Long beAttentId){
        return attentionService.cancelAttent(userId,beAttentId);
    }

    //判断是否关注
    @PostMapping("isAttent")
    public int isAttent(Long userId,Long beAttentId){
        return attentionService.isAttent(userId,beAttentId);
    }

    //根据用户id获取关注列表
    @PostMapping("getBeAttentList")
    public List<attentVo> getBeAttentList(Long userId){
        return attentionService.getBeAttentList(userId);
    }

    //根据用户id获取粉丝列表
    @PostMapping("getFansList")
    public List<attentVo> getFansList(Long userId){
        return attentionService.getFansList(userId);
    }
}

