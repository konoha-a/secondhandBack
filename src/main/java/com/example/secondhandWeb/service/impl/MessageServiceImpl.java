package com.example.secondhandWeb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.secondhandWeb.po.Message;
import com.example.secondhandWeb.mapper.MessageMapper;
import com.example.secondhandWeb.po.vo.messVo;
import com.example.secondhandWeb.service.MessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Date;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-05-11
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

    @Resource
    private MessageMapper messageMapper;

    @Override
    public List<messVo> getMessList(Long userId) {
        List<messVo> list = messageMapper.getMessList(userId);
        return list;
    }

    @Override
    public int addMessList(Message message) {
        return baseMapper.insert(message);
    }

    @Override
    public int isMessList(Long goodsId, Long userId, Long ortherId) {
        QueryWrapper<Message> wrapper=new QueryWrapper<>();
        wrapper.eq("goodsId",goodsId);
        wrapper.eq("userId",userId);
        wrapper.eq("ortherId",ortherId);
        List<Message> list=baseMapper.selectList(wrapper);
        if(list.size()==0) return 0;//不在列表
        else{//在列表
            for(int i=0;i<list.size();i++){
                if(list.get(i).getIsShow()==0) return 1;//在列表但不显示
                else return 2;//在列表且显示
            }
        }
        return 3;
    }

    @Override
    public int closeMess(Long goodsId, Long userId, Long ortherId) {
        QueryWrapper<Message> wrapper=new QueryWrapper<>();
        wrapper.eq("goodsId",goodsId);
        wrapper.eq("userId",userId);
        wrapper.eq("ortherId",ortherId);
        List<Message> list = baseMapper.selectList(wrapper);
        for(int i=0;i<list.size();i++){
            list.get(i).setIsShow(0);
            baseMapper.updateById(list.get(i));

        }
        return 1;
    }

    @Override
    public int showMess(Long goodsId, Long userId, Long ortherId) {
        QueryWrapper<Message> wrapper=new QueryWrapper<>();
        wrapper.eq("goodsId",goodsId);
        wrapper.eq("userId",userId);
        wrapper.eq("ortherId",ortherId);
        List<Message> list = baseMapper.selectList(wrapper);
        for(int i=0;i<list.size();i++){
            list.get(i).setIsShow(1);
            baseMapper.updateById(list.get(i));

        }
        return 1;
    }

    @Override
    public List<Message> getMessDetail(Long goodsId, Long userId, Long ortherId) {
        QueryWrapper<Message> wrapper=new QueryWrapper<>();
        wrapper.eq("goodsId",goodsId);
        wrapper.eq("userId",userId);
        wrapper.eq("ortherId",ortherId);
        wrapper.ne("meContent","null");
        return baseMapper.selectList(wrapper);
    }

    @Override
    public int addMessCont(Long goodsId,Long userId,Long ortherId,String meContent) {
        Message message1=new Message();
        message1.setGoodsId(goodsId);
        message1.setUserId(userId);
        message1.setOrtherId(ortherId);
        message1.setSenderId(userId);
        message1.setRecerId(ortherId);
        message1.setMeContent(meContent);
        message1.setIsShow(1);
        message1.setIsSender(1);
        message1.setIsRead(1);
        message1.setSendT(new Date());
        baseMapper.insert(message1);

        Message message2=new Message();
        message2.setGoodsId(goodsId);
        message2.setUserId(ortherId);
        message2.setOrtherId(userId);
        message2.setSenderId(userId);
        message2.setRecerId(ortherId);
        message2.setMeContent(meContent);
        message2.setIsShow(1);
        message2.setIsSender(0);
        message2.setIsRead(0);
        message2.setSendT(new Date());
        baseMapper.insert(message2);

        QueryWrapper<Message> wrapper=new QueryWrapper<>();
        wrapper.eq("ortherId",userId);
        wrapper.eq("userId",ortherId);
        wrapper.eq("goodsId",goodsId);
        List<Message> list = baseMapper.selectList(wrapper);
        for(int i=0;i<list.size();i++){
            list.get(i).setIsRead(0);
            baseMapper.updateById(list.get(i));
        }

        return 1;
    }

    @Override
    public int isExistRead(Long userId) {
        QueryWrapper<Message> wrapper=new QueryWrapper<>();
        wrapper.eq("userId",userId);
        wrapper.eq("isShow",1);
        wrapper.eq("isRead",0);
        List<Message> list=baseMapper.selectList(wrapper);
        if(list.size()==0) return 0;//无消息
        else return 1;//有消息
    }

    @Override
    public int setReaded(Long goodsId, Long userId, Long ortherId) {
        QueryWrapper<Message> wrapper=new QueryWrapper<>();
        wrapper.eq("goodsId",goodsId);
        wrapper.eq("userId",userId);
        wrapper.eq("ortherId",ortherId);
        wrapper.eq("isShow",1);
        wrapper.eq("isRead",0);
        List<Message> list = baseMapper.selectList(wrapper);
        if(list.size()==0)  return 0;
        else{
            for(int i=0;i<list.size();i++){
                list.get(i).setIsRead(1);
                baseMapper.updateById(list.get(i));
            }

            return 1;
        }
    }
}
