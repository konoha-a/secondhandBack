package com.example.secondhandWeb.service;

import com.example.secondhandWeb.po.Manager;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2021-04-18
 */

public interface ManagerService extends IService<Manager> {
    List<Manager> getList();//获取管理员列表
    Manager managerLogin(String managerName,String managerPassword);//管理员登录
}
