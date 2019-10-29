<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/image/ico.png" type="image/x-icon">
 
  <title>登录|注册</title>
</head>
<body>
  <header class="clearfix">
    <div class="bar clearfix">
      <span class="logintext">SignIN / SignUP</span>
      <a class="login" href="#"><i class="fa fa-user-circle"></i></a>
    </div>
  </header>
  <main>
    <div class="flip-modal login">
      <!-- 登录模块 -->
      <div class="modal modal-login">
        <a class="close "href="#"><i class="fa fa-close"></i></a>
        <div class="tabs">
          <a class="login active" href="#">登录</a>
          <a class="register" href="#">注册</a>
        </div>
        <div class="content">
          <div class="errormsg"></div>
          <form action="${pageContext.request.contextPath}/ReaderLoginAndRegisterAction" method="post">
            <div class="input-field">
              <i class="fa fa-user-o"></i>
              <input name="username" type="text" placeholder="用户名">
            </div>
            <div class="input-field">
              <i class="fa fa-lock"></i>
              <input name="password" type="password" placeholder="密码">
              <i class="fa fa-eye showpassword"></i>
            </div>
            <div class="input-field">
              <input type="submit" value="登录">
            </div>
          </form>
        </div>
      </div>
      <!-- 注册模块 -->
      <div class="modal modal-register">
        <a class="close" href="#"><i class="fa fa-close"></i></a>
        <div class="tabs">
          <a class="login" href="#">登录</a>
          <a class="register active" href="#">注册</a>
        </div>
        <div class="content">
          <div class="errormsg"></div>
          <form action="${pageContext.request.contextPath}/RegisterAction" method="post">
            <div class="input-field">
              <i class="fa fa-user-o"></i>
              <input name="username" type="text" placeholder="输入用户名">
            </div>
            <div class="input-field">
              <i class="fa fa-lock"></i>
              <input name="password" type="password" placeholder="输入密码">
              <i class="fa fa-eye showpassword"></i>
            </div>
            <div class="input-field">
              <i class="fa fa-lock"></i>
              <input name="password2" type="password" placeholder="再次输入密码">
              <i class="fa fa-eye showpassword2"></i>
            </div>
            <div class="input-field">
              <input type="submit" value="注册">
            </div>
          </form>
        </div>
      </div>
    </div>
  </main>
</body>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath}/js/main.js"></script>
</html>


