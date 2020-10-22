<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/kadai/RegisterServlet" method="post">
<P>アカウントを登録する</P>
<table>
<tr>
<td>userID</td>
<td><input type="text" name="userId"></td>
</tr>
<tr>
<td>pass</td>
<td><input type="password" name="pass"></td>
</tr>
<tr>
<td>名前</td>
<td><input type="text" name="name"></td>
</tr>
<tr>
<td>年齢</td>
<td><input type="text" name="age"></td>
</tr>
<tr>
<td>住んでる場所</td>
<td>
<select name="address">
<option value="北海道">北海道</option>
<option value="東日本">東日本</option>
<option value="西日本">西日本</option>
<option value="沖縄">沖縄</option>

</select>

</td>
</tr>

<tr>
<td></td>
<td><input type="submit" value="アカウント登録"><input type="reset" value="取消"></td>
</tr>

</table>


</form>

</body>
</html>