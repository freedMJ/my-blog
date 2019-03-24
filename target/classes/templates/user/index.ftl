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
          <a href="${request.contextPath}/user/register">注册</a>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="${request.contextPath}/user/login" style="left: 1128px">登录</a>
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
    <#list page as article>
    <tr>
        <td>${(pageNum-1)*pageSize+(article? index+1)}</td>
        <td>
            <!--跳转作者详情-->
            <a href="${request.contextPath}/user/findAuthor?uid=${article.uid}">${article.username}</a>
        </td>
        <td>
            <!--跳转文章详情-->
            <a href="${request.contextPath}/article/findArticle?title=${article.title}">${article.title}</a>
        </td>
        <td>
            <#if article.isOriginal==0>
                原创
                <#else >
                非原创
            </#if>
        </td>
        <td>

            <#if article.createTime??>
                ${(article.createTime)?number_to_datetime}
            <#else >
                无
            </#if>
        </td>
        <td>
            <#if article.updateTime??>
                ${(article.updateTime)?number_to_datetime}
            <#else >
                无
            </#if>

        </td>
        <td>
            <#if article.browseNums??>
                ${article.browseNums}
                <#else >
                无
            </#if>

        </td>
    </tr>
    </#list>
    </div>
</table>
    <nav aria-label="Page navigation">

        <ul class="pagination">
            <#if pageNum gt 1><!--如果有上一页-->
            <li>
                <a href="${request.contextPath}/user/index?pageNum=${pageNum-1}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            </#if>
            <#if nums??>
            <#list nums as num>
                <#if pageNum ==num>
                    <li class="active"><a href="${request.contextPath}/user/index?pageNum=${pageNum}">${pageNum}</a></li>
                    <#else >
                        <li><a href="${request.contextPath}/user/index?pageNum=${num}">${num}</a></li>
                </#if>

            </#list>
            </#if>
            <!---->
            <#if pageNum lt pages >
                <li>
                    <a href="${request.contextPath}/user/index?pageNum=${pageNum+1}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </#if>
        </ul>

    </nav>
  </body>
</html>