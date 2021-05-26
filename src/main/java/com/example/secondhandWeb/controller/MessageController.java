package com.example.secondhandWeb.controller;


import com.example.secondhandWeb.mapper.MessageMapper;
import com.example.secondhandWeb.po.Message;
import com.example.secondhandWeb.po.vo.messVo;
import com.example.secondhandWeb.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @since 2021-05-11
 */
@RestController
@RequestMapping("/secondhandWeb/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    //获取消息用户列表
    @PostMapping("getMessList")
    public List<messVo> getMessList(Long userId){
        return messageService.getMessList(userId);
    }

    //新增消息框
    @PostMapping("addMessList")
    public int addMessList(Long goodsId, Long userId, Long ortherId){
        Message message=new Message();
        message.setGoodsId(goodsId);
        message.setUserId(userId);
        message.setOrtherId(ortherId);
//        message.setMeContent(meContent);
        message.setIsShow(1);
        message.setIsSender(1);
        message.setIsRead(1);
        message.setSendT(new Date());

        return messageService.addMessList(message);
    }

    //新增消息
    @PostMapping("addMessCont")
    public int addMessCont(Long goodsId,Long userId,Long ortherId,String meContent){
        return messageService.addMessCont(goodsId,userId,ortherId,meContent);
    }

    //判断列表是否已经存在聊天框
    @PostMapping("isMessList")
    public int isMessList(Long goodsId,Long userId,Long ortherId){
        return messageService.isMessList(goodsId,userId,ortherId);
    }

    //关闭某个聊天窗口
    @PostMapping("closeMess")
    public int closeMess(Long goodsId,Long userId,Long ortherId){
        return messageService.closeMess(goodsId,userId,ortherId);
    }

    //显示某聊天窗口
    @PostMapping("showMess")
    public int showMess(Long goodsId,Long userId,Long ortherId){
        return messageService.showMess(goodsId,userId,ortherId);
    }

    //显示聊天记录
    @PostMapping("getMessDetail")
    public List<Message> getMessDetail(Long goodsId,Long userId,Long ortherId){
        return messageService.getMessDetail(goodsId,userId,ortherId);
    }

    //判断是否有未读消息
    @PostMapping("isExistRead")
    public int isExistRead(Long userId){
        return messageService.isExistRead(userId);
    }

    //标记已读
    @PostMapping("setReaded")
    public int setReaded(Long goodsId,Long userId,Long ortherId){
        return messageService.serReaded(goodsId,userId,ortherId);
    }
}

