<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ page import="model.Login" %>
    <%
   	String userId = (String) session.getAttribute("userId");
    %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン完了画面</title>
</head>
<body>

<h1>ログイン完了画面</h1>

<p>ようこそ<%= userId %>さん</p>
<a href="/kadai/MainServlet">メインアプリケーションへ</a>

<a href="/kadai/Logout">ログアウト</a>

</body>
</html>