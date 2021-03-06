<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" valign="center">
		<tr>
			<th>년도</th>
			<th>학기</th>
			<th>교과코드</th>
			<th>교과명</th>
			<th>구분</th>
			<th>학점</th>
			<th>수강취소</th>
		</tr>
		<c:forEach var="subjects" items="${subjects}">
		<tr>
			<td><c:out value="${subjects.year}"></c:out></td>
			<td><c:out value="${subjects.semester}"></c:out></td>
			<td><c:out value="${subjects.subcode}"></c:out></td>
			<td><c:out value="${subjects.subname}"></c:out></td>
			<td><c:out value="${subjects.division}"></c:out></td>
			<td><c:out value="${subjects.credit}"></c:out></td>
			<td><a href="${pageContext.request.contextPath}/showRegistedSubject?subcode=${subjects.subcode}">수강취소</a></td>
		</tr>
	</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/">홈으로</a>

</body>
</html>