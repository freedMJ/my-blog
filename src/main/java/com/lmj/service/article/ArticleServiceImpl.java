package com.lmj.service.article;

import com.lmj.mapper.article.ArticleMapper;
import com.lmj.model.Article;
import com.lmj.model.ArticleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public void saveArticle(Article article) {
        articleMapper.saveArticle(article);
    }
    //查询所有文章详情
    @Override
    public List<ArticleInfo> findAllArticleInfo() {
        return articleMapper.findAllArticleInfo();
    }
}
