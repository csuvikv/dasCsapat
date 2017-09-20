<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

Ez pure html

<% 
	// ez meg tiszta java, a mondás az, hogy az iln beágyazott blokkokat kerüljük
	// hogy "szebb" legyen a kód, inkább speciális jstl (vagy el) tag-eket kellene használni.. (ls. lent)
	
	// a request objektum automatikusan létrejön:
	String eztkapom = (String)request.getAttribute("egyediAzonosito"); 
%>
 


</head>
<body>
	<ol>
		<li>valami</li>
		<li><%= eztkapom %></li>
		<% eztkapom = "valami más"; %>
		<li><%= eztkapom %></li>
	</ol>
	
	<br/>
	JSTL:
	(meg lehetne csinálni hagyományos java-s for-ral is, de így szebb..)
	<br/>
	
	
	<c:forEach items = "${bullshitLista}" var = "valtozo">
		<c:out value="${valtozo}"/><br/>
	</c:forEach>
	
	<br/>
	
	<c:out value="${bullshitLista}"></c:out>
</body>
</html>