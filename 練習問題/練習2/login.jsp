<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// ユーザー名にエラーがある場合はエラーメッセージが設定済。そうでない場合はNULL
	String err_msg1 = (String)request.getAttribute("err_msg1");

	// パスワードにエラーがある場合はエラーメッセージが設定済。そうでない場合はNULL
	String err_msg2 = (String)request.getAttribute("err_msg2");

	// ユーザー名とパスワードが一致しない場合はエラーメッセージが設定済。そうでない場合はNULL
	String err = (String)request.getAttribute("err");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<style>
	.err {
		color: red;
	}
</style>
</head>
<body>
	<form action="login" method="post">
		<p>
			ユーザー名：<input type="text" name="name">
			<%
				// ユーザー名の入力にエラーがある場合のみエラーメッセージを表示する
				if( err_msg1 != null ){
					out.println( "<label class=\"err\">" + err_msg1 + "</label>" );
				}
			%>
		</p>
		<p>
			パスワード：<input type="password" name="password">
			<%
				// パスワードの入力にエラーがある場合のみエラーメッセージを表示する
				if( err_msg2 != null ){
					out.println( "<label class=\"err\">" + err_msg2 + "</label>" );
				}
			%>
		</p>
		<p>
			<input type="submit" value="ログイン">
		</p>
		<%
			// ユーザー名、パスワードに入力エラーがなく、かつ、ユーザー名＆パスワードの不一致の際にエラーを表示する
			if(  err_msg1 == null && err_msg2 == null && err != null  ){
				out.println("<label class=\"err\">" + "ユーザ名かパスワードが間違っています。" + "</label>");
			}
		%>
	</form>
</body>
</html>