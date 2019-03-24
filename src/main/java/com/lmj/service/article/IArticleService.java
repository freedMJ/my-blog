package com.lmj.service.article;

import com.lmj.model.Article;
import com.lmj.model.ArticleInfo;
import com.lmj.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IArticleService {
    //保存文件
    void saveArticle(Article article);
    //查询所有文章详情
    List<ArticleInfo> findAllArticleInfo();
    //pagehelper分页
    List<ArticleInfo> findArticleInfoPage(int pageNum,int pageSize);
    //根据uid查找用户信息
    User findUserByUid(Integer uid);
    //查询该用户的所有文章
    List<Article> findUserAllArticleByUid(Integer uid);
    //pageHelper分页查询该用户的所有文章
   List<Article> findUserAllArticleByUidPage(int uid,int pageNum,int pageSize);
}
