package com.lmj.model;

public class User {
    private Integer id;
    private  String username;//用户名
    private String password;//用户密码
    private String email;//邮箱
    private String relName;//真实姓名
    private String userSign;//个人签名
    private String headPhoto;//用户头像
    private Integer articleNums;//发布文章数量
    private String phoneNum;//电话号码

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", relName='" + relName + '\'' +
                ", userSign='" + userSign + '\'' +
                ", headPhoto='" + headPhoto + '\'' +
                ", articleNums=" + articleNums +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }

    public User(Integer id, String username, String password, String email, String relName, String userSign, String headPhoto, Integer articleNums, String phoneNum) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.relName = relName;
        this.userSign = userSign;
        this.headPhoto = headPhoto;
        this.articleNums = articleNums;
        this.phoneNum = phoneNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRelName() {
        return relName;
    }

    public void setRelName(String relName) {
        this.relName = relName;
    }

    public String getUserSign() {
        return userSign;
    }

    public void setUserSign(String userSign) {
        this.userSign = userSign;
    }

    public String getHeadPhoto() {
        return headPhoto;
    }

    public void setHeadPhoto(String headPhoto) {
        this.headPhoto = headPhoto;
    }

    public Integer getArticleNums() {
        return articleNums;
    }

    public void setArticleNums(Integer articleNums) {
        this.articleNums = articleNums;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
