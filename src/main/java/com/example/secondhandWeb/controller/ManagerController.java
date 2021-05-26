package com.example.secondhandWeb.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.secondhandWeb.po.Manager;
import com.example.secondhandWeb.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-04-18
 */
@RestController
@RequestMapping("/secondhandWeb/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

//    获取管理员列表
    @GetMapping("/list")
    public List<Manager> getList(){
        return managerService.getList();
    }

//    管理员登录
    @PostMapping("/managerLogin")
    public Manager managerLogin(String managerName,String managerPassword){
        return managerService.managerLogin(managerName,managerPassword);
    }
}

