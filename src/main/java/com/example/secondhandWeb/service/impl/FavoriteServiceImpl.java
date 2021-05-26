package com.example.secondhandWeb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.secondhandWeb.mapper.GoodsMapper;
import com.example.secondhandWeb.po.Favorite;
import com.example.secondhandWeb.mapper.FavoriteMapper;
import com.example.secondhandWeb.po.Goods;
import com.example.secondhandWeb.po.vo.favoVo;
import com.example.secondhandWeb.service.FavoriteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-04-24
 */
@Service
public class FavoriteServiceImpl extends ServiceImpl<FavoriteMapper, Favorite> implements FavoriteService {

    @Resource
    private FavoriteMapper favoriteMapper;
    @Resource
    private GoodsMapper goodsMapper;

    //根据用户id获取收藏夹
    @Override
    public List<favoVo> getFavoListById(Long userId,int pageNo,int pageSize) {
        List<favoVo> list=favoriteMapper.getFavoListById(userId);
        List<favoVo> list1=new ArrayList<>();
        int j=0;

        for(int i=pageSize*(pageNo-1); i<pageSize*pageNo; i++){
            if(i<list.size()){
                if(!list.get(i).getGoodsName().equals("")){
                    list1.add(list.get(i));
                    j++;
                }
            }
            if(j==pageSize)   break;
        }
        if(list1.size()==0){
            return null;
        }else{
            return list1;
        }
    }

    //加入收藏
    @Override
    public int addToFavo(Favorite favorite) {
        List<Favorite> favorites=baseMapper.selectList(null);
        for(int i=0;i<favorites.size();i++){
            if(favorites.get(i).getGoodsId().equals(favorite.getGoodsId()) && favorites.get(i).getUserId().equals(favorite.getUserId())){
                return -1;
            }
        }
        baseMapper.insert(favorite);

        List<Goods> good =goodsMapper.getAllGoodsList();
        for(int j=0;j<good.size();j++){
            if(good.get(j).getGoodsId().equals(favorite.getGoodsId())){
                good.get(j).setGoodsFavorite(good.get(j).getGoodsFavorite()+1);
                goodsMapper.updateById(good.get(j));
            }
        }
        return 1;
    }

    //取消收藏
    @Override
    public int cancelFavo(Long goodsId,Long userId) {
        List<Favorite> favorites=baseMapper.selectList(null);
        for(int i=0;i<favorites.size();i++){
            if(favorites.get(i).getGoodsId().equals(goodsId) && favorites.get(i).getUserId().equals(userId)){
                baseMapper.deleteById(favorites.get(i).getFavoId());

                List<Goods> good =goodsMapper.getAllGoodsList();
                for(int j=0;j<good.size();j++){
                    if(good.get(j).getGoodsId().equals(goodsId)){
                        good.get(j).setGoodsFavorite(good.get(j).getGoodsFavorite()-1);
                        goodsMapper.updateById(good.get(j));
                    }
                }

                return 1;
            }
        }
        return -1;
    }

    //判断是否收藏
    @Override
    public int isFavo(Long goodsId,Long userId) {
        List<Favorite> favorites=baseMapper.selectList(null);
        for(int i=0;i<favorites.size();i++){
            if(favorites.get(i).getGoodsId().equals(goodsId) && favorites.get(i).getUserId().equals(userId)){
                return 1;
            }
        }
        return -1;
    }

    @Override
    public int getFavoCount(Long userId) {
        return favoriteMapper.getListCount(userId);
    }
}
