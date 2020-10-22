<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン画面</title>
</head>
<body>

<form action="/kadai/LoginServlet" method="post">
<table>

<tr>
<td>ID</td>
<td><input type="text" name="userId"></td>
</tr>

<tr>
<td>PASS</td>
<td><input type="password" name="pass"></td>
</tr>

<tr>
<td></td>
<td><input type="submit" value="ログイン"></td>
</tr>

</table>



</form>

</body>
</html>