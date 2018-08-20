package cn.nb.service.impl;

import cn.nb.bean.Users;
import cn.nb.dao.UserMapper;
import cn.nb.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public Users findUserByNamePwd(String name, String password) {

        System.out.println("进入UserServiceImpl");
        return userMapper.findUserByNamePwd(name,password);

    }
}
