<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户详细信息</title>

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
  <a href="index.ftl" style="margin-left: 900px">返回首页</a>
    
    <div style="width: 600px;height: 800px" id="registerDIV">
      <h1>用户详细信息</h1>
    <#if Session["user"]??>
    <table class="table table-bordered">
      <tr>
        <td>#</td>
        <td>详细信息</td>
        <td>是否修改</td>
      </tr>
       <tr>
        <td>用户名</td>
        <td>
            <#if Session.user.username??>
            ${Session.user.username}
                <#else >
                无用户名
            </#if>
        </td>
        <td>不可修改</td>
      </tr>
        <form action="%{request.contextPath}/user/updateUserPassword" method="post">
       <tr>
        <td>密码</td>
        <td>
                <input type="password" name="password" value="
            <#if Session.user.password??>
            ${Session.user.password}
                <#else >
                无密码
            </#if>
            "/>
        </td>
        <td><button>修改</button></td>
      </tr>
        </form>
        <#if updatePassword??>
            <spen style="color: green">${updatePassword}</spen>
        </#if>
        <#if errUpdatePassword??>
            <spen style="color: red">${errUpdatePassword}</spen>
        </#if>
        <form action="%{request.contextPath}/user/updateUserEmail" method="post">
       <tr>
           <td>邮箱地址</td>
        <td>
            <input type="email" name="email" value="
            <#if Session.user.email??>
                ${Session.user.email}
            <#else >
                未设置电子邮箱
            </#if>
            ">
            </td>
        <td><button>修改</button></td>
      </tr>
        </form>
        <#if updateEmail??>
            <spen style="color: green">${updateEmail}</spen>
        </#if>
        <form action="%{request.contextPath}/user/updateUserPhoneNum" method="post">
       <tr>
        <td>电话</td>
        <td>
            <input type="text" style="text-align:left;width: 180px" name="phoneNum" value="
            <#if Session.user.phoneNum??>
                ${Session.user.phoneNum}
                <#else >
                未设置电话号码
            </#if>
            ">
            </td>
        <td><button>修改</button></td>
      </tr>
        </form>
        <#if updatePhoneNum??>
            <spen style="color: green">${updatePhoneNum}</spen>
        </#if>
        <form action="%{request.contextPath}/user/updateUserRelName" method="post">
      <tr>
        <td>真实姓名</td>
        <td>
            <input type="text"  style="text-align:left;width: 180px" name="relName" value="
            <#if Session.user.relName??>
                ${Session.user.relName}
                <#else >
                未实名认证
            </#if>
            ">
           </td>
        <td><button>修改</button></td>
      </tr>
        </form>
        <#if updateRelName??>
            <spen style="color: green">${updateRelName}</spen>
        </#if>

        <form action="%{request.contextPath}/user/updateUserSign" method="post">
      <tr>
        <td>个人签名</td>
        <td>
            <input type="text" style="text-align:left;width: 180px" name="userSign" value="
            <#if Session.user.userSign??>
                ${Session.user.userSign}
                <#else >
                未设置个人签名
            </#if>
            ">
            </td>
        <td><button>修改</button></td>
      </tr>
        </form>
        <#if updateUserSign??>
            <spen style="color: green">${updateUserSign}</spen>
        </#if>
      <#--&lt;#&ndash;<tr>&ndash;&gt;??????-->
        <tr>
        <td>头像</td>
        <td><img src="%{request.contextPath}/images/298955724.jpeg" alt="..." class="img-circle" style="border:2px solid black;text-align: center;"></td>
        <td><button>修改</button></td>
      </tr>
        <td>发表文章数</td>
        <td>
            <#if Session.user.articleNums??>
                ${Session.user.articleNums}
                <#else>
                0
            </#if>
            </td>
        <td>不可修改</td>
      </tr>
</table>
    </#if>
    </div>

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
  </body>
</html>