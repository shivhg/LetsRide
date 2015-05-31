<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${sessionScope.fuber}" var="entry">
		<c:if test="${not empty entry.value.cust}">
			<c:out value='${entry.key.regNum}' />
			<a href='pay.do?regnum=${entry.key.regNum}'>click to finish Ride</a>
		</c:if>
	</c:forEach>
</body>
</html>