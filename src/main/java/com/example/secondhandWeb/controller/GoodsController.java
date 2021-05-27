package com.example.secondhandWeb.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.secondhandWeb.po.Goods;
import com.example.secondhandWeb.po.vo.goodsVo;
import com.example.secondhandWeb.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-04-20
 */
@RestController
@RequestMapping("/secondhandWeb/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    //获取商品列表（前台用
    @PostMapping("getGoodsList")
    public List<Goods> getGoodsList(int pageNo, int pageSize) {
        return goodsService.getGoodsList(pageNo, pageSize);
    }

    //获取商品列表（管理员用
    @PostMapping("getGoodsListMa")
    public List<Goods> getGoodsListMa(int pageNo,int pageSize){return goodsService.getGoodsListMa(pageNo,pageSize);}

    //获取商品总数（前台用）
    @GetMapping("getGoodsCount")
    public int getGoodsCount() {
        return goodsService.getGoodsCount();
    }

    //获取商品总数（管理员用）
    @GetMapping("getGoodsCountMa")
    public int getGoodsCountMa() {
        return goodsService.getGoodsCountMa();
    }

    //根据商品名称模糊查询
    @PostMapping("findGoodsByName")
    public List<Goods> findGoodsByName(String goodsName) {
        return goodsService.findGoodsByName(goodsName);
    }

    //真删除商品（管理员
    @PostMapping("deleteTGoods")
    public int deleteTGoods(Long goodsId) {
        return goodsService.deleteTGoods(goodsId);
    }

    //添加商品
    @PostMapping("addGoods")
    public Long addGoods(Long sellerId, String goodsName, String goodsImage, String goodsOldNew, String goodsIntroduct, Double goodsPrice, String goodsClass, Double goodsCar) {
        Goods goods = new Goods();
        goods.setSellerId(sellerId);
        goods.setGoodsName(goodsName);
        goods.setGoodsImage(goodsImage);
        goods.setGoodsOldNew(goodsOldNew);
        goods.setGoodsIntroduct(goodsIntroduct);
        goods.setGoodsPrice(goodsPrice);
        goods.setGoodsClass(goodsClass);
        goods.setGoodsCar(goodsCar);

        return goodsService.addGoods(goods);
    }

    //根据商品id获取商品
    @PostMapping("getDetailById/{goodsId}")
    public goodsVo getDetailById(@PathVariable Long goodsId) {
        return goodsService.getDetailById(goodsId);
    }

    //根据商品分类返回商品列表
    @PostMapping("getGoodsListByClass")
    public List<Goods> getGoodsListByClass(int index, int pageNo, int pageSize) {
        return goodsService.getGoodsListByClass(index, pageNo, pageSize);
    }

    //获取商品分类总数
    @PostMapping("getClassCount")
    public int getClassCount(int index) {
        return goodsService.getClassCount(index);
    }

    //在商品分类中模糊查询商品
    @PostMapping("findGoodsInClass")
    public List<Goods> findGoodsInClass(List<Goods> classList, String goodsName) {
        return goodsService.findGoodsInClass(classList, goodsName);
    }

    //获取我的商品列表
    @PostMapping("getMyGoodsList")
    public List<Goods> getMyGoodsList(Long userId, int pageNo, int pageSize) {
        return goodsService.getMyGoodsList(userId, pageNo, pageSize);
    }

    //获取我的商品总数
    @PostMapping("getMyGoodsCount")
    public int getMyGoodsCount(Long userId) {
        return goodsService.getMyGoodsCount(userId);
    }

    //获取自己发布的商品列表（未卖出
    @PostMapping("getFGoodsList")
    public List<Goods> getFGoodsList(Long sellerId) {
        return goodsService.getFGoodsList(sellerId);
    }

    //获取自己发布的商品列表（已卖出
    @PostMapping("getTGoodsList")
    public List<Goods> getTGoodsList(Long sellerId) {
        return goodsService.getTGoodsList(sellerId);
    }

    //修改商品信息
    @PostMapping("editGoods")
    public int editGoods(Goods goods) {
        return goodsService.editGoods(goods);
    }

    //假删除商品（用户用
    @PostMapping("deleteFGoods")
    public int deleteFGoods(Long goodsId) {
        return goodsService.deleteFGoods(goodsId);
    }
}

