<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Phone Book</title>
 
<spring:url value="/resources/css/phonebook.css" var="coreCss" />
<link href="${coreCss}" rel="stylesheet" />
</head>
<table>
	<thead><tr><th colspan="2">Phone Book</th></tr></thead>
	<tbody>
		<c:forEach items="${phonebook}" var="listing">
		<tr>
			<th>${listing.lastName}, ${listing.firstName}</th>
			<td>${listing.number}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>