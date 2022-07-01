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
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Select a set or enter a Custom Mini</h1>
		<div class="row">
			<div class="col">
				<c:forEach var="set" items="${sets}">
					<a href="/collections/${collection.id}/sets/${set.id}"><c:out value="${set.setName}" /></a>
				</c:forEach>
			</div>
			<div class="col">
				<form:form action="/minis/create" method="post"
					modelAttribute="mini">
					<div class="form-group">
						<form:label path="name" class="form-label">Name of Mini: </form:label>
						<form:input path="name" class="form-control" />
						<form:errors path="name" class="text-danger" />
					</div>
					<div class="form-group">
						<form:label path="size" class="form-label">Size: </form:label>
						<form:select path="size" class="form-select">
							<form:option value="Small">Small</form:option>
							<form:option value="Medium">Medium</form:option>
							<form:option value="Large">Large</form:option>
							<form:option value="Huge">Huge</form:option>
						</form:select>
						<form:errors path="size" class="text-danger" />
					</div>
					<div class="form-group">
						<form:checkbox path="painted" class="form-check-input" />
						<form:label path="painted" class="form-check-label">Painted?: </form:label>
						<form:errors path="painted" class="text-danger" />
					</div>
					<div class="form-group">
						<form:label path="quantity" class="form-label">Quantity: </form:label>
						<form:input path="quantity" class="form-control" />
						<form:errors path="quantity" class="text-danger" />
					</div>
					<div class="form-group">
						<form:label path="description" class="form-label">Description (optional): </form:label>
						<form:textarea path="description" cols="30" rows="4"
							class="form-control" />
						<form:errors path="description" class="text-danger" />
					</div>
					<input type="submit" value="Submit" />
					<a href="/minis">Cancel</a>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>