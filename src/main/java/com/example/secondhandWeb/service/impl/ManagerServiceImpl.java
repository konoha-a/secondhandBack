package com.example.secondhandWeb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.secondhandWeb.po.Manager;
import com.example.secondhandWeb.mapper.ManagerMapper;
import com.example.secondhandWeb.service.ManagerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-04-18
 */
@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements ManagerService {

//    获取管理员列表
    @Override
    public List<Manager> getList() {
        return baseMapper.selectList(null);
    }

//    管理员登录
    @Override
    public Manager managerLogin(String managerName,String managerPassword) {
        QueryWrapper<Manager> wrapper = new QueryWrapper<>();
        wrapper.eq("managerName",managerName);
        wrapper.eq("managerPassword",managerPassword);
        return baseMapper.selectOne(wrapper);
    }
}
