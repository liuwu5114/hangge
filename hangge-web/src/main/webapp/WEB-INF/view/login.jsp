<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2021/5/13
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8" />
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="/css/login.css?v=21532 " />
</head>

<body>

<div class="container" id="container">
    <div class="form-container sign-up-container">
        <form action="#">
            <h1>注册</h1>
            <div class="social-container">
                <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
            </div>
            <span>第三方账号注册</span>
            <input type="text" placeholder="名称" />
            <input type="email" placeholder="邮箱" />
            <input type="password" placeholder="密码" />
            <button>注册</button>
        </form>
    </div>
    <div class="form-container sign-in-container">
        <form action="#">
            <h1>登录</h1>
            <div class="social-container">
                <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
            </div>
            <span>第三方账号登录</span>
            <input type="text" name="mobile"  id="mobile" placeholder="用户名" />
            <input type="password" name="passWord" id="passWord" placeholder="密码" />
            <a href="#">忘记密码？</a>
            <button id="btn_login">登录</button>
        </form>
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h1>欢迎回来！</h1>
                <p>请您先登录的个人信息，进行操作。</p>
                <button class="ghost" id="signIn">登录</button>
            </div>
            <div class="overlay-panel overlay-right">
                <h1>你好朋友！</h1>
                <p>输入您的个人信息注册成为会员。</p>
                <button class="ghost" id="signUp">注册</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="/js/login.js?v=20210517"></script>
<script>

</script>
