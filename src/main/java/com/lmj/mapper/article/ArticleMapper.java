package com.lmj.mapper.article;

import com.lmj.model.Article;
import com.lmj.model.ArticleInfo;
import com.lmj.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ArticleMapper {
    //保存文件
    void saveArticle(Article article);
    //查询所有文章详情
    List<ArticleInfo> findAllArticleInfo();
    //pageHelper分页
    List<ArticleInfo> findArticleInfoPage();
    //总记录数
    int countItem();
    //根据uid查找用户信息
    User findUserByUid(Integer uid);
    //查询该用户的所有文章
    List<Article> findUserAllArticleByUid(Integer uid);
    //用户文章总记录数
    int userAllArticleCountItme(Integer uid);
    //根据文章标题得到文章详情
    ArticleInfo findArticleInfoByTitle(String title);
    //更新文章访问量
    void updateArticleBrowseNumsByTitle(String title);
    //根据文章标题查找文章标题是否存在
    String findisExistTitleByTitle(String title);
    //首页搜索文章列表功能
    List<ArticleInfo> findIndexAllArticle(@Param("username") String username,@Param("keyWord") String keyWord, @Param("title") String title,@Param("isOriginal") int isOriginal );
    //首页搜索文章总记录数
    int indexCountItem(@Param("username") String username,@Param("keyWord") String keyWord, @Param("title") String title,@Param("isOriginal") int isOriginal );
}
