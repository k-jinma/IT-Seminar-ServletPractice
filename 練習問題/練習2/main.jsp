<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>メイン画面</title>
</head>
<body>
	<h1>メインページ</h1>
	<p><%= request.getAttribute("name") %>さん、こんにちは
</body>
</html>