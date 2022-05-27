<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="Updatehere">
<c:if test="${result=='failed'}">
<h3 style="color: red;">No Mobile Found to be Updated!</h3>
</c:if>
<c:if test="${result=='success'}">
<h3 style="color: green;">Successfully Updated!</h3>
</c:if>
Select Mobile Name here Which you Want to Update: <select name="mname">
<c:forEach items="${list}" var="x">
<option>${x}</option>
</c:forEach>
</select><br><br>
Enter Mobile Price:<input type="number" name="mprice" required/> <br><br>
<button>Update Mobile!</button>


</form>
</body>
</html>