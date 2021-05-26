package com.example.secondhandWeb.controller;


import com.example.secondhandWeb.po.Favorite;
import com.example.secondhandWeb.po.vo.favoVo;
import com.example.secondhandWeb.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
 * @since 2021-04-24
 */
@RestController
@RequestMapping("/secondhandWeb/favorite")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    //根据userId获取收藏夹列表
    @PostMapping("getFavoListById/{userId}")
    public List<favoVo> getFavoList(@PathVariable Long userId,int pageNo,int pageSize){
        return favoriteService.getFavoListById(userId,pageNo,pageSize);
    }

    //获取收藏夹总数
    @PostMapping("getFavoCount")
    public int getFavoCount(Long userId){
        return favoriteService.getFavoCount(userId);
    }

    //判断是否在收藏夹中
    @PostMapping("isFavo")
    public int isFavo(Long goodsId,Long userId){
        return favoriteService.isFavo(goodsId,userId);
    }

    //加入收藏夹
    @PostMapping("addToFavo")
    public int addToFavo(Long goodsId,Long userId){
        Favorite favorite=new Favorite();
        favorite.setGoodsId(goodsId);
        favorite.setUserId(userId);
//        favorite.setIsFavo(isFavo);
        return favoriteService.addToFavo(favorite);
    }

    //取消收藏
    @PostMapping("cancelFavo")
    public int cancelFavo(Long goodsId,Long userId){
        return favoriteService.cancelFavo(goodsId,userId);
    }



}

