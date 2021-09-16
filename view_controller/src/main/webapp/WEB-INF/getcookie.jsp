<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Cookieの取得</title>
</head>
<body>
	<header>
		<%
			//デコードされたクッキーを取り出す
			String cookieValue = (String) request.getAttribute("cookieValue");
			if( cookieValue != null ){
		%>
		<h1><%=cookieValue%>様、こんにちは。</h1>
		<%
			}
		%>
	</header>
	<main>
		<p><%=request.getAttribute("message") %></p>
		<form action="cookie" method="post">
			<input type="text" name="name">
			<input type="submit" value="Cookieを発行">
		</form>
	</main>
</body>
</html>