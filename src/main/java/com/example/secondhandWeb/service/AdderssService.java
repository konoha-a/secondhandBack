package com.example.secondhandWeb.service;

import com.example.secondhandWeb.po.Adderss;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2021-04-29
 */
public interface AdderssService extends IService<Adderss> {

    List<Adderss> getAdderById(Long userId);

    int addAdder(Adderss adderss);

    int deleteAdder(Long adderId);

    int editAdder(Adderss adderss);

    Adderss getAdderItem(Long adderId);
}
