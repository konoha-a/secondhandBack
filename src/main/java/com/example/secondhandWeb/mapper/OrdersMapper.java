package com.example.secondhandWeb.mapper;

import com.example.secondhandWeb.po.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.secondhandWeb.po.vo.orderVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2021-04-20
 */
public interface OrdersMapper extends BaseMapper<Orders> {
    List<orderVo> getOrderList();

    List<orderVo> getBuyList(Long buyerId);

    List<orderVo> getSellList(Long sellerId);

    List<orderVo> getCarList(Long userId);

    orderVo getBuyDetail(Long orderId);

    orderVo getSellDetail(Long orderId);

    orderVo getOrderData(Long orderId);

    int getSellCount(Long sellerId);
}
