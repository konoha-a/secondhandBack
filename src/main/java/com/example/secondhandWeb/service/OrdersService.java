package com.example.secondhandWeb.service;

import com.example.secondhandWeb.po.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.secondhandWeb.po.vo.orderVo;
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

public interface OrdersService extends IService<Orders> {

    List<orderVo> getOrderList(int pageNo,int pageSize);

    int getOrderCount();

    List<Orders> findOrderById(Long orderId);

    int editOrder(Orders orders);

    Long addOrder(Orders orders);

    List<orderVo> getBuyList(Long buyerId,int pageNo,int pageSize);

    List<orderVo> getSellList(Long sellerId,int pageNo,int pageSize);

    List<orderVo> getCarList(Long userId);

    int getBuyCount(Long buyerId);

    int getSellCount(Long sellerId);

    int editOrderState(Long orderId,Integer orderState);

    int paySuccess(Long orderId,Long goodsId);

    int cancelOrder(Long orderId,Long goodsId);

    int deliverSuccess(Long orderId);

    int confirmOrder(Long orderId);

    int deleteOrder(Long orderId);

    orderVo getBuyDetail(Long orderId);

    orderVo getSellDetail(Long orderId);

    int editOrderAdder(Long orderId,Long adderId);

    orderVo getOrderData(Long orderId);

    int editOrderPrice(Long orderId,Double orderPrice,Long goodsId,Double goodsPrice,Double goodsCar);


}
