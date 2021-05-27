package com.example.secondhandWeb.service;

import com.example.secondhandWeb.po.Symess;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.secondhandWeb.po.vo.symessVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2021-05-27
 */
public interface SymessService extends IService<Symess> {

    List<Symess> getSymessList(Long userId);

    List<Symess> getSymessListMa(int pageNo, int pageSize);

    int getSymessCount();

    symessVo getIsGoodsDetail(Long symessId);

    Symess getSymessDetail(Long symessId);

    int addGoodsSymess(Symess symess);

    int isExistSymess(Long userId);

    int setReaded(Long symessId);

    int addSymess(Symess symess);

    int deleteSymess(Long symessId);
}
