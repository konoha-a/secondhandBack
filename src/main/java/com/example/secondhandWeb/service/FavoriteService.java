package com.example.secondhandWeb.service;

import com.example.secondhandWeb.po.Favorite;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.secondhandWeb.po.vo.favoVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2021-04-24
 */
public interface FavoriteService extends IService<Favorite> {

    List<favoVo> getFavoListById(Long userId,int pageNo,int pageSize);

    int addToFavo(Favorite favorite);

    int cancelFavo(Long goodsId,Long userId);

    int isFavo(Long goodsId,Long userId);

    int getFavoCount(Long userId);
}
