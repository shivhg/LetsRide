<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.blink {
	font-size: 35px;
	font-weight: bold;
	color: red;
	animation-duration: 1s;
	animation-name: blink;
	animation-iteration-count: infinite;
	animation-direction: alternate;
	animation-timing-function: ease-in-out;
}

@
keyframes blink {from { opacity:1;
	
}

to {
	opacity: 0;
}

}
#te {
	margin-top: 100px;
	padding: 30px;
}
</style>
</head>
<body>
	<img src="travelling.jpg" alt="travelling image" />
	<h1>Have fun Ride</h1>
	<br />
	<br />
	<h3 style="color: blue">
		<span id="te">Reached ? </span>
		<button type="submit" onclick="location.href = 'pay.do'">
			Pay Now
			<p class="blink">${requestScope.cost}$</p>
			
</body>
</h3>
</button>

</html>