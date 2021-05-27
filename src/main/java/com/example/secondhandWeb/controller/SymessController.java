package com.example.secondhandWeb.controller;


import com.example.secondhandWeb.mapper.SymessMapper;
import com.example.secondhandWeb.po.Symess;
import com.example.secondhandWeb.po.vo.symessVo;
import com.example.secondhandWeb.service.SymessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-05-27
 */
@RestController
@RequestMapping("/secondhandWeb/symess")
public class SymessController {
    @Autowired
    private SymessService symessService;

    //获取系统消息列表（前台用
    @PostMapping("getSymessList")
    public List<Symess> getSymessList(Long userId) {
        return symessService.getSymessList(userId);
    }

    //获取消息列表（管理员用
    @PostMapping("getSymessListMa")
    public List<Symess> getSymessListMa(int pageNo, int pageSize){return symessService.getSymessListMa(pageNo,pageSize);}

    //获取消息总数
    @GetMapping("getSymessCount")
    public int getSymessCount(){return symessService.getSymessCount();}

    //获取违规商品详情
    @PostMapping("getIsGoodsDetail")
    public symessVo getIsGoodsDetail(Long symessId) {
        return symessService.getIsGoodsDetail(symessId);
    }

    //获取系统消息详情
    @PostMapping("getSymessDetail")
    public Symess getSymessDetail(Long symessId){
        return symessService.getSymessDetail(symessId);
    }

    //新增系统消息（违规
    @PostMapping("addGoodsSymess")
    public int addGoodsSymess(Long managerId,Long userId,Long goodsId,String goodsName) {
        Symess symess=new Symess();
        symess.setManagerId(managerId);
        symess.setUserId(userId);
        symess.setGoodsId(goodsId);
        symess.setGoodsName(goodsName);
        symess.setIsGoods(1);
        symess.setSymessName("违禁商品信息违规删除");
        symess.setSymessT(new Date());
        symess.setSymessWhy("发布的商品内容中含有违禁信息");
        symess.setSymessImp("删除商品");

        return symessService.addGoodsSymess(symess);
    }

    //新增系统消息（全体
    @PostMapping("addSymess")
    public int addSymess(Long managerId,String symessName,String symessCont){
        Symess symess=new Symess();
        symess.setManagerId(managerId);
        symess.setSymessT(new Date());
        symess.setSymessName(symessName);
        symess.setSymessCont(symessCont);
        symess.setIsRead(1);

        return symessService.addSymess(symess);
    }

    //判断是否有未读消息（不判断系统消息
    @PostMapping("isExistSymess")
    public int isExistSymess(Long userId){return symessService.isExistSymess(userId);}

    //标记已读
    @PostMapping("setReaded")
    public int setReaded(Long symessId){return symessService.setReaded(symessId);}

    //删除系统消息
    @PostMapping("deleteSymess")
    public int deleteSymess(Long symessId){return symessService.deleteSymess(symessId);}
}

