<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Friend,java.util.List" %>
     <%@ page import="model.Login" %>
    <%
   	String userId = (String) session.getAttribute("userId");
    %>

    <%
    List<Friend> arrayFriend = (List<Friend>) application.getAttribute("arrayFriend");



    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メイン画面</title>
</head>
<body>
<h1>メイン画面　友達帳</h1>

<p>ようこそ<%= userId %>さん</p>
<a href="/kadai/MainServlet">更新する</a><br>
<a href="/kadai/Logout">ログアウト</a>
<p>----------------------------------------</p>

<form action="/kadai/MainServlet" method="post">
<P>友達を登録する</P>
<table>
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
<td><input type="submit" value="登録"><input type="reset" value="取消"></td>
</tr>

</table>


</form>
<p>----------------------------------------</p>
<form>
<p>検索する</p>
<table>
<tr>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td><a href="/kadai/SearchServlet">検索へ</a></td>
</tr>
</table>

</form>
<p>----------------------------------------</p>
<form>
<p><a href="UpdateServlet">編集する</a></p>
</form>
<p>----------------------------------------</p>


<p>全友達リスト</p>
<table>
<tr>
<td></td>
<td></td>
</tr>


<% for(Friend friend : arrayFriend){
%>
<tr>
<td><p>友達ID：<%= friend.getId() %> </p></td>
<td><p>名前：<%= friend.getName() %> </p></td>
<td><p>年齢：<%= friend.getAge() %> </p></td>
<td><p>住んでるところ：<%= friend.getAddress() %> </p></td>
</tr>

<% } %>

</table>

<table>

<tr>
<td><h1><a href="Barusu"><h1>友達をバルスする</h1></a></h1></td>
<td></td>
</tr>

</table>


</body>
</html>