<%@page import="kenmodel.TourBean" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="tour.css">
<title>ツアー試算ページ</title>
</head>
<body>
	<header><h1>ご希望のツアーを選んでください</h1></header>
	<main>
	<%
		ArrayList<TourBean> tours = (ArrayList<TourBean>)request.getAttribute("tours");
		
		for( TourBean tour : tours ){
	%>
		
		<table border="1">
			<tr class="green2">
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
				<td>
					<form action="tour" method="post">
						<input type="submit" name="btn" value="選択">
						<input type="hidden" name="tourId" value="<%=tour.getTourId() %>">
					</form>
				</td>
			</tr>
		</table>
		
	<%
		}
	%>
	
	</main>
</body>
</html>