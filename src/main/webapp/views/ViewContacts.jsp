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
 <h1>View All Contacts</h1>
 <p><font color="red">${msg}</font></p>
 <h3><a href="/">+AddContacts</a></h3>
 <table border="1">
 	<tr>
	 	<th>Name</th>
	 	<th>Email</th>
	 	<th>PhoneNo</th>
	 	<th>Action</th>
 	</tr>
 	<tbody>
 	   <c:forEach items="${Contacts}" var="contact">
 	    <tr>
 	    <td>${contact.cname}</td>
 	    <td>${contact.cemail}</td>
 	    <td>${contact.cnum}</td>
 	    <td>
 	     <a href="editContact?cid=${contact.cid}">Edit</a>
 	     <a href="deleteContact?cid=${contact.cid}" onclick="return deleteContact()">Delete</a>
 	    </td>
 		</tr>
 	   </c:forEach>
 	   

 	</tbody>
 </table>
 
 <Script>
  function deleteContact(){
	  confirm("Are you sure to delete contact?");
  }
 </Script>
</body>
</html>