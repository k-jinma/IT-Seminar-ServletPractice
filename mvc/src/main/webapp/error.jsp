<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<style>
	.message {
		color: #800000;
	}
</style>
<title>従業員検索ページ</title>
</head>
<body>
	<header><h1>エラーページ</h1></header>
	<main>
		<p class="message"><c:out value="${errorMessage}"/></p>
		<a href="controller">戻る</a>
	</main>
</body>
</html>