<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reetu's Mobile App</title>
</head>
<body>
<a href="viewallmobile">View All Mobile Here</a>
<h3>Add New Mobile here</h3>
<c:if test="${add=='success'}">
<h3 style="color: green;">Successfully Added!</h3>
</c:if>
<form action="addMobile" method="post" enctype="multipart/form-data">  <!-- it is neccessory to use enctype when we work with image.. -->
Mobile Name: <input type ="text" name = "mname" required/><br/><br/>
Mobile Price: <input type ="number" name = "mprice" required/><br/><br/>
First Image Upload: <input type = "file" name = "image1"><br><br>
<!-- Second Image Upload: <input type = "file" name = "image2"><br><br> -->
<button>Add Mobile</button>
</form>
<c:if test="${add=='failed'}">
<h3 style="color: green;">Successfully Added!</h3>
</c:if>
<hr>

<c:if test="${delete=='Success'}">
<h3 style="color: red;">Successfully Deleted!</h3>
</c:if>
<c:if test="${delete=='failed'}">
<h3 style="color: green;">No Mobile Found to be Deleted!</h3>
</c:if>
<h3>Delete Mobile Here</h3>
<form action="deletemobile" method="post">
Mobile Name: <input type ="text" name = "mname" required/><br/><br/>
<button>Delete</button>
</form>
<hr>
<a href="UpdateMobile">Update Mobile here!</a>

</body>
</html>