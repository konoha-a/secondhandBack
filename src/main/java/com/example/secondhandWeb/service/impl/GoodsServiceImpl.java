package com.example.secondhandWeb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.secondhandWeb.mapper.UserMapper;
import com.example.secondhandWeb.po.Goods;
import com.example.secondhandWeb.mapper.GoodsMapper;
import com.example.secondhandWeb.po.User;
import com.example.secondhandWeb.po.vo.goodsVo;
import com.example.secondhandWeb.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
 * @since 2021-04-20
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private UserMapper userMapper;

    //获取商品列表
    @Override
    public List<Goods> getGoodsList(int pageNo,int pageSize) {
        QueryWrapper<Goods> wrapper=new QueryWrapper<>();
        wrapper.eq("isSell",0);
        wrapper.eq("isDelete",0);

        List<Goods> goods=baseMapper.selectList(wrapper);
        List<Goods> goods1=new ArrayList<>();
        int j=0;
        for(int i=pageSize*(pageNo-1); i<pageSize*pageNo; i++){
            if(i<goods.size()){
                if(!goods.get(i).getGoodsName().equals("")){
                    goods1.add(goods.get(i));
                    j++;
                }
            }
            if(j==pageSize)   break;
        }
        if(goods1.size()==0){
            return null;
        }else{
            return goods1;
        }
    }

    //获取商品总数（前台用）
    @Override
    public int getGoodsCount() {
        QueryWrapper<Goods> wrapper=new QueryWrapper<>();
        wrapper.eq("isSell",0);
        wrapper.eq("isDelete",0);
        return baseMapper.selectCount(wrapper);
    }

    //获取商品总数（管理员用）
    @Override
    public int getGoodsCountMa() {
        return baseMapper.selectCount(null);
    }

    //根据商品名称模糊查询
    @Override
    public List<Goods> findGoodsByName(String goodsName) {
        QueryWrapper<Goods> wrapper=new QueryWrapper<>();
        wrapper.like("goodsName",goodsName);
        return baseMapper.selectList(wrapper);
    }

    //添加商品
    @Override
    public Long addGoods(Goods goods) {
        List<Goods> good=baseMapper.selectList(null);
        baseMapper.insert(goods);
        //修改用户发布商品数量
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("userId",goods.getSellerId());
        User user=userMapper.selectOne(wrapper);
        user.setPublishCount(user.getPublishCount()+1);
        userMapper.updateById(user);

        return goods.getGoodsId();
    }

    //删除商品
    @Override
    public int deleteTGoods(Long goodsId) {
        QueryWrapper<Goods> wrapper=new QueryWrapper<>();
        wrapper.eq("goodsId",goodsId);
        Goods good=baseMapper.selectOne(wrapper);
        return baseMapper.deleteById(good);
    }

    //根据商品id获取商品详情
    @Override
    public goodsVo getDetailById(Long goodsId) {
        goodsVo list = goodsMapper.getDetailById(goodsId);
        return list;
    }

    //对应分类名称
    @Override
    public String getClassName(int index) {
        if(index==1)    return "书籍";
        else if(index==2)  return "学习用品";
        else if(index==3)    return "食品";
        else if(index==4)    return "电子产品";
        else if(index==5)    return "体育用品";
        else   return "生活用品";
    }

    //根据商品分类返回商品列表
    @Override
    public List<Goods> getGoodsListByClass(int index,int pageNo,int pageSize) {
        QueryWrapper<Goods> wrapper=new QueryWrapper<>();
        wrapper.eq("goodsClass",getClassName(index));
        wrapper.eq("isSell",0);
        wrapper.eq("isDelete",0);

        List<Goods> goods=baseMapper.selectList(wrapper);
        List<Goods> goods1=new ArrayList<>();
        int j=0;
        for(int i=pageSize*(pageNo-1); i<pageSize*pageNo; i++){
            if(i<goods.size()){
                if(!goods.get(i).getGoodsName().equals("")){
                    goods1.add(goods.get(i));
                    j++;
                }
            }
            if(j==pageSize)   break;
        }
        if(goods1.size()==0){
            return null;
        }else{
            return goods1;
        }
    }

    @Override
    public int getClassCount(int index) {
        QueryWrapper<Goods> wrapper=new QueryWrapper<>();
        wrapper.eq("goodsClass",getClassName(index));
        wrapper.eq("isSell",0);
        wrapper.eq("isDelete",0);
        return baseMapper.selectCount(wrapper);
    }

    //在分类中模糊查询商品
    @Override
    public List<Goods> findGoodsInClass(List<Goods> classList,String goodsName) {
//        for(int i=0;i<classList.size();i++){
//            if (classList.get(i).getGoodsName())
//        }
        return null;
    }

    @Override
    public List<Goods> getFGoodsList(Long sellerId) {
        QueryWrapper<Goods> wrapper=new QueryWrapper<>();
        wrapper.eq("sellerId",sellerId);
        wrapper.eq("isSell",0);
        return baseMapper.selectList(wrapper);
    }

    @Override
    public List<Goods> getTGoodsList(Long sellerId) {
        QueryWrapper<Goods> wrapper=new QueryWrapper<>();
        wrapper.eq("sellerId",sellerId);
        wrapper.eq("isSell",1);
        return baseMapper.selectList(wrapper);
    }

    @Override
    public List<Goods> getMyGoodsList(Long userId,int pageNo,int pageSize) {
        QueryWrapper<Goods> wrapper=new QueryWrapper<>();
        wrapper.eq("sellerId",userId);
        List<Goods> goods = baseMapper.selectList(wrapper);
        List<Goods> goods1=new ArrayList<>();
        int j=0;
        for(int i=pageSize*(pageNo-1); i<pageSize*pageNo; i++){
            if(i<goods.size()){
                if(!goods.get(i).getGoodsName().equals("")){
                    goods1.add(goods.get(i));
                    j++;
                }
            }
            if(j==pageSize)   break;
        }
        if(goods1.size()==0){
            return null;
        }else{
            return goods1;
        }
    }

    @Override
    public int getMyGoodsCount(Long userId) {
        QueryWrapper<Goods> wrapper=new QueryWrapper<>();
        wrapper.eq("sellerId",userId);
        return baseMapper.selectCount(wrapper);
    }

    @Override
    public int editGoods(Goods goods) {
        QueryWrapper<Goods> wrapper=new QueryWrapper<>();
        wrapper.eq("goodsId",goods.getGoodsId());
        Goods goods1=baseMapper.selectOne(wrapper);
        goods1.setGoodsImage(goods.getGoodsImage());
        goods1.setGoodsName(goods.getGoodsName());
        goods1.setGoodsPrice(goods.getGoodsPrice());
        goods1.setGoodsCar(goods.getGoodsCar());
        goods1.setGoodsClass(goods.getGoodsClass());
        goods1.setGoodsOldNew(goods.getGoodsOldNew());
        goods1.setGoodsIntroduct(goods.getGoodsIntroduct());
        return baseMapper.updateById(goods1);
    }

    @Override
    public int deleteFGoods(Long goodsId) {
        QueryWrapper<Goods> wrapper=new QueryWrapper<>();
        wrapper.eq("goodsId",goodsId);
        Goods good=baseMapper.selectOne(wrapper);
        good.setIsDelete(1);
        baseMapper.updateById(good);

        //修改用户发布商品数量
        QueryWrapper<User> wrapper1=new QueryWrapper<>();
        wrapper.eq("userId",good.getSellerId());
        User user=userMapper.selectOne(wrapper1);
        user.setPublishCount(user.getPublishCount()-1);
        userMapper.updateById(user);

        return 1;
    }

}
