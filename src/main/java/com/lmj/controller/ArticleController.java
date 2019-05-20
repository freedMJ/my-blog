package com.lmj.controller;

import com.lmj.model.Article;
import com.lmj.model.ArticleInfo;
import com.lmj.model.User;
import com.lmj.service.article.ArticleServiceImpl;
import com.lmj.service.user.UserServiceImpl;
import com.lmj.utils.BaiduApiUtil;
import com.lmj.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
        //判断是有已经有了重名的文章名
        String title=article.getTitle();
        String is_title = articleService.findisExistTitleByTitle(title);
        if(is_title!=null){
            msg="已经存在文章标题，请修改文章标题";
        }else if(article.getTitle().length()<=0){
            msg="文章标题不能为空";
        }else if(article.getIsOriginal()!=0&article.getIsOriginal()!=1){
            msg="请输入正确的文章标签：0.原创，1.非原创";
        }else{
            Long createTime =new Date().getTime();
            Long updateTime =new Date().getTime();
            article.setCreateTime(createTime);
            article.setUpdateTime(updateTime);
            article.setUid(user.getId());
            article.setBrowseNums(0);
            articleService.saveArticle(article);
            //用户文章数加一,更新session中的user
            String username = user.getUsername();
            userService.updateArticleNumsbyUserName(username);
            userService.findUserByUserName(username);
            session.setAttribute("user",userService.findUserByUserName(username));
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
            articleService.updateArticleBrowseNumsByTitle(title);

        }
        return "article/article";
    }
    @PostMapping("articleImg")
    public String uploadArticleImg(@RequestParam("file") MultipartFile file, HttpServletRequest request,Model model){
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        String filePath = "C:\\Users\\asus\\Desktop\\new_myblog\\src\\main\\resources\\static\\images\\";
        String s =null;
        try {
            FileUtils.uploadFile(file.getBytes(), filePath, fileName);
            s ="success";
        } catch (Exception e) {
            s="err";
            // TODO: handle exception
        }
        String imgTxt = BaiduApiUtil.imageToTxt( filePath,fileName);
        model.addAttribute("imgTxt",imgTxt);
        return  "article/wirter";
    }
}
