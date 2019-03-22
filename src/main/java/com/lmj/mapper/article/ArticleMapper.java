package com.lmj.mapper.article;

import com.lmj.model.Article;
import com.lmj.model.ArticleInfo;

import java.util.List;

public interface ArticleMapper {
    //保存文件
    void saveArticle(Article article);
    //查询所有文章详情
    List<ArticleInfo> findAllArticleInfo();
}
