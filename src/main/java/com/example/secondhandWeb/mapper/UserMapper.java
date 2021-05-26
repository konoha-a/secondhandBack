package com.example.secondhandWeb.mapper;

import com.example.secondhandWeb.po.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2021-04-18
 */
public interface UserMapper extends BaseMapper<User> {
    public List<User> getAllUserList();
}
