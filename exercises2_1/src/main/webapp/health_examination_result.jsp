<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String[] get_health = request.getParameterValues("health");

	int count = 0;
	String result;
	if( name != null ){	//パラメータがない＝不正なアクセス
		if( get_health == null ){	// パラメータがない＝不正アクセス
			count = 0;
		}else{
			count = get_health.length; // 名前が未記入でもカウントはする
		}
		if( !name.isEmpty() ){
			switch(count){
			case 0:
				result = "非常に健康です";
				break;
			case 1:
				result = "健康です";
				break;
			case 2:
				result = "健康に気を付けましょう";
				break;
			case 3:
				result = "不健康です";
				break;
			case 4:
				result = "一度検査を受けてみては？？";
				break;
			default:
				result = "エラー";
				break;
			}

		}else{
			name = "名無し";
			result = "お名前を入力して下さい";
		}
	}else{
		name = "測定不可能";
		result = "トップページに戻ってください";
	}

%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<main>
		<h2><%=name %>さんの健康チェック</h2>
		<p>チェックは<%=count %>個です</p>
		<p>結果：<%=result %></p>
		<p><a href="health_examination.html">戻る</a></p>
	</main>

</body>
</html>