package com.example.secondhandWeb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.secondhandWeb.po.Adderss;
import com.example.secondhandWeb.mapper.AdderssMapper;
import com.example.secondhandWeb.service.AdderssService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-04-29
 */
@Service
public class AdderssServiceImpl extends ServiceImpl<AdderssMapper, Adderss> implements AdderssService {

    @Override
    public List<Adderss> getAdderById(Long userId) {
        QueryWrapper<Adderss> wrapper=new QueryWrapper<>();
        wrapper.eq("userId",userId);
        return baseMapper.selectList(wrapper);
    }

    @Override
    public int addAdder(Adderss adderss) {
        return baseMapper.insert(adderss);
    }

    @Override
    public int deleteAdder(Long adderId) {
        return baseMapper.deleteById(adderId);
    }

    @Override
    public int editAdder(Adderss adderss) {
        QueryWrapper<Adderss> wrapper = new QueryWrapper<>();
        wrapper.eq("adderId",adderss.getAdderId());
        Adderss adderss1=baseMapper.selectOne(wrapper);
        adderss1.setRecName(adderss.getRecName());
        adderss1.setRecPhone(adderss.getRecPhone());
        adderss1.setRecAdder(adderss.getRecAdder());

        return baseMapper.updateById(adderss1);
    }

    @Override
    public Adderss getAdderItem(Long adderId) {
        QueryWrapper<Adderss> wrapper=new QueryWrapper<>();
        wrapper.eq("adderId",adderId);
        return baseMapper.selectOne(wrapper);
    }


}
