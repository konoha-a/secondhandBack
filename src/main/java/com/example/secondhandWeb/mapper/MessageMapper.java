package com.example.secondhandWeb.mapper;

import com.example.secondhandWeb.po.Message;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.secondhandWeb.po.vo.messVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2021-05-11
 */
public interface MessageMapper extends BaseMapper<Message> {
    public List<messVo> getMessList(Long userId);
}
