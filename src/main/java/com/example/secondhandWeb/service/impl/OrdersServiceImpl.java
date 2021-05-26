package com.example.secondhandWeb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.secondhandWeb.mapper.GoodsMapper;
import com.example.secondhandWeb.po.Goods;
import com.example.secondhandWeb.po.Orders;
import com.example.secondhandWeb.mapper.OrdersMapper;
import com.example.secondhandWeb.po.vo.orderVo;
import com.example.secondhandWeb.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-04-20
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

    @Resource
    private OrdersMapper ordersMapper;
    @Resource
    private GoodsMapper goodsMapper;

    //获取订单列表
    @Override
    public List<orderVo> getOrderList(int pageNo, int pageSize) {
        List<orderVo> orders = ordersMapper.getOrderList(pageNo);
        List<orderVo> orders1 = new ArrayList<>();
        int j = 0;

        for (int i = pageSize * (pageNo - 1); i < pageSize * pageNo; i++) {
            if (i < orders.size()) {
                if (!orders.get(i).getOrderId().equals("")) {
                    orders1.add(orders.get(i));
                    j++;
                }
            }
            if (j == pageSize) break;
        }
        if (orders1.size() == 0) {
            return null;
        } else {
            return orders1;
        }
    }

    //获取订单总数
    @Override
    public int getOrderCount() {
        return baseMapper.selectCount(null);
    }

    //根据订单id查询订单
    @Override
    public List<Orders> findOrderById(Long orderId) {
        QueryWrapper<Orders> wrapper = new QueryWrapper<>();
        wrapper.like("orderId", orderId);
        return baseMapper.selectList(wrapper);
    }

    //编辑订单
    @Override
    public int editOrder(Orders orders) {
        return baseMapper.updateById(orders);
    }

    @Override
    public Long addOrder(Orders orders) {
        if (baseMapper.insert(orders) == 1)
            return orders.getOrderId();
        else return 0L;
    }

    @Override
    public List<orderVo> getBuyList(Long buyerId) {
        return ordersMapper.getBuyList(buyerId);
    }

    @Override
    public List<orderVo> getSellList(Long sellerId) {
        return ordersMapper.getSellList(sellerId);
    }

    @Override
    public int editOrderState(Long orderId,Integer orderState) {
        QueryWrapper<Orders> wrapper = new QueryWrapper<>();
        wrapper.eq("orderId", orderId);
        Orders orders = baseMapper.selectOne(wrapper);
        orders.setOrderState(orderState);
        baseMapper.updateById(orders);
        return 1;
    }

    @Override
    public int paySuccess(Long orderId,Long goodsId) {
        List<Goods> good=goodsMapper.getAllGoodsList();
        for(int j=0;j<good.size();j++){
            if(good.get(j).getGoodsId()==goodsId && good.get(j).getIsSell()==1){
                return -1;
            }
        }

        editOrderState(orderId,2);
        QueryWrapper<Orders> wrapper=new QueryWrapper<>();
        wrapper.eq("orderId",orderId);
        Orders orders = baseMapper.selectOne(wrapper);
        orders.setOrderPayT(new Date());
        baseMapper.updateById(orders);

        //修改商品是否卖出属性
        for(int i=0;i<good.size();i++){
            if(good.get(i).getGoodsId()==goodsId){
                good.get(i).setIsSell(1);
                goodsMapper.updateById(good.get(i));
            }
        }
        return 1;
    }

    @Override
    public int cancelOrder(Long orderId,Long goodsId) {
        editOrderState(orderId,0);

        //修改商品是否卖出属性
        List<Goods> good=goodsMapper.getAllGoodsList();
        for(int i=0;i<good.size();i++){
            if(good.get(i).getGoodsId()==goodsId){
                good.get(i).setIsSell(0);
                goodsMapper.updateById(good.get(i));
            }
        }
        return 1;
    }

    @Override
    public int deliverSuccess(Long orderId) {
        editOrderState(orderId,3);
        QueryWrapper<Orders> wrapper=new QueryWrapper<>();
        wrapper.eq("orderId",orderId);
        Orders orders = baseMapper.selectOne(wrapper);
        orders.setOrderDelT(new Date());
        return baseMapper.updateById(orders);
    }

    @Override
    public int confirmOrder(Long orderId) {
        editOrderState(orderId,4);
        QueryWrapper<Orders> wrapper=new QueryWrapper<>();
        wrapper.eq("orderId",orderId);
        Orders orders = baseMapper.selectOne(wrapper);
        orders.setOrderConfT(new Date());
        return baseMapper.updateById(orders);
    }

    @Override
    public int deleteOrder(Long orderId) {
        QueryWrapper<Orders> wrapper=new QueryWrapper<>();
        wrapper.eq("orderId",orderId);
        Orders orders=baseMapper.selectOne(wrapper);
        return baseMapper.deleteById(orders);
    }

    @Override
    public orderVo getBuyDetail(Long orderId) {
        return ordersMapper.getBuyDetail(orderId);
    }

    @Override
    public orderVo getSellDetail(Long orderId) {
        return ordersMapper.getSellDetail(orderId);
    }

    @Override
    public int editOrderAdder(Long orderId,Long adderId) {
        QueryWrapper<Orders> wrapper=new QueryWrapper<>();
        wrapper.eq("orderId",orderId);
        Orders orders=baseMapper.selectOne(wrapper);
        orders.setAdderId(adderId);
        return baseMapper.updateById(orders);
    }

    @Override
    public orderVo getOrderData(Long orderId) {
        return ordersMapper.getOrderData(orderId);
    }

    @Override
    public int editOrderPrice(Long orderId,Double orderPrice,Long goodsId,Double goodsPrice,Double goodsCar) {
        QueryWrapper<Orders> wrapper=new QueryWrapper<>();
        wrapper.eq("orderId",orderId);
        Orders orders=baseMapper.selectOne(wrapper);
        orders.setOrderPrice(orderPrice);
        baseMapper.updateById(orders);

        //修改商品价格
        List<Goods> good=goodsMapper.getAllGoodsList();
        for(int i=0;i<good.size();i++){
            if(good.get(i).getGoodsId()==goodsId){
                good.get(i).setGoodsPrice(goodsPrice);
                good.get(i).setGoodsCar(goodsCar);
                goodsMapper.updateById(good.get(i));
            }
        }
        return 1;
    }


}
