package com.example.secondhandWeb.service;

import com.example.secondhandWeb.po.Message;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.secondhandWeb.po.vo.messVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2021-05-11
 */
public interface MessageService extends IService<Message> {

    List<messVo> getMessList(Long userId);

    int addMessList(Message message);

    int isMessList(Long goodsId, Long userId, Long ortherId);

    int closeMess(Long goodsId, Long userId, Long ortherId);

    int showMess(Long goodsId, Long userId, Long ortherId);

    List<Message> getMessDetail(Long goodsId, Long userId, Long ortherId);

    int addMessCont(Long goodsId,Long userId,Long ortherId,String meContent);

    int isExistRead(Long userId);

    int setReaded(Long goodsId, Long userId, Long ortherId);
}
