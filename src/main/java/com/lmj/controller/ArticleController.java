package com.lmj.controller;

import com.lmj.model.Article;
import com.lmj.model.ArticleInfo;
import com.lmj.model.User;
import com.lmj.service.article.ArticleServiceImpl;
import com.lmj.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleServiceImpl articleService;
    @Autowired
    private UserServiceImpl userService;
    //上传文件
    @GetMapping("uploadArticle")
    public String uploadArticle(){

        return "article/wirter";
    }
    @PostMapping("uploadArticle")
    @ResponseBody
    public String uploadArticla(@RequestBody Article article, HttpServletRequest request, Model model){
        HttpSession session =  request.getSession();
        User user=(User)session.getAttribute("user");
        String msg=null;
        if(article.getTitle().length()<=0){
            msg="文章标题不能为空";
        }else if(article.getIsOriginal()!=0&article.getIsOriginal()!=1){
            msg="请输入正确的文章标签：0.原创，1.非原创";
        }else{
            Long createTime =new Date().getTime();
            Long updateTime =new Date().getTime();
            article.setCreateTime(createTime);
            article.setUpdateTime(updateTime);
            article.setUid(user.getId());
            articleService.saveArticle(article);
            msg="上传文章成功";
        }
        msg = "{\"msg\":\""+msg+"\"}";
        return msg;
    }

    //查看文章详情
    @GetMapping("findArticle")
    public String findArticle(@RequestParam(name="title",defaultValue = " ")String title,Model model){
        if(title.length()>0){
            ArticleInfo articleInfo = articleService.findArticleInfoByTitle(title);
            String username=userService.findUserNameById(articleInfo.getUid());
            articleInfo.setUsername(username);
            model.addAttribute("articleInfo",articleInfo);

        }
        return "article/article";
    }
}
