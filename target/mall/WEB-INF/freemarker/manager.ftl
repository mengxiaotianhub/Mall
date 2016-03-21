<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理页面</title>
</head>
<body>
<p>we have these goods:</p>
<table border=1>
<#list goodsList as goods>
<tr><td>${goods.id}</td><td>${goods.name}</td><td>${goods.description}</td><td>${goods.point}</td>
<td>${goods.published?string('true','false')}</td></tr>
</#list>
</table>
<p>we have these code:</p>
<table border=1>
<#list codeList as code>
<tr><td>${code.id}</td><td>${code.userName}</td><td>${code.goodsId}</td><td>${code.code}</td>
<td>${code.exchangeTime?string("yyyy-MM-dd HH:mm:ss")}</td><td>${code.exchanged?string('true','false')}</td></tr>
</#list>
</table>
</body>
</html>