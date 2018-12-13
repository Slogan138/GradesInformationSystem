<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h3>
		<a href="${pageContext.request.contextPath}/showSemester">학기별 이수학점
			조회하기</a>
	</h3>
	<h3>
		<a href="${pageContext.request.contextPath}/registeSubject">수강신청하기</a>
	</h3>
	<h3>
		<a href="${pageContext.request.contextPath}/showRegistedSubject">수강신청
			조회하기</a>
	</h3>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<a href="javascript:document.getElementById('logout').submit()">로그아웃</a>
	</c:if>

	<form id="logout" action="<c:url value="/logout" />" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>

</body>
</html>
