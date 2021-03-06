package com.lmj.mapper.user;

import com.lmj.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //注册
    void registerUser(User user);
    //根据用户名查找用户
    User findUserByUserName(String username);
    //用户登录
    User loginUser(@Param("username") String username, @Param("password") String password);//只有一个参数可以不加，多个要指定
    //修改密码
     void updateUserPassword(@Param("id") Integer id,@Param("password") String password);
    //修改邮箱
    void updateUserEmail(@Param("id")Integer id,@Param("email")String email);
    //修改电话
    void updateUserPhoneNum(@Param("id")Integer id,@Param("phoneNum")String phoneNum);
    //修改真实姓名
    void updateUserRelName(@Param("id")Integer id,@Param("relName")String relName);
    //修改个人签名
    void updateUserSign(@Param("id")Integer id,@Param("userSign")String userSign);
    //查找发布的文章数
    //根据id查找用户名
    String findUserNameById(int id);
    //每次登陆用户发表一次文章文章数增加一
    void updateArticleNumsbyUserName(String username);
    //每次删除文章用户文章数减一
    void delArticleOnlyOne(@Param("username")String username);
    //查找所有的文章标签字
    List<String> findAllKeyWord();
}
