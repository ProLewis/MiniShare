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
<title>Mini-Share Collection Creator</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Create a new collection!</h1>
		<form:form action="/collections/create" method="post"
			modelAttribute="collection">
			<div>
				<form:label path="collectionName" class="form-label">Name your Collection: </form:label>
				<form:input path="collectionName" class="form-control" />
				<form:errors path="collectionName" class="text-danger" />
			</div>
			<input type="submit" value="Create" />
			<a href="/minis">Cancel</a>
		</form:form>
	</div>
</body>
</html>