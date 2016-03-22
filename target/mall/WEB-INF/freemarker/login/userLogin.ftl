<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登陆</title>
</head>
<body>
<p><#if message??>${message}<#else></#if></p>
<form action="/mall/main/userLogin" method="post">
<p>name:<input type="text" name="name"/></p>
<p>password:<input type="password" name="password"/></p>
<input type="submit" value="Submit"/>
<a href="/mall/UserSignUp.html" >sign up</a>
</html>