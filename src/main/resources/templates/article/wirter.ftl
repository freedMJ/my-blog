<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>文章编写</title>

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
    <script type="text/javascript" src="../js/wangEditor.min.js"></script>
    <script>
        $(function(){
            var E = window.wangEditor;
            var editor = new E('#editor');
            editor.customConfig.zIndex = 100;
            editor.create();
            $("#but").click(function(){

                var text=editor.txt.html()
                var title=$("#title").val();
                var keyWord=$("#keyWord").val();
                var isOriginal=$("#isOriginal").val();
                if(title.length<=0){
                    alert("请输入文章标题")
                }else if(keyWord.length<=0){
                    alert("请输入关键字")
                }else if(isOriginal!=0&isOriginal!=1){
                    alert("请确定是否是原创")
                }else if(text.length<=11){
                    alert("请输入正文内容")
                }else{
                    var jsonData={
                        "title":title,
                        "keyWord":keyWord,
                        "isOriginal":isOriginal,
                        "text":text
                    }
                    $.ajax({
                        type:"post",
                        url:"/article/uploadArticle",
                        data:JSON.stringify(jsonData),
                        dataType:"json",
                        contentType:"application/json",
                        success:function(data){
                            $("#isSuccess").html(data.msg)

                    }
                        }
                    )
                }

            })



        })

    </script>
  </head>
  <body>
    <h1 id="head_title" style="text-align: center;">个人博客</h1><br>
    <a href="${request.contextPath}/user/index" style="margin-left: 50px">返回首页</a>
    <img src="../images/298955724.jpeg" alt="..." class="img-circle" style="border:2px solid black;margin-left: 800px">

    <#if Session["user"]?? >
      用户名：${Session.user.username}

    </#if>
    <h1>文章编写：</h1>

    标题<input type="text" name="title" id="title">
    关键字<input type="text" name="keyWord" id="keyWord">
    标签<select id="isOriginal">
        <option disabled selected="selected">--请选择是否原创--</option>
        <option value="0">原创</option>
        <option value="1">非原创</option>
    </select>
   <button id="but">提交</button>
        <span id="isSuccess" style="color: green"></span>
   </br></br>
     <p>请在下方输入文章正文内容:</p>
    <div id="editor">

    </div>




    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
  </body>
</html>