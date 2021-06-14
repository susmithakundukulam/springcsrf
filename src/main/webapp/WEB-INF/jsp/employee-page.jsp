<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<b>Employee Login</b>
<form:form action ="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
	<br>
	<c:if test="${param.error != null}">
		<i class="failed">OOps! invalid username and password</i>
	</c:if>
	<c:if test="${param.logout != null}">
		<i>You have been logout</i>
	</c:if>
	<p>
		UserName : <input type="text" name="username" />
	</p>
	<br>
	<p>
		Password : <input type="password" name="password"/>
	</p>
	<br>
		<input type="submit" value="Login" />
</form:form>
</body>
</html>