package cn.nb.service;

import cn.nb.bean.Users;
import org.apache.ibatis.annotations.Param;

public interface UserService {

    //通过用户名和密码得到用户
    public Users findUserByNamePwd( String name,  String password);

}
