<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mini-Share Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="navbar">
			<h1>Welcome to Mini-Share!</h1>
			<a href="/collections/new">Create a new Collection</a>
			<a href="/logout">Logout</a>
		</div>
		<div>
			<c:forEach var="collection" items="${collections}">
				<c:if test="${user.id == collection.collectionCreator.id}">
					<div>
						<a href="/collections/${collection.id}"><c:out
								value="${collection.collectionName}" /></a>
						<a href="/collections/${collection.id}/edit">Edit</a>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>
</body>
</html>