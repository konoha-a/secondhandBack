package com.example.secondhandWeb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.secondhandWeb.mapper.GoodsMapper;
import com.example.secondhandWeb.mapper.UserMapper;
import com.example.secondhandWeb.po.Attention;
import com.example.secondhandWeb.mapper.AttentionMapper;
import com.example.secondhandWeb.po.Goods;
import com.example.secondhandWeb.po.User;
import com.example.secondhandWeb.po.vo.attentVo;
import com.example.secondhandWeb.service.AttentionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-04-26
 */
@Service
public class AttentionServiceImpl extends ServiceImpl<AttentionMapper, Attention> implements AttentionService {

    @Resource
    private  AttentionMapper attentionMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public int addAttent(Attention attention) {
        List<Attention> attents=baseMapper.selectList(null);
        for(int i=0;i<attents.size();i++){
            if(attents.get(i).getUserId().equals(attention.getUserId()) && attents.get(i).getBeAttentId().equals(attention.getBeAttentId())){
                return -1;
            }
        }
       baseMapper.insert(attention);
        List<User> users =userMapper.getAllUserList();
        for(int j=0;j<users.size();j++){
            if(users.get(j).getUserId().equals(attention.getUserId())){
                users.get(j).setAttentCount(users.get(j).getAttentCount()+1);
                userMapper.updateById(users.get(j));
            }
            if(users.get(j).getUserId().equals(attention.getBeAttentId())){
                users.get(j).setFansCount(users.get(j).getFansCount()+1);
                userMapper.updateById(users.get(j));
            }
        }
        return 1;
    }

    @Override
    public int cancelAttent(Long userId, Long beAttentId) {
        List<Attention> attents=baseMapper.selectList(null);
        for(int i=0;i<attents.size();i++){
            if(attents.get(i).getUserId().equals(userId) && attents.get(i).getBeAttentId().equals(beAttentId)){
                baseMapper.deleteById(attents.get(i).getAttentId());

                List<User> users =userMapper.getAllUserList();
                for(int j=0;j<users.size();j++) {
                    if (users.get(j).getUserId().equals(userId)) {
                        users.get(j).setAttentCount(users.get(j).getAttentCount() - 1);
                        userMapper.updateById(users.get(j));
                    }
                    if(users.get(j).getUserId().equals(beAttentId)){
                        users.get(j).setFansCount(users.get(j).getFansCount()-1);
                        userMapper.updateById(users.get(j));
                    }
                }
                return 1;
            }
        }
        return -1;
    }

    @Override
    public int isAttent(Long userId, Long beAttentId) {
        List<Attention> attents=baseMapper.selectList(null);
        for(int i=0;i<attents.size();i++){
            if(attents.get(i).getUserId().equals(userId) && attents.get(i).getBeAttentId().equals(beAttentId)){
                return 1;
            }
        }
        return -1;
    }

    @Override
    public List<attentVo> getBeAttentList(Long userId) {
        List<attentVo> list=attentionMapper.getBeAttentList(userId);
        return list;
    }

    @Override
    public List<attentVo> getFansList(Long userId) {
        List<attentVo> list=attentionMapper.getFansList(userId);
        return list;
    }

}
