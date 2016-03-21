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
<tr><th>id</th><th>name</th><th>description</th><th>point</th><th>publishe</th><th>operation</th><tr>
<#list goodsList as goods>
<tr><td>${goods.id}</td><td>${goods.name}</td><td>${goods.description}</td><td>${goods.point}</td>
<td>${goods.published?string('published','not')}</td>
<td><form action="/mall/main/getBackGoods" method="post">
<button type="submit" name="id" value=${goods.id}>taken off</button>
</form></tr></tr>
</#list>
</table>

<p>we have these delete goods:</p>
<table border=1>
<tr><th>id</th><th>name</th><th>description</th><th>point</th><th>publishe</th><th>operation</th><tr>
<#list delete as goods>
<tr><td>${goods.id}</td><td>${goods.name}</td><td>${goods.description}</td><td>${goods.point}</td>
<td>${goods.published?string('published','notpublished')}</td>
<td><form action="/mall/main/getBackGoods" method="post">
<button type="submit" name="id" value=${goods.id}>get back</button>
</form></tr>
</#list>
</table>

<p>we have these notpublished goods:</p>
<table border=1>
<tr><th>id</th><th>name</th><th>description</th><th>point</th><th>publishe</th><th>operation1</th><th>operation2</th><tr>
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
<input type="submit" value="add" name="goods"/>
</form>

<p>we have these code:</p>
<table border=1>
<tr><th>id</th><th>userName</th><th>goodsId</th><th>code</th><th>exchangeTime</th><th>exchanged</th><tr>
<#list codeList as code>
<tr><td>${code.id}</td><td>${code.userName}</td><td>${code.goodsId}</td><td>${code.code}</td>
<td><#if code.exchangeTime??>${code.exchangeTime?string("yyyy-MM-dd HH:mm:ss")}><#else>null</#if></td>
<td>${code.exchanged?string('true','false')}</td></tr>
</#list>
</table>

<p>add goods cods:</p>
<form action="/mall/main/addGoodsCode" method="post">
<p>good id:<input type="text" name="goodsId"/></p>
<input type="submit" value="addcode" name="code"/>
</form>
</#escape>
</body>
</html>