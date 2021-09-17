<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
	private String[] item = {"バナナボード", "パラセーリング", "サーフィン", "ダイビング"};
	private int[] price = { 30, 45, 20, 100 };
	private String[] image = {"banana.jpg", "para.jpg", "surfing.jpg", "dive.jpg"};
%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>マリンスポーツお申込みフォーム</title>
</head>
<body>
	<div id="wrapper">
		<header><h1>マリンスポーツお申込みフォーム</h1></header>

	<main>
		<form action="marine_sports_details.jsp" method="get">
			<p>
				参加したいマリンスポーツにチェックを付けて下さい。<br>
				<strong>5名様以上のお申込みで今なら10%OFF！！</strong>
			</p>
			<table border="1">
				<tr>
					<th>マリンスポーツ</th>
					<th>イメージ</th>
					<th></th>
				</tr>
				<%
					for( int i = 0; i < item.length; i++ ){
				%>
					<tr>
						<td>
							<%=item[i] %><br>
							$<%=price[i] %>
						</td>
						<td>
							<img src="img/<%=image[i]%>" width="128" height="96" alt="<%=item[i]%>">
						</td>
						<td>
							<input type="checkbox" name="itemNo" value="<%=i %>">
						</td>
					</tr>
				<%
					}
				%>
					<tr>
						<td colspan="2">参加人数を入力してください。</td>
						<td><input type="text" name="people" value="" size="4"></td>
					</tr>
			</table>
			<p>
				<input type="submit" value="送信">
			</p>
		</form>
	</main>
	</div>
</body>
</html>