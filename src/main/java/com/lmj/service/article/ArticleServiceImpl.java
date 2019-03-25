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
    //根据文章标题得到文章详情
    @Override
    public ArticleInfo findArticleInfoByTitle(String title) {
        return articleMapper.findArticleInfoByTitle(title);
    }
    //访问文章根据文章标题浏览量加一
    @Override
    public void updateArticleBrowseNumsByTitle(String title) {
        articleMapper.updateArticleBrowseNumsByTitle(title);
    }
    //根据文章标题查找文章标题是否存在
    @Override
    public String findisExistTitleByTitle(String title) {
        return articleMapper.findisExistTitleByTitle(title);
    }


    //pageHelper分页查询首页条件搜索文章
    //首页搜索文章列表功能
//    @Override
//    public ArticleInfo findIndexAllArticle(String username, String keyWord, String title, int isOriginal) {
//        return articleMapper.findIndexAllArticle(username, keyWord, title, isOriginal);
//    }
//
//    @Override
//    public int indexCountItem(String username, String keyWord, String title, int isOriginal) {
//        return articleMapper.indexCountItem(username, keyWord, title, isOriginal);
//    }
    //pageHelper分页查询该用户的所有文章
    @Override
    public List<ArticleInfo> findIndexAllArticle(String username, String keyWord, String title, int isOriginal,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ArticleInfo> allArticle = articleMapper.findIndexAllArticle(username, keyWord, title, isOriginal);
        int articleCountNums = articleMapper.indexCountItem(username, keyWord, title, isOriginal);
        PageBean<ArticleInfo> pageData = new PageBean<ArticleInfo>(pageNum,pageSize,articleCountNums);
        pageData.setItems(allArticle);
        return pageData.getItems();
    }
    //根据文章标题删除文章记录
    @Override
    public void delArticleByTitle(String title) {
        articleMapper.delArticleByTitle(title);
    }
    //根据文章标题修改文章
    @Override
    public Article findArticleById(int id) {
        return articleMapper.findArticleById(id);
    }

    @Override
    public  void updateUpdateArticleById(Long updateTime,String title, String keyWord,String text,int isOriginal,int id){
        articleMapper.updateUpdateArticleById(updateTime, title, keyWord, text, isOriginal,id);
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
