<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head lang="en">
<title>登陆燃气公司物资管理系统</title>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <meta name="format-detection" content="telephone=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="alternate icon" type="image/png" href="assets/i/favicon.png">
  <link rel="stylesheet" href="assets/css/amazeui.min.css"/>
  <style>
    .header h1 { font-size: 200%; color: #64A600; margin-top: 30px; font-family:KaiTi; }
    .header p { font-size: 14px; color: #64A600; }
    .biz{width: auto;height: auto;}
     body{margin: 0;}
    .biz{position: fixed;right: 0;bottom: 0;min-width: 100%;min-height: 100%;width: auto;height: auto;z-index: -9999;}
     #uname{border-radius: 50px;border: gainsboro;background:transparent;border:1px solid #ffffff;
        color: #ccc;
        font-size: 20px; }
    #password{border-radius: 50px;border: gainsboro;background:transparent;border:1px solid #ffffff;
        color: #ccc;
        font-size: 20px; }
    .am-g{position: relative;
                top:150px;}
    #rem{color: #ccc}
    #den{border-radius: 30px;background-color:transparent;}
    #wanji{border-radius: 30px;background-color:transparent;}

  </style>

</head>
<body>
    <video class="biz" autoplay loop muted style="width: 100%;">

      <source src="assets/i/壁纸.mp4">
    </video>
<div class="am-g">
  <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
    <form method="post" action="Login" class="am-form">
      <input type="text" name="uname" id="uname" placeholder="账户">
      <br>
      <input type="password" name="pwd" id="password" placeholder="密码">
      <br>
      <label for="remember-me">
        <input id="remember-me" type="checkbox"><font id="rem">记住密码</font>
      </label>
      <br />
      <div class="am-cf">
        <input type="submit" name="" value="登 录" id="den" class="am-btn am-btn-primary am-btn-sm am-fl" >
        <input  name="" value="忘记密码 ^_^? " id="wanji" class="am-btn am-btn-default am-btn-sm am-fr" >
      </div>
    </form>
  </div>
</div>
</body>
</html>