<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>検索ページ</h1>

<form action="SearchServlet" method="post">
<table>
<tr>
<td>
検索方法１
</td>
<td>
<select name="address">
<option value="北海道">北海道</option>
<option value="東日本">東日本</option>
<option value="西日本">西日本</option>
<option value="沖縄">沖縄</option>

</select>

</td>
<td>

<input type="hidden" name="x" value="1">
<input type="submit" value="住んでる場所別で友達を検索">
</td>
</tr>


</table>

</form>

<form action="SearchServlet" method="post">
<table>
<tr>
<td>
検索方法２
</td>
<td>
<select name="age">
<option value="age <= 20">未成年</option>
<option value="age >= 20 AND age < 60">20代〜50代</option>
<option value="age >= 60">還暦以上の老人</option>

</select>
</td>
<td>
<input type="hidden" name="x" value="2">
<input type="submit" value="年代別で友達を検索">
</td>
</tr>
</table>
</form>




<a href="MainServlet">メインアプリケーションに戻る</a>
<a href="/kadai/Logout">ログアウト</a>
</body>
</html>