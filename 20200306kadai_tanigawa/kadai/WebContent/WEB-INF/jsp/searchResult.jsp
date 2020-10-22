<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ page import="model.Friend,java.util.*" %>

    <%
    List<Friend> arrayFriendAddress = (List<Friend>) session.getAttribute("arrayFriendAddress");
    String x = (String) request.getAttribute("x");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>検索結果</h1>

<p><% if(x.equals("1")){ %></p>
<h1>住んでる場所の検索結果</h1>
<% } else if(x.equals("2")){ %>
<h1>年代別の検索結果</h1>
<% } %>
<table>
<% for(Friend friend : arrayFriendAddress){
%>
<tr>
<td>友達ID：<%= friend.getId() %></td>
<td> 名前：<%= friend.getName() %></td>
<td> 年齢：<%= friend.getAge() %></td>
<td> 住んでるところ：<%= friend.getAddress() %></td>
</tr>

<% } %>
</table><br>

<table>


<tr>
<td>
<a href="SearchServlet">検索へ戻る!</a></td><td></td>
<td>

<a href="MainServlet">メインアプリケーションに戻ります!</a>
</td><td> </td>
<td>
<a href="/kadai/Logout">ログアウト</a>
</td><td> </td>
</tr>
</table>
</body>
</html>