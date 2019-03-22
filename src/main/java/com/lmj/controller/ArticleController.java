package com.lmj.controller;

import com.lmj.model.Article;
import com.lmj.model.User;
import com.lmj.service.article.ArticleServiceImpl;
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
    //上传文件
    @GetMapping("uploadArticle")
    public String uploadArticle(){

        return "article/wirter";
    }
    @PostMapping("uploadArticle")
    public String uploadArticla(@RequestBody Article article, HttpServletRequest request, Model model){
        HttpSession session =  request.getSession();
        User user=(User)session.getAttribute("user");
        System.out.println(article.getIsOriginal());
        if(article.getTitle().length()<=0){
            model.addAttribute("errMsg","文章标题不能为空");
            System.out.println("asdas");
            return "文章标题不能为空";
        }else if(article.getIsOriginal()!=0&article.getIsOriginal()!=1){
            System.out.println("22222");
            model.addAttribute("errMsg","请输入正确的文章标签：0.原创，1.非原创");
            return "请输入正确的文章标签：0.原创，1.非原创";
        }
        Long createTime =new Date().getTime();
        article.setCreateTime(createTime);
        System.out.println("33333");
        System.out.println(article.getText());
        article.setUid(user.getId());
        System.out.println(article);
        articleService.saveArticle(article);
        return "aaa";
    }
}
