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

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>編集UPDATEページ</h1>


<form action="UpdateServlet" method="post">

<P>友達を編集する</P>
<p>編集する友達帳のIDを半角数字で入力して、名前、年齢、住んでる場所を編集してください</p>
<table>
<tr>
<td>ID</td>
<td><input type="text" name="id"></td>
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
<td><input type="submit" value="編集"><input type="reset" value="取消"></td>
</tr>
</table>
</form>
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
</body>
</html>