<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"  %>
<%@page import="model.Item"  %>

 <%
 	ArrayList<Item>items = (ArrayList<Item>)request.getAttribute("items");
 %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>商品一覧</title>
</head>
<body>
	<table border="1">
	<tr>
		<th>NO</th><th>イメージ</th><th>品名</th><th>値段</th><th>説明</th><th>数量</th>
	</tr>
	<%
		for( Item i : items ){
	%>
			<tr>
				<td><%= i.getNo() %></td>
				<td><img src="img/<%= i.getFname() %>" width="200" height="150" alt="<%= i.getName() %>"></td>
				<td><%= i.getName() %></td>
				<td><%= i.getPrice() %>円</td>
				<td><%= i.getDetail() %></td>
				<td>
						<form action="item" method="get">
							<input type="text" name="count">個
							<input type="hidden" name="no" value="<%= i.getNo() %>">
						</form>
				</td>
			</tr>
	<%
		}
	%>
	</table>

</body>
</html>