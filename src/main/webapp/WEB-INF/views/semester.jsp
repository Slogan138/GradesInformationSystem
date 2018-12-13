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
			<th>이수 학점</th>
			<th>상세보기</th>
		</tr>
		<c:forEach var="sems" items="${sems}">
			<tr>
				<td><c:out value="${sems.syear}"></c:out></td>
				<td><c:out value="${sems.ssemester}"></c:out></td>
				<td><c:out value="${sems.scredit}"></c:out></td>
				<td><a
					href="${pageContext.request.contextPath}/showSubject?year=${sems.syear}&semester=${sems.ssemester}">상세보기</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/">홈으로</a>

</body>
</html>