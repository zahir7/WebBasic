<%@ page language="java" contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Result ������</h2>
<table border="1">
	<tr>
		<td>���̵�</td>
		<td>�о�����</td>
		<td>�̸�</td>
	</tr>
<c:forEach items="${mlist }" var="mlist">
	<tr>
		<td> ${mlist.id}</td>
		<td>${mlist.pw}</td>
		<td>${mlist.name}</td>
	</tr>
</c:forEach>
</table>
