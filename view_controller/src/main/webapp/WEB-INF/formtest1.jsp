<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>様々なフォームの利用</title>
</head>
<body>
	<header>
		<h1>アンケートフォーム</h1>
	</header>
	<main>
		<form action="formtest" method="post">
			<table border="1">
				<tr>
					<th>年代</th>
					<td>
						<select name="birth">
							<option value="20代" selected="selected">20代</option>
							<option value="30代" >30代</option>
							<option value="40代" >40代</option>
							<option value="50代" >50代</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>性別</th>
					<td>
						<label><input type="radio" name="gender" value="男性" checked="checked">男性</label>
						<label><input type="radio" name="gender" value="女性" >女性</label>
					</td>
				</tr>
				<tr>
					<td>趣味(複数回答可)</td>
					<td>
						<label><input type="checkbox" name="hobby" value="映画鑑賞">映画鑑賞</label>
						<label><input type="checkbox" name="hobby" value="読書">読書</label>
						<label><input type="checkbox" name="hobby" value="スポーツ">スポーツ</label>
						<label><input type="checkbox" name="hobby" value="料理">料理</label>
						<label><input type="checkbox" name="hobby" value="ゲーム">ゲーム</label>
					</td>
				</tr>
			</table>
			<p>
				<input type="hidden" name="color" value="#ffff00">
				<input type="image" src="send.jpg" alt="送信">
			</p>
		</form>
	</main>
</body>
</html>