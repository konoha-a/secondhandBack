package com.example.secondhandWeb.service;

import com.example.secondhandWeb.po.Attention;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.secondhandWeb.po.vo.attentVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2021-04-26
 */
public interface AttentionService extends IService<Attention> {

    int addAttent(Attention attention);

    int cancelAttent(Long userId, Long beAttentId);

    int isAttent(Long userId, Long beAttentId);

    List<attentVo> getBeAttentList(Long userId);

    List<attentVo> getFansList(Long userId);
}
