<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="cs.css">

</head>
<body>
	<header> <img src="icon.png" alt="logo"
		style="width: 50px; height: 50px;" />
	<h1 id="headerlogo">Fuber</h1>
	<h1 id="headertext">24*7 Call us at 99999990</h1>
	<ul>
		<li><a href="#">Sign In</a></li>
		<li><a href="#">About Us</a></li>
		<li><a href="#">Contact Us</a></li>
	</ul>
	</header>
	<table style="margin-left: 100px;">
		<tr>
			<th
				style="color: red; font-weight: bold; font-size: 20px; padding: 10px;">Reg
				Number</th>
			<th
				style="color: red; font-weight: bold; font-size: 20px; padding: 10px;">Finish
				Ride</th>
			<th
				style="color: red; font-weight: bold; font-size: 20px; padding: 10px;">
				Color</th>
		</tr>
		<c:forEach items="${sessionScope.fuber}" var="entry">
			<c:if test="${not empty entry.value.cust}">

				<tr>
					<td style="padding: 2px; margin-left: 100px;"><c:out
							value='${entry.key.regNum}' /></td>
					<td><a href='pay.do?regnum=${entry.key.regNum}'>Click to
							finish Ride</a></td>
					<td style="padding: 10px;"><c:out value='${entry.key.color}' /></td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
</body>
</html>