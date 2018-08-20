package cn.nb.dao;

import cn.nb.bean.Product;
import cn.nb.bean.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    //通过用户名和密码得到用户
    public Users findUserByNamePwd(@Param("name") String name, @Param("password") String password);





}
