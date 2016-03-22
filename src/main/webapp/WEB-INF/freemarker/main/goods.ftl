<!DOCTYPE html>
<html lang="en-US">
<head>
<meta charset="UTF-8"/>
<title>Goods List</title>
</head>
<body>
<p><#if message??>${message}<#else></#if></p>
<p>we have these goods:</p>
<table border=1>
<#list goodsList as goods>
<tr><td>${goods.id}</td><td>${goods.name}</td><td>${goods.description}</td><td>${goods.point}</td>
<td><form action="/mall/main/logined/buy" method="post">
<button type="submit" name="goodsId" value=${goods.id}>buy</button>
</form>
</td></tr>
</#list>
</table>
</html>