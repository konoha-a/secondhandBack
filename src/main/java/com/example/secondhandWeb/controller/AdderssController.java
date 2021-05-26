package com.example.secondhandWeb.controller;


import com.example.secondhandWeb.po.Adderss;
import com.example.secondhandWeb.service.AdderssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-04-29
 */
@RestController
@RequestMapping("/secondhandWeb/adderss")
public class AdderssController {
    @Autowired
    private AdderssService adderssService;

    //根据用户id获取地址列表
    @PostMapping("getAdderById")
    public List<Adderss> getAdderById(Long userId){
        return adderssService.getAdderById(userId);
    }

    //新增地址
    @PostMapping("addAdder")
    public int addAdder(Long userId,String recName,String recPhone,String recAdder){
        Adderss adderss=new Adderss();
        adderss.setUserId(userId);
        adderss.setRecName(recName);
        adderss.setRecPhone(recPhone);
        adderss.setRecAdder(recAdder);

        return adderssService.addAdder(adderss);
    }

    //删除地址
    @PostMapping("deleteAdder")
    public int deleteAdder(Long adderId){
        return adderssService.deleteAdder(adderId);
    }

    //编辑地址
    @PostMapping("editAdder")
    public int editAdder(Adderss adderss){
        return adderssService.editAdder(adderss);
    }

    //根据地址id获取单条地址
    @PostMapping("getAdderItem")
    public Adderss getAdderItem(Long adderId){
        return adderssService.getAdderItem(adderId);
    }
}

