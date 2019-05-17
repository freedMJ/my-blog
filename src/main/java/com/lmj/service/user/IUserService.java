package com.lmj.service.user;

import com.lmj.model.User;

public interface IUserService {
    //注册用户
    void registerUser(User user);
    //登陆
    User loginUser(String username,String password);
    //根据用户名查找用户
    User findUserByUserName(String username);
    //修改密码
    void updateUserPassword(Integer id,String password);
    //修改邮箱
    void updateUserEmail(Integer id,String email);
    //修改电话
    void updateUserPhoneNum(Integer id,String phoneNum);
    //修改真实姓名
    void updateUserRelName(Integer id,String relName);
    //修改个人签名
    void updateUserSign(Integer id,String userSign);
    //根据用户id查找用户名
    String findUserNameById(int id);
    //每次登陆用户发表一次文章文章数增加一
    void updateArticleNumsbyUserName(String username);
    //每次删除文章用户文章数减一
    void delArticleOnlyOne(String username);
}
