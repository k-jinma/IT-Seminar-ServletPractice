<%@page import="kenmodel.TourBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	TourBean tour = (TourBean)session.getAttribute("tour");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<link rel="stylesheet" href="tour.css">
<meta charset="UTF-8">
<title>ツアー試算ページ</title>
</head>
<body>
	<header><h1>ツアー試算結果</h1></header>
	<main>
		<section>
			<h2>お選びになったツアー</h2>
			<table border="1">
				<tr class="yellow">
					<td class="col1">ツアーID</td>
					<td class="col2">ツアー名</td>
					<td class="col3">行き先</td>
					<td class="col4">料金</td>
				</tr>
				<tr>
					<td><%=tour.getTourId() %></td>
					<td><%=tour.getTourName() %></td>
					<td><%=tour.getPlace() %></td>
					<td><%=tour.getPrice() %></td>
				</tr>
			</table>
		</section>
		
		<section>
			<h2>試算</h2>
			<p class="margineLeft">
				大人：<%=tour.getNumAdult() %>名<br>
				子供：<%=tour.getNumChild() %>名<br>
			</p>
			<h3>計：￥<%=tour.getTotalAmount() %></h3>
			<%
				if( tour.getNumPeople() >= 4 ){
			%>
					<p class="discount">
						<%=tour.getNumPeople() %>名様で、グループ割引適用、１割引き！！
					</p>
			<%
				}
			%>
			<form action="tour" method="post">
				<p>
					<input type="submit" name="btn" value="トップへ戻る">
				</p>
			</form>
		</section>
		
	</main>
</body>
</html>