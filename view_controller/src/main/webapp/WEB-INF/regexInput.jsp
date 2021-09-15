<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>正規表現</title>
</head>
<body>
	<header><h1>正規表現</h1></header>
	<main>
		<p><%= request.getAttribute("message") %></p>
		<form action="regex" method="post">
			郵便番号：<input type="text" name="zip" placeholder="例：000-0000"><br>
			<input type="submit" value="登録">
		</form>
	</main>
</body>
</html>