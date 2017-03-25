<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>게시판 샘플</title>
</head>

<table width="80%" border="1" bordercolor="#B2CCFF" cellspacing="5"
	cellpadding="5" align="center">
	<tr height="30">
		<th align="center" width="200">글번호</td>
		<th align="center" width="600">글제목</td>
		<th align="center" width="200">작성자</td>
		<th align="center" width="200">등록일</td>
	</tr>

	<c:forEach var="list" items="${list }">
	<tr>
		<td align="center" width="200">${list.no }</td>
		<td align="center" width="600">${list.title }</td>
		<td align="center" width="200">${list.writer }</td>
		<td align="center" width="200">${list.reg }</td>		
	</tr>
	</c:forEach>
</table>
</body>
</html>