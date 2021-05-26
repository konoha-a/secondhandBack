package com.example.secondhandWeb.mapper;

import com.example.secondhandWeb.po.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.secondhandWeb.po.vo.goodsVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2021-04-20
 */
public interface GoodsMapper extends BaseMapper<Goods> {
    public goodsVo getDetailById(Long goodsId);

    public List<Goods> getAllGoodsList();
}
