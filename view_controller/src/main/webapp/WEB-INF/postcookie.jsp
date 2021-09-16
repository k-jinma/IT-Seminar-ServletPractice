<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Cookieの発行</title>
</head>
<body>
	<header>
		<%
			String name = (String)request.getAttribute("name");
			if( name != null ){
		%>
			<h1><%=name %>様、Cookieを発行しました。</h1>
		<%
			}
		%>
	</header>
	<main>
		<p><%=request.getAttribute("message")  %></p>
		<p><a href="cookie">戻る</a></p>
	</main>
</body>
</html>