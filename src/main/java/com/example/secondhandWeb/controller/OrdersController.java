package com.example.secondhandWeb.controller;


import com.example.secondhandWeb.po.Goods;
import com.example.secondhandWeb.po.Orders;
import com.example.secondhandWeb.po.vo.orderVo;
import com.example.secondhandWeb.service.GoodsService;
import com.example.secondhandWeb.service.OrdersService;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-04-20
 */
@RestController
@RequestMapping("/secondhandWeb/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private GoodsService goodsService;

    //获取订单列表
    @PostMapping("getOrderList")
    public List<orderVo> getOrderList(int pageNo,int pageSize){
        return ordersService.getOrderList(pageNo,pageSize);
    }

    //获取订单总数
    @GetMapping("getOrderCount")
    public int getOrderCount(){
        return ordersService.getOrderCount();
    }

    //根据订单编号查询
    @PostMapping("findOrderById")
    public List<Orders> findOrderById(Long orderId){
        return ordersService.findOrderById(orderId);
    }

    //编辑订单
    @PostMapping("editOrder")
    public int editOrder(Orders orders){
        return ordersService.editOrder(orders);
    }

    //添加订单
    @PostMapping("addOrder")
    public Long addOrder(Long goodsId, Long buyerId,Long adderId, Double orderPrice, Integer orderState){
        Orders orders=new Orders();
        orders.setGoodsId(goodsId);
        orders.setBuyerId(buyerId);
        orders.setAdderId(adderId);
        orders.setOrderPrice(orderPrice);
        orders.setOrderCreaT(new Date());
        orders.setOrderState(orderState);

        return ordersService.addOrder(orders);
    }

    //我买到的商品订单列表
    @PostMapping("getBuyList")
    public List<orderVo> getBuyList(Long buyerId,int pageNo,int pageSize){
        return ordersService.getBuyList(buyerId,pageNo,pageSize);
    }

    //我买到的商品订单总数
    @PostMapping("getBuyCount")
    public int getBuyCount(Long buyerId){return ordersService.getBuyCount(buyerId);}

    //我卖出的商品订单列表
    @PostMapping("getSellList")
    public List<orderVo> getSellList(Long sellerId,int pageNo,int pageSize){
        return ordersService.getSellList(sellerId,pageNo,pageSize);
    }

    //我卖出的商品订单总数
    @PostMapping("getSellCount")
    public int getSellCount(Long sellerId){return ordersService.getSellCount(sellerId);}

    //物流订单列表
    @PostMapping("getCarList")
    public List<orderVo> getCarList(Long userId){return ordersService.getCarList(userId);}

    //完成支付
    @PostMapping("paySuccess")
    public int paySuccess(Long orderId,Long goodsId){
        return ordersService.paySuccess(orderId,goodsId);
    }

    //取消订单
    @PostMapping("cancelOrder")
    public int cancelOrder(Long orderId,Long goodsId){
        return ordersService.cancelOrder(orderId,goodsId);
    }

    //发货
    @PostMapping("deliverSuccess")
    public int deliverSuccess(Long orderId){
        return ordersService.deliverSuccess(orderId);
    }

    //确认收货
    @PostMapping("confirmOrder")
    public int confirmOrder(Long orderId){
        return ordersService.confirmOrder(orderId);
    }

    //删除订单
    @PostMapping("deleteOrder")
    public int deleteOrder(Long orderId){
        return ordersService.deleteOrder(orderId);
    }

    //获取买到的订单详情
    @PostMapping("getBuyDetail")
    public orderVo getBuyDetail(Long orderId){
        return ordersService.getBuyDetail(orderId);
    }

    //获取卖出的订单详情
    @PostMapping("getSellDetail")
    public orderVo getSellDetail(Long orderId){
        return ordersService.getSellDetail(orderId);
    }

    //修改地址
    @PostMapping("editOrderAdder")
    public int editOrderAdder(Long orderId,Long adderId){
        return ordersService.editOrderAdder(orderId,adderId);
    }

    //获取订单数据
    @PostMapping("getOrderData")
    public orderVo getOrderData(Long orderId){
        return ordersService.getOrderData(orderId);
    }

    //修改订单价格
    @PostMapping("editOrderPrice")
    public int editOrderPrice(Long orderId,Double orderPrice,Long goodsId,Double goodsPrice,Double goodsCar){
        return ordersService.editOrderPrice(orderId,orderPrice,goodsId,goodsPrice,goodsCar);
    }
}

