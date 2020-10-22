<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ page import="model.Friend,java.util.List" %>
     <%@ page import="model.Login" %>
    <%
   	String userId = (String) session.getAttribute("userId");
    %>

    <%
    List<Friend> arrayFriend = (List<Friend>) application.getAttribute("arrayFriend");

    int id = (int)request.getAttribute("id");



    %>

    <%
     int x = 0;

    for(int i = 0; i < arrayFriend.size();i++){

    	if(id == arrayFriend.get(i).getId()){

    		x = i;
    	}
    }




    %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>編集UPDATE結果ページ</h1>

<p>編集完了した人ーーーーーー</p>
<p></p>
<table>
<tr>
<td><p>友達ID：<%= arrayFriend.get(x).getId() %> </p></td>
<td><p>名前：<%= arrayFriend.get(x).getName() %> </p></td>
<td><p>年齢：<%= arrayFriend.get(x).getAge() %> </p></td>
<td><p>住んでるところ：<%= arrayFriend.get(x).getAddress() %> </p></td>
</tr>
</table>
<p>ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー</p>


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
<td>
<a href="UpdateServlet">編集へ戻る!</a></td><td></td>
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