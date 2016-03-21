<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager</title>
</head>
<body>
<#escape x as x!"null">
<p>we have these published goods:</p>
<table border=1>
<#list goodsList as goods>
<tr><td>${goods.id}</td><td>${goods.name}</td><td>${goods.description}</td><td>${goods.point}</td>
<td>${goods.published?string('published','not')}</td></tr>
</#list>
</table>

<p>we have these delete goods:</p>
<table border=1>
<#list delete as goods>
<tr><td>${goods.id}</td><td>${goods.name}</td><td>${goods.description}</td><td>${goods.point}</td>
<td>${goods.published?string('published','not')}</td></tr>
</#list>
</table>

<p>we have these notpublished goods:</p>
<table border=1>
<#list goodsNotPublishedList as goods>
<tr><td>${goods.id}</td><td>${goods.name}</td><td>${goods.description}</td><td>${goods.point}</td>
<td>${goods.published?string('published','notpublished')}</td>
<td><form action="/mall/main/published" method="post">
<button type="submit" name="id" value=${goods.id}>published</button>
</form>
</td>
<td>
<form action="/mall/main/deleteGoods" method="post">
<button type="submit" name="id" value=${goods.id}>delete</button>
</form>
</td>
</tr>
</#list>
</table>

<p>add goods</p>
<form action="/mall/main/addGoods" method="post">
<table border=1>
<tr><td>name:<input type="text" name="goodsName"/></td><td>description:<input type="text" name="description"/>
</td><td>point:<input type="text" name="point"/></td></tr>
</table>
<input type="submit" value="Submit"/>

<p>we have these code:</p>
<table border=1>
<#list codeList as code>
<tr><td>${code.id}</td><td>${code.userName}</td><td>${code.goodsId}</td><td>${code.code}</td>
<td><#if code.exchangeTime??>${code.exchangeTime?string("yyyy-MM-dd HH:mm:ss")}><#else>null</#if></td><td>${code.exchanged?string('true','false')}</td></tr>
</#list>
</table>
</#escape>
</body>
</html>