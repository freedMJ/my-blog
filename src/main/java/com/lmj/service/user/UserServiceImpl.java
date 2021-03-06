package com.lmj.service.user;

import com.lmj.mapper.user.UserMapper;
import com.lmj.model.User;
import com.lmj.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;
    //注册用户
    @Override
    public void registerUser(User user) {
        userMapper.registerUser(user);

    }
    //登陆
    @Override
    public User loginUser(String username, String password) {
        return userMapper.loginUser(username,password);
    }
    //根据用户名查找用户
    @Override
    public User findUserByUserName(String username) {
        return userMapper.findUserByUserName(username);
    }

    //修改密码
    @Override
    public void updateUserPassword(Integer id, String password) {
        userMapper.updateUserPassword(id,password);
    }
    //修改邮箱
    @Override
    public void updateUserEmail(Integer id, String email) {
       userMapper.updateUserEmail(id,email);
    }
    //修改电话
    @Override
    public void updateUserPhoneNum(Integer id, String phoneNum) {
        userMapper.updateUserPhoneNum(id, phoneNum);
    }
    //修改真实姓名
    @Override
    public void updateUserRelName(Integer id, String relName) {
        userMapper.updateUserRelName(id, relName);
    }
    //修改个人签名
    @Override
    public void updateUserSign(Integer id, String userSign) {
        userMapper.updateUserSign(id, userSign);
    }
    //根据id查找用户名
    @Override
    public String findUserNameById(int id) {

        return userMapper.findUserNameById(id);
    }
    //每次登陆用户发表一次文章，发布文章数增加一
    @Override
    public void updateArticleNumsbyUserName(String username) {
        userMapper.updateArticleNumsbyUserName(username);
    }

    @Override
    public void delArticleOnlyOne(String username) {
        userMapper.delArticleOnlyOne(username);
    }
    //查找所有的文章标签字
    @Override
    public List<String> findAllKeyWord() {
        return userMapper.findAllKeyWord();
    }


}
