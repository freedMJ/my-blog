package com.lmj.service.article;

import com.lmj.model.Article;
import com.lmj.model.ArticleInfo;

import java.util.List;

public interface IArticleService {
    //保存文件
    void saveArticle(Article article);
    //查询所有文章详情
    List<ArticleInfo> findAllArticleInfo();
}
