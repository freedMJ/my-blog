package com.lmj.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lmj.model.Article;
import com.lmj.model.ArticleInfo;
import com.lmj.model.User;
import com.lmj.service.article.IArticleService;
import com.lmj.service.user.IUserService;
import com.lmj.utils.PageNumArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;


@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IArticleService articleService;
    //规定每页显示的数据条数
    @Value("${common.pageSize}")
    int pageSize;
    //首页
    @GetMapping("index")
    public String index(@RequestParam(name="username",defaultValue = "all") String username,@RequestParam(name = "keyWord",defaultValue = "all")String keyWord,
                        @RequestParam(name="title",defaultValue = "all")String title,@RequestParam(name = "isOriginal",defaultValue = "3")int isOriginal,
                        Model model,HttpServletRequest request,@RequestParam(name="pageNum",defaultValue ="1")int pageNum){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user!=null){
            model.addAttribute("isLogin","isSuccess");//true:登陆，false：未登陆
            model.addAttribute("user",user);
        }else{
            model.addAttribute("isLogin","notLogin");//true:登陆，false：未登陆
        }
        Page  page =null;
        if("all".equals(username)&&"all".equals(keyWord)&&"all".equals(title)&&isOriginal==3){
            //无分页
            page=(Page) articleService.findArticleInfoPage(pageNum,pageSize);
        }else{
            //搜索分页
            page= (Page) articleService.findIndexAllArticle(username,keyWord,title,isOriginal,pageNum,pageSize);
        }
        //调用工具类抽取的得到分页页码的数组
        int pages=page.getPages();//总的页数
        model.addAttribute("pages",pages);
        PageNumArray pageNumArray = new PageNumArray();
        int[] nums = pageNumArray.getPageNumArray(pageNum,pages);
        model.addAttribute("nums",nums);
        model.addAttribute("page",page);
        model.addAttribute("username",username);
        model.addAttribute("title",title);
        model.addAttribute("keyWord",keyWord);
        model.addAttribute("isOriginal",isOriginal);
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("pageSize",pageSize);
        return "user/index";
    }
    //注册
    @GetMapping("register")
    public String userRegister(){

        return "user/register";
    }

    @PostMapping("register")
    @ResponseBody
    public String userRegister(@RequestBody User user){
        //先进数据库查询用户名是否已被注册
        System.out.println(user);
        User user2=userService.findUserByUserName(user.getUsername());
        System.out.println(user2);
        String msg=null;
        //用户已经存在
        if(user2!=null){
            msg="用户名已经存在";
        }else{//用户不存在，成功注册
            //user.setArticleNums(0);
            userService.registerUser(user);
            msg="注册成功，请返回首页或进行登陆";

        }
        String data="{\"msg\":\""+msg+"\"}";
        return data;
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
            return "user/login";
        }else{
             User new_user = userService.findUserByUserName(username);
            //登陆成功，跳转到首页，用户信息存进session
            HttpSession session = request.getSession( );
            session.setAttribute("user",new_user);
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
    public String userCenter(HttpServletRequest request,Model model,@RequestParam(name="pageNum",defaultValue = "1") int pageNum){
        HttpSession session = request.getSession();
        User user =(User)session.getAttribute("user");
        model.addAttribute("user",user);
        int uid = user.getId();
        Page page = (Page) articleService.findUserAllArticleByUidPage(uid,pageNum,pageSize);
        int pages=page.getPages();
        model.addAttribute("pageList",page);//查到的分页文章数据
        model.addAttribute("pages",pages);//总的分页数
        model.addAttribute("pageNum",pageNum);//当前页
        model.addAttribute("pageSize",pageSize);//每页允许显示的文章数量
        //得到分页数目列表
        PageNumArray pageNumArray = new PageNumArray();
        int[] nums = pageNumArray.getPageNumArray(pageNum, pages);
        model.addAttribute("nums",nums);
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
        String username = user.getUsername();
        User new_user = userService.findUserByUserName(username);
        session.setAttribute("user",new_user);
        return "/user/userInfo";
    }
    //修改邮箱
    @PostMapping("updateUserEmail")
    public String updataUserEmail(@RequestParam("email") String email,HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        userService.updateUserEmail(user.getId(),email);
        model.addAttribute("updateEmail","更新电子邮箱成功");
        String username = user.getUsername();
        User new_user = userService.findUserByUserName(username);
        session.setAttribute("user",new_user);
        return "/user/userInfo";

    }
    //修改电话
    @PostMapping("updateUserPhoneNum")
    public String updataUserPhoneNum(@RequestParam("phoneNum") String phoneNum,HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        userService.updateUserPhoneNum(user.getId(),phoneNum);
        model.addAttribute("updatePhoneNum","更新个人电话成功");
        String username = user.getUsername();
        User new_user = userService.findUserByUserName(username);
        session.setAttribute("user",new_user);
        return "/user/userInfo";
    }
    //修改真实姓名
    @PostMapping("updateUserRelName")
    public String updataUserRelName(@RequestParam("relName") String relName,HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        userService.updateUserRelName(user.getId(),relName);
        model.addAttribute("updateRelName","更新真实姓名成功");
        String username = user.getUsername();
        User new_user = userService.findUserByUserName(username);
        session.setAttribute("user",new_user);
        return "/user/userInfo";
    }
    //修改个人签名
    @PostMapping("updateUserSign")
    public String updateUserSign(@RequestParam("userSign") String userSign,HttpServletRequest request,Model model){

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        userService.updateUserSign(user.getId(),userSign);
        model.addAttribute("updateUserSign","更新个人签名成功");
        String username = user.getUsername();
        User new_user = userService.findUserByUserName(username);
        session.setAttribute("user",new_user);
        return "/user/userInfo";
    }
    //修改头像
    //访问作者
    @GetMapping("findAuthor")
    public String findAuthorCenter(Model model,@RequestParam(name="uid",defaultValue="0")int uid,@RequestParam(name="pageNum",defaultValue ="1")int pageNum){
        if(uid!=0){
            //根据用户id查询用户信息
            User user = articleService.findUserByUid(uid);
            Page page = (Page) articleService.findUserAllArticleByUidPage(uid,pageNum,pageSize);
            int pages=page.getPages();
            model.addAttribute("userInfo",user);//查到的用户详情
            model.addAttribute("pageList",page);//查到的分页文章数据
            model.addAttribute("uid",uid);
            model.addAttribute("pages",pages);//总的分页数
            model.addAttribute("pageNum",pageNum);//当前页
            model.addAttribute("pageSize",pageSize);//每页允许显示的文章数量
            //得到分页数目列表
            PageNumArray pageNumArray = new PageNumArray();
            int[] nums = pageNumArray.getPageNumArray(pageNum, pages);
            model.addAttribute("nums",nums);
        }
        return "user/authorCenter";
    }
    //删除文章
    @RequestMapping("delArticle")
    public String delArticle(@RequestParam(name="title",defaultValue = " null") String title,HttpServletRequest request){
        if(!"null".equals(title)){
            //文章表删除记录，用户表文章数减一
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            String username = user.getUsername();
            articleService.delArticleByTitle(title);
            userService.delArticleOnlyOne(username);
            User new_user = userService.findUserByUserName(username);
            session.setAttribute("user",new_user);
        }
        return "redirect:/user/userCenter";
    }
    //修改文章

    @GetMapping("updateArticle")
    public String updateArticle(@RequestParam(name="id",defaultValue = "null")int id,Model model){
        if(!("null".equals(id))){
            //根据id查找文章信息
            Article article = articleService.findArticleById(id);
            model.addAttribute("article",article);
        }
        return "article/updateWirter";
    }
    @PostMapping("updateArticle")
    @ResponseBody
    public String updateArticle(@RequestBody Article article, HttpServletRequest request, Model model){
        HttpSession session =  request.getSession();
        User user=(User)session.getAttribute("user");
        String username = user.getUsername();
        String msg=null;
        Long updateTime =new Date().getTime();
        Integer isOriginal = article.getIsOriginal();
        String keyWord = article.getKeyWord();
        String text = article.getText();
        //判断是有已经有了重名的文章名
        String title=article.getTitle();
        //String is_title = articleService.findisExistTitleByTitle(title);
       if(title.length()<=0){
            msg="文章标题不能为空";
        }else if(keyWord.length()<=0){
            msg="请输入文章关键字";
        }else if(article.getIsOriginal()!=0&article.getIsOriginal()!=1){
            msg="请输入正确的文章标签：0.原创，1.非原创";
        }else if(text.length()<=11){
            msg="请输入文章正文内容";
        }else{
            articleService.updateUpdateArticleById(updateTime,title,keyWord,text,isOriginal,article.getId());
            User new_user  = userService.findUserByUserName(username);
            session.setAttribute("user",new_user);
            msg="更新文章成功";
        }
        msg = "{\"msg\":\""+msg+"\"}";
        return msg;
    }

}
