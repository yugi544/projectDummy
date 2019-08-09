<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updateAlien">
<input type="hidden" name="aid" value="${alien.aid}">
<input type="text" name="aname" value="${alien.aname}">
<input type="text" name="alang" value="${alien.alang}">
<input type="submit" value="Update">
</form>

</body>
</html>