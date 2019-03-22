package com.lmj.controller;

import com.lmj.model.ArticleInfo;
import com.lmj.model.User;
import com.lmj.service.article.IArticleService;
import com.lmj.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IArticleService articleService;
    //首页
    @GetMapping("index")
    public String index(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user!=null){
            model.addAttribute("isLogin","isSuccess");//true:登陆，false：未登陆
            model.addAttribute("user",user);
        }else{
            model.addAttribute("isLogin","notLogin");//true:登陆，false：未登陆
        }

        return "user/index";
    }
    //得到所有文章详细信息
    @PostMapping("allArticleInfo")
    @ResponseBody
    public List<ArticleInfo> allArticleInfo(){
        List<ArticleInfo> articleInfoList = articleService.findAllArticleInfo();
        System.out.println(articleInfoList);
        return articleInfoList;
    }

    //注册
    @GetMapping("register")
    public String userRegister(){

        return "user/register";
    }

    @PostMapping("register")
    public String userRegister(@ModelAttribute("user") User user,Model model){
        //先进数据库查询用户名是否已被注册
        User user2=userService.findUserByUserName(user.getUsername());
        //用户已经存在
        if(user2!=null){
            model.addAttribute("errMsg","用户名已经存在");
            return "user/register";
        }else{//用户不存在，成功注册
            userService.registerUser(user);
            return "user/login";
        }

          }

    //登陆
    @GetMapping("login")
    public String userLogin(){
        return "user/login";
    }
    @PostMapping("login")
    public String userLogin(@RequestParam("username")String username,@RequestParam("password")String password, HttpServletRequest request, Model model){
        User ret_user = userService.loginUser(username,password);
        if(ret_user==null){
            model.addAttribute("errMsg","该用户不存在");
            return "user/errLogin";
        }else{
            //登陆成功，跳转到首页，用户信息存进session
            HttpSession session = request.getSession( );
            session.setAttribute("user",ret_user);
            return "redirect:/user/index";
        }
    }
    //用户退出
    @RequestMapping("quit")
    public String quit(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "redirect:/user/index";
    }
    //进入用户中心
    @GetMapping("userCenter")
    public String userCenter(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user =(User)session.getAttribute("user");

        return "user/userCenter";
    }
    //进入用户详细情况
    @GetMapping("userInfo")
    public String userInfo(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user =(User)session.getAttribute("user");

        return "user/userInfo";
    }

    //修改密码
    @PostMapping("updateUserPassword")
    public String updataUserPassword(@RequestParam("password") String password,HttpServletRequest request ,Model model){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(password.length()<=0){
            model.addAttribute("errUpdatePassword","密码不能为空");
            return "/user/userInfo";
        }
        userService.updateUserPassword(user.getId(),password);
        model.addAttribute("updatePassword","更新密码成功");
        //做了修改要把session中的user更新
        user.setPassword(password);
        session.setAttribute("user",user);
        return "/user/userInfo";
    }
    //修改邮箱
    @PostMapping("updateUserEmail")
    public String updataUserEmail(@RequestParam("email") String email,HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        userService.updateUserEmail(user.getId(),email);
        model.addAttribute("updateEmail","更新电子邮箱成功");
        user.setEmail(email);
        session.setAttribute("user",user);
        return "/user/userInfo";

    }
    //修改电话
    @PostMapping("updateUserPhoneNum")
    public String updataUserPhoneNum(@RequestParam("phoneNum") String phoneNum,HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        userService.updateUserPhoneNum(user.getId(),phoneNum);
        model.addAttribute("updatePhoneNum","更新个人电话成功");
        user.setPhoneNum(phoneNum);
        session.setAttribute("user",user);
        return "/user/userInfo";
    }
    //修改真实姓名
    @PostMapping("updateUserRelName")
    public String updataUserRelName(@RequestParam("relName") String relName,HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        userService.updateUserRelName(user.getId(),relName);
        model.addAttribute("updateRelName","更新真实姓名成功");
        user.setRelName(relName);
        session.setAttribute("user",user);
        return "/user/userInfo";
    }
    //修改个人签名
    @PostMapping("updateUserSign")
    public String updateUserSign(@RequestParam("userSign") String userSign,HttpServletRequest request,Model model){

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        userService.updateUserSign(user.getId(),userSign);
        model.addAttribute("updateUserSign","更新个人签名成功");
        user.setUserSign(userSign);
        session.setAttribute("user",user);
        return "/user/userInfo";
    }
    //修改头像
    //访问作者
    @GetMapping("findAuthor")
    public String findAuthorCenter(){

        return "user/authorCenter";
    }
    //查看文章详情
    @GetMapping("findArticle")
    public String findArticle(){
        return "article/article";
    }
}
