<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>首页</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
      <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
      <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
      <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
      <script src="../js/jquery.pagination.js"></script>
      <link rel="stylesheet" href="../css/pagination.css">
    <style type="text/css">
      #form{
        text-align:center;
      }
      a{ 
    text-decoration:none ;
    color:black ; 
}
    </style>
      <#--分页代码-->
      <script>
          $(function () {
              $.ajax({
                  url:'${request.contextPath}/user/allArticleInfo',
                  type:'POST',
                  dataType: 'JSON',
                  data:{
                  },
                  success:function(data){
                      //返回条数
                      console.log(data)
                      console.log(data.numberOfElements);
                      //总条数
                      console.log(data.totalElements);
                      //总页码
                      console.log(data.totalPages);

                      // $('.M-box').pagination({
                      //     pageCount:data.totalPages,   //总页码
                      //     coping:true,                 //是否开启首页和末页
                      //     homePage:'首页',
                      //     endPage:'末页',
                      //     prevContent:'上页',
                      //     nextContent:'下页',
                      //     current:1,                    //当前页码
                      //     callback:function (api) {     //这是一个回调函数
                      //
                      //     }
                      // });
                  }
              }
          )})

      </script>
  </head>
  <body>
    <h1 id="head_title" style="text-align: center;">个人博客</h1><br>
    
   <form class="form-inline" id="form">
    <div style="width:1400px;left: 100px ">
  <div class="form-group">
    <label for="exampleInputName2">作者</label>
    <input type="text" class="form-control" id="author" placeholder="文章作者或上传用户">
  </div>
  <div class="form-group">
    <label for="exampleInputName2">关键词</label>
    <input type="text" class="form-control" id="keyword" placeholder="标题关键字">
  </div>
  <div class="form-group">
    <label for="exampleInputName2">标签</label>
    <input type="text" class="form-control" id="title" placeholder="文章分类">
  </div>
  <div class="form-group">
    <label for="exampleInputName2">发布时间</label>
    <input type="text" class="form-control" id="title" placeholder="xxxx-xx-xx xx:xx:xx">
  </div>
  <button type="submit" class="btn btn-default">搜索</button>
    </div>
   </form>
  <div style="float: right;">

      <#if isLogin="isSuccess">
        <img src="../images/298955724.jpeg" alt="..." class="img-circle" style="border:2px solid black;margin-left: 400px" >
       <a href="${request.contextPath}/user/userCenter">欢迎你：${user.username}</a>&nbsp&nbsp&nbsp&nbsp
        <a href="${request.contextPath}/user/quit">退出</a>
        <#else >
          <a href="${request.contextPath}/register">注册</a>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="login.ftl" style="left: 1128px">登录</a>
      </#if>
  </div>
    <div>
    <ul class="nav nav-tabs">
        <li role="presentation" class="active"><a href="${request.contextPath}/user/index">首页</a></li>
        <li role="presentation"><a href="${request.contextPath}/user/userCenter">个人中心</a></li>
    </ul>
<table class="table table-striped">

    <tr>
    <td>#</td>
    <td>作者</td>
    <td >文章标题</td>
    <td>标签</td>
    <td>发布时间</td>
        <td>更新时间</td>
    <td>浏览量</td>

    </tr>
    <tr>
    <td>1</td>
    <td><a href="${request.contextPath}/user/findAuthor">lmj</a></td>
    <td><a href="${request.contextPath}/user/findArticle">逍遥游</a></td>
    <td>xxx</td>
    <td>xxx<</td>
        <td>xxx<</td>
    <td>1000000</td>
    </tr>
</table>
        <div class="M-box"></div>
    </div>
  

  </body>
</html>