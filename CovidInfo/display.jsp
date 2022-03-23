<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Covid Data</title>
</head>
<body>
<%-- Result is : <%= request.getAttribute("result") %> --%>
<table border ="1" cellpadding="5" align="center">

<tr>
<th><b>Location</b></th>
<th><b>total_cases</b></th>
</tr>
 
  <c:forEach items="${location}" var="loc" varStatus="loop">
    <c:set var="cas" value="${cases[loop.index]}" />
    <tr>
      <td><c:out value="${loc}" /></td>
      <td><c:out value="${cas}" /></td>
    </tr>
  </c:forEach>
</table>



<%-- <table>
<tr>
<th>Location</th>
<th>total_cases</th>
</tr>
<tr>
<td> ${l}</td>
<td> ${t}</td>
</tr>

</table> --%>
</body>
</html>
