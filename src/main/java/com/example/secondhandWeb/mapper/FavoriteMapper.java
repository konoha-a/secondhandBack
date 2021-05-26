package com.example.secondhandWeb.mapper;

import com.example.secondhandWeb.po.Favorite;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.secondhandWeb.po.vo.favoVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2021-04-24
 */
public interface FavoriteMapper extends BaseMapper<Favorite> {
    public List<favoVo> getFavoListById(Long userId);

    public int getListCount(Long userId);
}
