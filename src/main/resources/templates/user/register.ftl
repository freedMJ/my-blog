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
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
    <style type="text/css">
      #registerDIV{
        margin-left: 400px;
        margin-top: 100px;
      }
    </style>
    <script>
      // 表单校验
      $(function(){

          // var password=$("#password").val();
          // var relpassword=$("#relpassword").val();
          // var email=$("#email").val();
          // var relName=$("#relName").val();
          // var userSign=$("#userSign").val();
          // var phoneNum=$("#phoneNum").val()
          //  username=null;
          //  password=null;
          //  relpassword=null;
          //  email=null
          //  relName=null
          //  userSign=null
          //  phoneNum=null

          // var isUsername=1
          // var isPassword=1
          // var isRelpassword=1
          // var isEmail=1
          // var isPhoneNum=1
          // $("#username").click(function(){
          //     var username=$("#username").val();
          // })
          $("#username").blur(function(){
              username=$("#username").val();
              //判断用户名是否有效
              if(username.length<3){
                  $("#msgUserName").text("用户名必填且长度不小于3个字符")
                  $("#msgUserName").css("color","red")
              }else if(username.length=0){
                  $("#errMsgUserName").text("")
              }else{
                  isUsername=0
                  $("#msgUserName").text("用户名合法")
                  $("#msgUserName").css("color","green")
              }
          })
          $("#password").blur(function(){
               password=$("#password").val();
              //判断密码是否有效
              if(password.length<6){
                  $("#msgPassWord").text("密码必填且长度不小于6个字符")
                  $("#msgPassWord").css("color","red")
              }else if(password.length=0){
                  $("#msgPassWord").text("")
              }else{
                  $("#msgPassWord").text("密码合法")
                  $("#msgPassWord").css("color","green")
                  isPassword=0
              }
          })
          $("#relpassword").blur(function(){
               relpassword=$("#relpassword").val();
              //判断确认密码是否有效
              if(relpassword.length<=0){
                  $("#msgRelPassWord").text("请确认密码")
                  $("#msgRelPassWord").css("color","red")
              }else if(password!=relpassword){
                  alert(password)
                  $("#msgRelPassWord").text("两次密码输入不一致")
                  $("#msgRelPassWord").css("color","red")
              }else if(relpassword.length=0){
                  $("#msgRelPassWord").text("")
              }else{
                  isRelpassword=0
                  $("#msgRelPassWord").text("两次密码一致")
                  $("#msgRelPassWord").css("color","green")

              }
          })
          $("#email").blur(function(){
               email=$("#email").val();
              //判断email是否有效
              if(email.length<=0){
                  $("#msgEmail").text("请输入邮箱")
                  $("#msgEmail").css("color","red")
              }else if(!(/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/).test(email)){
                  $("#msgEmail").text("请输入正确格式的邮箱")
                  $("#msgEmail").css("color","red")
              }else if(email.length=0){
                  $("#msgEmail").text("")
              }else{
                  $("#msgEmail").text("email地址有效")
                  $("#msgEmail").css("color","green")
                  isEmail=0
              }
          })
          $("#phoneNum").blur(function(){  //判断电话是否有效
               phoneNum=$("#phoneNum").val();
              if(phoneNum.length<=0){
                  $("#msgPhoneNum").text("电话号码必填")
                  $("#msgPhoneNum").css("color","red")
              }else if(!(/^1[34578]\d{9}$/.test(phoneNum))){
                  $("#msgPhoneNum").text("请输入正确格式的电话号码")
                  $("#msgPhoneNum").css("color","red")
              }else if(phoneNum.length=0){
                  $("#msgPhoneNum").text("")
              }else{
                  isPhoneNum=0
                  $("#msgPhoneNum").text("电话合法")
                  $("#msgPhoneNum").css("color","green")
              }})
          //获得真实姓名
          $("#relName").blur(function(){
              relName=$("#relName").val();
          })
          //获得签名
          $("#userSign").blur(function(){
              userSign=$("#userSign").val();
          })


      $("#but").click(function() {
        if(isUsername==0&&isPassword==0&&isRelpassword==0&&isEmail==0&&isPhoneNum==0){
              alert("aaaa")
              var jsonData={
                  "username":username,
                  "password":password,
                  "email":email,
                  "relName":relName,
                  "userSign":userSign,
                  "phoneNum":phoneNum
              }
              $.ajax({
                  type:"post",
                  url:"/user/register",
                  dataType:"json",
                  data:JSON.stringify(jsonData),
                  contentType:"application/json",
                  success:function(data){
                      console.log(data)
                      $("#msg").text(data.msg);
                  }
              })
          }

        })
      })

    </script>
  </head>
  <body>
  <h1 id="head_title" style="text-align: center;">个人博客</h1><br>
  <a href="${request.contextPath}/user/index" style="margin-left: 900px">返回首页</a>
    
    <div style="width: 600px;height: 800px" id="registerDIV">
      <h1>账号注册</h1>
          <span style="color: red" id="msg"></span>
      <div class="form-group">
    <label for="exampleInputPassword1">账号名称</label>
    <input type="text" class="form-control" id="username" placeholder="username" name="username">
        <span  id="msgUserName"></span>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">密码</label>
    <input type="password" class="form-control" id="password" placeholder="Password" name="password">
    <span  id="msgPassWord"></span>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword2">确认密码</label>
    <input type="password" class="form-control" id="relpassword" placeholder="Password" name="relpassword">
    <span  id="msgRelPassWord"></span>
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">邮箱地址</label>
    <input type="email" class="form-control" id="email" placeholder="Email" name="email">
    <span  id="msgEmail"></span>
  </div>
    <div class="form-group">
    <label for="exampleInputPassword1">真实姓名</label>
    <input type="text" class="form-control" id="relName" placeholder="选填" name="relName">
      <span  id="msgRelName"></span>
  </div>
    <div class="form-group">
    <label for="exampleInputPassword1">个人签名</label>
    <input type="text" class="form-control" id="userSign" placeholder="选填" name="userSign">
      <span  id="msgUserSign"></span>
  </div>
      <div class="form-group">
        <label for="exampleInputPassword1">电话号码</label>
        <input type="text" class="form-control" id="phoneNum" placeholder="必填" name="phoneNum">
        <span  id="msgPhoneNum"></span>
      </div>
  <#--<div class="form-group">-->
    <#--<label for="exampleInputFile">头像上传</label>-->
    <#--<input type="file" id="exampleInputFile" name="headPhoto">-->
    <#--<p class="help-block">jpg,jpge等。。。</p>-->
  <#--</div>-->
  
  <button type="submit" class="btn btn-default" id="but">注册</button>
</div>


  </body>
</html>