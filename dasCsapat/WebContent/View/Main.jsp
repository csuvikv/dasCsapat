<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

Ez pure html

<% 
	// ez meg tiszta java, a mond�s az, hogy az iln be�gyazott blokkokat ker�lj�k
	// hogy "szebb" legyen a k�d, ink�bb speci�lis jstl (vagy el) tag-eket kellene haszn�lni.. (ls. lent)
	
	// a request objektum automatikusan l�trej�n:
	String eztkapom = (String)request.getAttribute("egyediAzonosito"); 
%>
 


</head>
<body>
	<ol>
		<li>valami</li>
		<li><%= eztkapom %></li>
		<% eztkapom = "valami m�s"; %>
		<li><%= eztkapom %></li>
	</ol>
	
	<br/>
	JSTL:
	(meg lehetne csin�lni hagyom�nyos java-s for-ral is, de �gy szebb..)
	<br/>
	
	
	<c:forEach items = "${bullshitLista}" var = "valtozo">
		<c:out value="${valtozo}"/><br/>
	</c:forEach>
	
	<br/>
	
	<c:out value="${bullshitLista}"></c:out>
</body>
</html>