package com.example.secondhandWeb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.secondhandWeb.po.User;
import com.example.secondhandWeb.mapper.UserMapper;
import com.example.secondhandWeb.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

//    用户登陆
    @Override
    public User userLogin(String userName, String userPassword) {
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("userName",userName);
        wrapper.eq("userPassword",userPassword);
        return baseMapper.selectOne(wrapper);
    }

//    是否存在相同的用户名
    @Override
    public int isExistUserName(String userName){
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("userName",userName);
        List<User> list=baseMapper.selectList(wrapper);
        if(list.size()==0) return -1;
        else return 1;
    }

//    是否存在相同的手机号
    @Override
    public int isExistUserPhone(String userPhone){
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("userPhone",userPhone);
        List<User> list=baseMapper.selectList(wrapper);
        if(list.size()==0) return -1;
        else return 1;
    }

    //    用户注册
    @Override
    public int userRegister(User user) {
        return baseMapper.insert(user);
    }

    //    获取用户列表
    @Override
    public List<User> getUserList(int pageNo,int pageSize) {
        List<User> users=baseMapper.selectList(null);
        List<User> users1=new ArrayList<>();
        int j=0;

        for(int i=pageSize*(pageNo-1); i<pageSize*pageNo; i++){
            if(i<users.size()){
                if(!users.get(i).getUserName().equals("")){
                    users1.add(users.get(i));
                    j++;
                }
            }
            if(j==pageSize)   break;
        }
        if(users1.size()==0){
            return null;
        }else{
            return users1;
        }
    }

    //根据用户名模糊查询
    @Override
    public List<User> findUserByName(String userName) {
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.like("userName",userName);
        return baseMapper.selectList(wrapper);
    }

    @Override
    public List<User> findUserBySchool(String userSchool) {
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.like("userSchool",userSchool);
        return baseMapper.selectList(wrapper);
    }

    //获取用户总数
    @Override
    public int getUserCount() {
        return baseMapper.selectCount(null);
    }

    @Override
    public int editUser(User user){
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("userId",user.getUserId());
        User user1=baseMapper.selectOne(wrapper);
        user1.setUserImage(user.getUserImage());
        user1.setUserName(user.getUserName());
        user1.setUserPhone(user.getUserPhone());
        user1.setUserEmail(user.getUserEmail());
        user1.setUserAdder(user.getUserAdder());
        user1.setUserSchool(user.getUserSchool());

        return baseMapper.updateById(user1);
    }

    @Override
    public User getUserInfo(Long userId) {
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("userId",userId);
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public int checkUserName(Long userId,String userName) {
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("userId",userId);
        User user=baseMapper.selectOne(wrapper);
        if(user.getUserName().equals(userName)) return -1;//没改用户名，不存在重复
        else return isExistUserName(userName);
    }

    @Override
    public int checkUserPhone(Long userId, String userPhone) {
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("userId",userId);
        User user=baseMapper.selectOne(wrapper);
        if(user.getUserPhone().equals(userPhone)) return -1;//没改用户名，不存在重复
        else return isExistUserPhone(userPhone);
    }

}
