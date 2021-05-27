package com.example.secondhandWeb.service;

import com.example.secondhandWeb.po.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.secondhandWeb.po.vo.goodsVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2021-04-20
 */

public interface GoodsService extends IService<Goods> {

    List<Goods> getGoodsList(int pageNo,int pageSize);//获取商品列表

    List<Goods> getGoodsListMa(int pageNo, int pageSize);

    int getGoodsCount();//获取商品总数

    int getGoodsCountMa();

    List<Goods> findGoodsByName(String goodsName);//根据商品名称模糊查询

    int deleteTGoods(Long goodsId);

    Long addGoods(Goods goods);

    goodsVo getDetailById(Long goodsId);

    String getClassName(int index);

    List<Goods> getGoodsListByClass(int index,int pageNo,int pageSize);

    int getClassCount(int index);

    List<Goods> findGoodsInClass(List<Goods> classList,String goodsName);

    List<Goods> getFGoodsList(Long sellerId);

    List<Goods> getTGoodsList(Long sellerId);

    List<Goods> getMyGoodsList(Long userId,int pageNo,int pageSize);

    int getMyGoodsCount(Long userId);

    int editGoods(Goods goods);

    int deleteFGoods(Long goodsId);
}
