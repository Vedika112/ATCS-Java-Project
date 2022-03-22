<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- Result is : <%= request.getAttribute("result") %> --%>
<table>
<tr>
<th>Location</th>
<th>total_cases</th>

</tr>
<tr>
<td> ${l}</td>
<td> ${t}</td>
</tr>
</table>
</body>
</html>