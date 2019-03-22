<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>注册</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
      #registerDIV{
        margin-left: 400px;
        margin-top: 100px;
      }
    </style>
  </head>
  <body>
  <h1 id="head_title" style="text-align: center;">个人博客</h1><br>
  <a href="${request.contextPath}/user/index" style="margin-left: 900px">返回首页</a>
    
    <div style="width: 600px;height: 800px" id="registerDIV">
      <h1>账号注册</h1>
      <#if errMsg??>
          <h1 style="color: red">${errMsg}</h1>
      </#if>
    <form method="post" action="%{request.contextPath}/user/register">
      <div class="form-group">
    <label for="exampleInputPassword1">账号名称</label>
    <input type="text" class="form-control" id="exampleInputId" placeholder="username" name="username">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">密码</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword2">确认密码</label>
    <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Password" name="relpassword">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">邮箱地址</label>
    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email" name="email">
  </div>
    <div class="form-group">
    <label for="exampleInputPassword1">真实姓名</label>
    <input type="text" class="form-control" id="rename" placeholder="选填" name="relName">
  </div>
    <div class="form-group">
    <label for="exampleInputPassword1">个人签名</label>
    <input type="text" class="form-control" id="qianming" placeholder="选填" name="userSign">
  </div>
  <div class="form-group">
    <label for="exampleInputFile">头像上传</label>
    <input type="file" id="exampleInputFile" name="headPhoto">
    <p class="help-block">jpg,jpge等。。。</p>
  </div>
  
  <button type="submit" class="btn btn-default">注册</button>
</form>
</div>

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
  </body>
</html>