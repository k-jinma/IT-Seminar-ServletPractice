<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	private String[] userid = {"jinma","yamada"};
	private String[] password = {"pjinma","pass"};
%>
<%
	String name = request.getParameter("name");
	String pass = request.getParameter("password");

	boolean login = false;
	String message = "不正なアクセスです。";

	if( name != null || pass != null ){
		message = "ユーザー名もしくはパスワードが違います。";
		//ユーザー名とパスワードが一致しているか確認する
		for( int i = 0; i < userid.length; i++ ){
			if( name.equals( userid[i]) && pass.equals( password[i] ) ){
				message = userid[i] + "さん、こんにちは";
				login = true;
				break;
			}
		}
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メインページ</title>
</head>
<body>
	<%
		if( login == true ){
	%>
			<h1>メインページ</h1>
			<p><%= message %></p>
	<%
		}else{
	%>
			<p><%= message %></p>
			<p><a href="login.html">ログインページへ戻る</a></p>
	<%
		}
	%>


</body>
</html>