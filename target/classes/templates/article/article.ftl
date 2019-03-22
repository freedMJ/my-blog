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
    <span class="label label-default">历史</span>
   <span class="label label-primary">2019-03-16</span>
  <span class="label label-success">逍遥游</span>
  <span class="label label-info">访问量10000</span>
  <span class="label label-warning">庄子</span>
    <#if Session["user"]??>
    <img src="../images/298955724.jpeg" alt="..." class="img-circle" style="border:2px solid black;margin-left: 400px">
     用户名：${Session.user.username}
        <#else >
            <a href="${request.contextPath}/register">注册</a>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="login.ftl" style="left: 1128px">登录</a>
  </#if>
  </div>
     <!--标题-->
     <h1 style="text-align: center;">逍遥游</h1>
     <span style="margin-left: 900px">作者：庄子</span>
     <div style="width: 600px;margin-left: 450px">
     <p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp北冥有鱼，其名为鲲。鲲之大，不知其几千里也；化而为鸟，其名为鹏。鹏之背，不知其几千里也；怒而飞，其翼若垂天之云。是鸟也，海运则将徙于南冥。南冥者，天池也。《齐谐》者，志怪者也。《谐》之言曰：“鹏之徙于南冥也，水击三千里，抟扶摇而上者九万里，去以六月息者也。”野马也，尘埃也，生物之以息相吹也。</p>
     <p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp天之苍苍，其正色邪？其远而无所至极邪？其视下也，亦若是则已矣。且夫水之积也不厚，则其负大舟也无力。覆杯水于坳堂之上，则芥为之舟，置杯焉则胶，水浅而舟大也。风之积也不厚，则其负大翼也无力。故九万里，则风斯在下矣，而后乃今培风；背负青天，而莫之夭阏者，而后乃今将图南。蜩与学鸠笑之曰：“我决起而飞，抢榆枋而止，时则不至，而控于地而已矣，奚以之九万里而南为？”适莽苍者，三餐而反，腹犹果然；适百里者，宿舂粮；适千里者，三月聚粮。之二虫又何知！</p>
     <p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp小知不及大知，小年不及大年。奚以知其然也？朝菌不知晦朔，蟪蛄不知春秋，此小年也。楚之南有冥灵者，以五百岁为春，五百岁为秋；上古有大椿者，以八千岁为春，八千岁为秋，此大年也。而彭祖乃今以久特闻，众人匹之，不亦悲乎！汤之问棘也是已。</p>
     <p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp穷发之北，有冥海者，天池也。有鱼焉，其广数千里，未有知其修者，其名为鲲。有鸟焉，其名为鹏，背若泰山，翼若垂天之云，抟扶摇羊角而上者九万里，绝云气，负青天，然后图南，且适南冥也。斥鴳笑之曰：“彼且奚适也？我腾跃而上，不过数仞而下，翱翔蓬蒿之间，此亦飞之至也。而彼且奚适也？”此小大之辩也。</p>
     <p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp故夫知效一官，行比一乡，德合一君，而征一国者，其自视也，亦若此矣。而宋荣子犹然笑之。且举世誉之而不加劝，举世非之而不加沮，定乎内外之分，辩乎荣辱之境，斯已矣。彼其于世，未数数然也。虽然，犹有未树也。夫列子御风而行，泠然善也，旬有五日而后反。彼于致福者，未数数然也。此虽免乎行，犹有所待者也。若夫乘天地之正，而御六气之辩，以游无穷者，彼且恶乎待哉？故曰：至人无己，神人无功，圣人无名。</p>
      <p>译文：</p>
      <p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp北方的海里有一条大鱼，名字叫鲲。鲲非常巨大，不知道有几千里长；变化为鸟，名字叫鹏。鹏的脊背，不知道有几千里长；当它振动翅膀奋起直飞的时候，翅膀就好像挂在天边的云彩。这只鸟，大风吹动海水的时候就要迁徙到南方的大海去了。南方的大海，那就是‘天池’。《齐谐》是一部专门记载怪异事情的书，这本书上记载说：“鹏鸟迁徙时，翅膀拍击水面激起三千里的波涛，鹏鸟奋起而飞，旋转扶摇而上直冲九万里高空，此一飞在六个月后方才停歇下来。”像野马奔腾一样的游气，飘飘扬扬的尘埃，仿佛是由生物气息吹拂。</p>
      <p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp我们所见湛蓝的天空，那是它真正的颜色吗？它是无边无际的吗？鹏鸟所见，大概也是这个样子吧。水汇积不深，它浮载大船就没有力量。倒杯水在庭堂的低洼处，可以用芥草作船，而搁个杯子当船就会粘住不动了，因为水太浅而船太大了。风聚积的力量不雄厚，它便无法托负巨大的翅膀。所以，鹏鸟飞到九万里高空，风就在它的身下，然后方能凭借风力飞行，背负着青天，毫无阻挡，这样就能飞到南方了。</p>
      <p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp寒蝉与小灰雀对此觉得很奇怪，它说：“我猛地起飞，力图到达榆树和檀树的树枝，有时飞不到，也就落在地上而已，为什么要到九万里的高空再而向南飞呢？”到近郊去的人，晚餐前就可以返回，肚子还没饿，不需要干粮；到百里之外去，晚上就要准备第二天的干粮；到千里之外去，就需要三个月的时间来准备粮食。寒蝉和灰雀这两个小东西当然不懂得这些道理。</p>
      <p></p>
      <p></p>
      <p></p>
      <p></p>
     </div>

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
  </body>
</html>