package com.example.secondhandWeb.mapper;

import com.example.secondhandWeb.po.Symess;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.secondhandWeb.po.vo.symessVo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2021-05-27
 */
public interface SymessMapper extends BaseMapper<Symess> {
    public symessVo getIsGoodsDetail(Long symessId);

}
