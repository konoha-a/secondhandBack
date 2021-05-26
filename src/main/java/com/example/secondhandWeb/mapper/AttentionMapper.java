package com.example.secondhandWeb.mapper;

import com.example.secondhandWeb.po.Attention;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.secondhandWeb.po.vo.attentVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2021-04-26
 */
public interface AttentionMapper extends BaseMapper<Attention> {
    public List<attentVo> getBeAttentList(Long userId);

    public List<attentVo> getFansList(Long userId);
}
