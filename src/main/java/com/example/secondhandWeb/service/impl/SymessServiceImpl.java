package com.example.secondhandWeb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.secondhandWeb.po.Symess;
import com.example.secondhandWeb.mapper.SymessMapper;
import com.example.secondhandWeb.po.vo.symessVo;
import com.example.secondhandWeb.service.SymessService;
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
 * @since 2021-05-27
 */
@Service
public class SymessServiceImpl extends ServiceImpl<SymessMapper, Symess> implements SymessService {

    @Resource
    private SymessMapper symessMapper;

    @Override
    public List<Symess> getSymessList(Long userId) {
        QueryWrapper<Symess> wrapper=new QueryWrapper<>();
        wrapper.eq("isGoods",0).or().eq("userId",userId);
        return baseMapper.selectList(wrapper);
    }

    @Override
    public List<Symess> getSymessListMa(int pageNo, int pageSize) {
        List<Symess> symess = baseMapper.selectList(null);
        List<Symess> symess1=new ArrayList<>();
        int j=0;
        for(int i=pageSize*(pageNo-1); i<pageSize*pageNo; i++){
            if(i<symess.size()){
                if(!symess.get(i).getSymessId().equals("")){
                    symess1.add(symess.get(i));
                    j++;
                }
            }
            if(j==pageSize)   break;
        }
        if(symess1.size()==0){
            return null;
        }else{
            return symess1;
        }
    }

    @Override
    public int getSymessCount() {
        return baseMapper.selectCount(null);
    }

    @Override
    public symessVo getIsGoodsDetail(Long symessId) {
        return symessMapper.getIsGoodsDetail(symessId);
    }

    @Override
    public Symess getSymessDetail(Long symessId) {
        QueryWrapper<Symess> wrapper=new QueryWrapper<>();
        wrapper.eq("symessId",symessId);
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public int addGoodsSymess(Symess symess) {
        return baseMapper.insert(symess);
    }

    @Override
    public int isExistSymess(Long userId) {
        QueryWrapper<Symess> wrapper=new QueryWrapper<>();
        wrapper.eq("userId",userId);
        wrapper.eq("isRead",0);
        List<Symess> list=baseMapper.selectList(wrapper);
        if (list.size()>0) return 1;
        else return 0;
    }

    @Override
    public int setReaded(Long symessId) {
        QueryWrapper<Symess> wrapper=new QueryWrapper<>();
        wrapper.eq("symessId",symessId);
        Symess symess=baseMapper.selectOne(wrapper);
        symess.setIsRead(1);
        return baseMapper.updateById(symess);
    }

    @Override
    public int addSymess(Symess symess) {
        return baseMapper.insert(symess);
    }

    @Override
    public int deleteSymess(Long symessId) {
        QueryWrapper<Symess> wrapper=new QueryWrapper<>();
        wrapper.eq("symessId",symessId);
        Symess symess=baseMapper.selectOne(wrapper);
        return baseMapper.deleteById(symess);
    }
}
