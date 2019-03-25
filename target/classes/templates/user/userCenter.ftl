<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>个人中心</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <h1 id="head_title" style="text-align: center;">个人博客</h1><br>
  <a href="${request.contextPath}/user/index" style="margin-left: 1100px">返回首页</a>&nbsp&nbsp&nbsp&nbsp&nbsp
  <a href="${request.contextPath}/user/userInfo">个人资料</a>
  <div>
    <h2>个人中心：</h2>
    <#if Session["user"]??>
     用户头像<img src="../images/298955724.jpeg" alt="..." class="img-circle" style="border:2px solid black;"><br><br>
     用户名：<span style="font-family:verdana;font-size:80%;color:green">${Session.user.username}</span><br><br>
     个性签名:<span style="font-family:verdana;font-size:80%;color:green">
      <#if Session.user.userSign??>
        ${Session.user.userSign}
        <#else >
        未编辑
      </#if>

    </span><br><br>

     发布文章数:
      <#if Session.user.articleNums??>
        ${Session.user.articleNums}
        <#else >
          未上传文章
      </#if>

    </#if>
    <br><br>
    <a href="${request.contextPath}/article/uploadArticle">上传文件</a><br>
     文章列表：
     <table class="table table-striped">
    <tr>
    <td>#</td>
    <td>文章标题</td>
    <td>标签</td>
      <td>关键字</td>
    <td>发布时间</td>
      <td>更新时间</td>
    <td>浏览量</td>
    <td>管理</td>
    </tr>
       <#if pageList??>
         <#list pageList as article>
           <tr>
             <td>${(pageNum-1)*pageSize+(article ?index+1)}</td>
             <td><a href="${request.contextPath}/article/findArticle?title=${article.title}">${article.title}</a></td>
             <td>
               <#if article.isOriginal==0>
                 原创
               <#else >
                 非原创
               </#if>
             </td>
             <td>${article.keyWord}</td>
             <td>
               ${(article.createTime)?number_to_datetime}</td>
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
               <#else>
                 无
               </#if>
             </td>
               <td>
                   <a href="${request.contextPath}/user/updateArticle?id=${article.id}">修改</a>
                   <a href="${request.contextPath}/user/delArticle?title=${article.title}">删除</a>
               </td>
           </tr>
         </#list>
       </#if>
</table>

    <nav aria-label="Page navigation">

      <ul class="pagination">
        <#if pageNum??>
          <#if pageNum gt 1><!--如果有上一页-->
            <li>
              <a href="${request.contextPath}/user/userCenter?pageNum=${pageNum-1}" aria-label="Previous">
                <span aria-hidden="true">上一页</span>
              </a>
            </li>
          </#if>
          <#if nums??>
            <#list nums as num>
              <#if pageNum == num>
                <li class="active"><a href="${request.contextPath}/user/userCenter?pageNum=${pageNum}">${pageNum}</a></li>
              <#else >
                <li><a href="${request.contextPath}/user/userCenter?pageNum=${num}">${num}</a></li>
              </#if>

            </#list>
          </#if>
          <!---->
          <#if pageNum lt pages >
            <li>
              <a href="${request.contextPath}/user/userCenter?pageNum=${pageNum+1}" aria-label="Next">
                <span aria-hidden="true">下一页</span>
              </a>
            </li>
          </#if>
        </#if>
      </ul>
    </nav>
     </div>

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
  </body>
</html>