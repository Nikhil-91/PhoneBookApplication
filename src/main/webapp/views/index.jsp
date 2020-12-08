<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1>PhoneBook Application</h1>
 <p><font color="green">${success}</font></p>
 <p><font color="red">${error}</font></p>
 <form:form action="/submit" method="post" modelAttribute="Contact" autocomplete="off">
  	<table>
  		<tr>
  		<td>Name</td>
  		<td>
  		<form:input type="text" path="cname" />
  		<form:input type="hidden" path="cid" />
  		</td>
  		</tr>
        <tr>
  		<td>Email</td>
  		<td><form:input type="text" path="cemail" /></td>
  		</tr>
  		<tr>
  		<td>PhoneNo</td>
  		<td><form:input type="text" path="cnum" /></td>
  		</tr>
  	</table>
  	  <input type="Submit" value="submit">
  	  <br> <br>
  	  <a href="ViewContacts">View Contacts</a>
 </form:form>
 
</body>
</html>