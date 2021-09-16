<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<style>
	body{
		background-color: <%=request.getParameter("color") %>;
	}
</style>
<title>様々なフォーム利用</title>
</head>
<body>
	<header><h1>アンケート結果</h1></header>
	<main>
		<p><%=request.getAttribute("message") %></p>
		<p>ご協力、有難うございました。</p>
	</main>
</body>
</html>