package com.lmj.model;

public class Article {
    private String title;//文章标题
    private String keyWord;//关键字：Java，python，生活，感悟，
    private  Integer isOriginal;//0.原创,1.非原创 标签
    private Long createTime;//创建时间
    private Long updateTime;//更新时间
    private String text;//正文
    private Integer browseNums;//浏览量
    private Integer uid ;//用户id

    public Article() {
    }

    public Article(String title, String keyWord, Integer isOriginal, Long createTime, Long updateTime, String text, Integer browseNums, Integer uid) {
        this.title = title;
        this.keyWord = keyWord;
        this.isOriginal = isOriginal;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.text = text;
        this.browseNums = browseNums;
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Integer getIsOriginal() {
        return isOriginal;
    }

    public void setIsOriginal(Integer isOriginal) {
        this.isOriginal = isOriginal;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getBrowseNums() {
        return browseNums;
    }

    public void setBrowseNums(Integer browseNums) {
        this.browseNums = browseNums;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", keyWord='" + keyWord + '\'' +
                ", isOriginal=" + isOriginal +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", text='" + text + '\'' +
                ", browseNums=" + browseNums +
                ", uid=" + uid +
                '}';
    }
}
