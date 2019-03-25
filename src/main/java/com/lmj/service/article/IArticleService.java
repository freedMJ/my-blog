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
    //根据文章标题得到文章详情
    ArticleInfo findArticleInfoByTitle(String title);
    //访问文章根据文章标题浏览量加一
   void updateArticleBrowseNumsByTitle(String title);
    //根据文章标题查找文章标题是否存在
    String findisExistTitleByTitle(String title);

    List<ArticleInfo> findIndexAllArticle(String username, String keyWord, String title, int isOriginal,int pageNum,int pageSize);
//    //首页搜索文章列表功能
//    ArticleInfo findIndexAllArticle(String username, String keyWord, String title,int isOriginal );
//    //首页搜索文章总记录数
//    int indexCountItem(String username,String keyWord, String title,int isOriginal );
}
