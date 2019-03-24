<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>文章详情</title>

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
  <div>
    <a href="${request.contextPath}/user/index" style="margin-left: 100px">返回首页</a>
    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
   <#if articleInfo??>
    <span class="label label-default">${articleInfo.keyWord}</span><!--关键字-->
   <span class="label label-primary">${articleInfo.updateTime}</span><!--最后更新时间-->
  <span class="label label-success">
      <#if articleInfo.title??>
          ${articleInfo.title}
      </#if>

  </span><!--标题-->
  <span class="label label-info">访问量
      <#if articleInfo.browseNums??>
          ${articleInfo.browseNums}
          <#else >
              无
      </#if>

  </span><!--访问量-->
      <span class="label label-warning">
          <#if articleInfo.isOriginal??>
              <#if articleInfo.isOriginal==0>
                  原创
              <#else >
                  非原创
              </#if>
          </#if>

      </span><!--是否原创-->
  <span class="label label-info">
      <#if articleInfo.username??>
          ${articleInfo.username}
      </#if>
  </span>
      <!--作者-->
    <#if Session["user"]??>
    <img src="../images/298955724.jpeg" alt="..." class="img-circle" style="border:2px solid black;margin-left: 400px">
     用户名：${Session.user.username}
        <#else >
            <a href="${request.contextPath}/register">注册</a>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="login.ftl" style="left: 1128px">登录</a>
  </#if>
  </div>
     <!--标题-->
     <h1 style="text-align: center;">
         <#if articleInfo.title??>
             ${articleInfo.title}
         </#if>
     </h1>
     <span style="margin-left: 900px">作者：
         <#if articleInfo.username??>
             ${articleInfo.username}
         </#if>
     </span>
     <div style="width: 600px;margin-left: 450px">
         <#if articleInfo.text??>
             ${articleInfo.text}
         </#if>

     </div>
  </#if>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
  </body>
</html>