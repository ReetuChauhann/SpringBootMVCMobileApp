<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${keys}" var="y">
		<p>
			<c:out value="${y.mname}"></c:out>
		</p>
		<p>
			<c:out value="${y.mprice}"></c:out>
		</p>
		<img alt="" src="getimage1?mname=${y.mname}" height="50px" width="50px">
		<%-- <img alt="" src="getimage2?name=${y.mname}" height="50px" width="50px"> --%>
		
		<hr>
</c:forEach>
	<form action="viewall" method="post">
		<button>View All Mobile Here</button>
	</form>
	
</body>
</html>