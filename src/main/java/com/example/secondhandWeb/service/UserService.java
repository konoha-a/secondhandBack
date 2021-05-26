package com.example.secondhandWeb.service;

import com.example.secondhandWeb.po.User;
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

public interface UserService extends IService<User> {

    User userLogin(String userName, String userPassword);//用户登录

    int userRegister(User user);//用户注册

    int isExistUserName(String userName);//是否存在相同的用户名

    int isExistUserPhone(String userPhone);//是否存在相同的手机号

    List<User> getUserList(int pageNo,int pageSize);//获取用户列表

    List<User> findUserByName(String userName);//根据用户名模糊查询

    List<User> findUserBySchool(String userSchool);

    int getUserCount();//获取用户总数

    User updateUser(Long userId);

    int editUser(User user);

    User getUserInfo(Long userId);


}
