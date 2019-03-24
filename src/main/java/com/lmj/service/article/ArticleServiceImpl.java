package com.lmj.service.article;

import com.github.pagehelper.PageHelper;
import com.lmj.mapper.article.ArticleMapper;
import com.lmj.model.Article;
import com.lmj.model.ArticleInfo;
import com.lmj.model.User;
import com.lmj.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    //pagehelper分页
    @Override
    public List<ArticleInfo> findArticleInfoPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ArticleInfo> allItems = articleMapper.findArticleInfoPage();
        int countNums = articleMapper.countItem();//总记录数
        PageBean<ArticleInfo> pageData = new PageBean<ArticleInfo>(pageNum, pageSize, countNums);
        pageData.setItems(allItems);
        return pageData.getItems();

    }

    //根据uid查找用户信息
    @Override
    public User findUserByUid(Integer uid) {
        return articleMapper.findUserByUid(uid);
    }
    //查询该用户的所有文章
    @Override
    public List<Article> findUserAllArticleByUid(Integer uid) {
        return articleMapper.findUserAllArticleByUid(uid);
    }

    //pageHelper分页查询该用户的所有文章
    @Override
    public List<Article> findUserAllArticleByUidPage(int uid,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Article> allArticle = articleMapper.findUserAllArticleByUid(uid);
        int articleCountNums = articleMapper.userAllArticleCountItme(uid);
        PageBean<Article> pageData = new PageBean<Article>(pageNum,pageSize,articleCountNums);
        pageData.setItems(allArticle);
        return pageData.getItems();
    }
//    @Override
// 2     public List<Item> findItemByPage(int currentPage,int pageSize) {
//        3         //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
//        4         PageHelper.startPage(currentPage, pageSize);
//        5
//        6         List<Item> allItems = itemMapper.findAll();        //全部商品
//        7         int countNums = itemMapper.countItem();            //总记录数
//        8         PageBean<Item> pageData = new PageBean<>(currentPage, pageSize, countNums);
//        9         pageData.setItems(allItems);
//        10         return pageData.getItems();
//        11     }


}
