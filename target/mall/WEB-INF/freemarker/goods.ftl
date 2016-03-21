<!DOCTYPE html>
<html lang="en-US">
<head>
<meta charset="UTF-8"/>
<title>商品列表</title>
</head>
<body>
<p>we have these goods:</p>
<table border=1>
<#list goodsList as goods>
<tr><td>${goods.id}</td><td>${goods.name}</td><td>${goods.description}</td><td>${goods.point}</td></tr>
</#list>
</table>
<form action="/mall/main/buy" method="post">
<p>id:<input type="text" name="goodsId"/></p>
<input type="submit" value="Submit"/>
</body>
</html>