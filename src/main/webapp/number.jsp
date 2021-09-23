<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="tour.css">
<title>ツアー試算ページ</title>
</head>
<body>
	<header><h1>参加者人数は？</h1></header>
	<main>
		<form action="tour" method="post">
			<p class="marginLeft">大人：
				<select name="adult">
					<option value="1" selected>1名</option>
					<option value="2" >2名</option>
					<option value="3" >3名</option>
					<option value="4" >4名</option>
					<option value="5" >5名</option>
					<option value="6" >6名</option>
					<option value="7" >7名</option>
					<option value="8" >8名</option>
					<option value="9" >9名</option>
				</select>
			</p>
			<p class="marginLeft">子ども：
				<select name="child">
					<option value="0" selected>なし</option>
					<option value="1" >1名</option>
					<option value="2" >2名</option>
					<option value="3" >3名</option>
					<option value="4" >4名</option>
					<option value="5" >5名</option>
				</select>
			</p>
			<p class="marginLeft">
				<input type="submit" name="btn" value="試算">
			</p>
		</form>
		<p>
			※子供料金は、大人料金の半額です。<br>
			※参加者４名以上で、料金が１割引きになります。（グループ割引き）
		</p>
	</main>
</body>
</html>