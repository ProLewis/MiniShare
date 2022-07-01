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
<title>Mini-Share Login</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Mini-Share</h1>
		<div class="main d-flex">
			<div class="register col-9">
				<h2>Register</h2>
				<form:form action="/register" method="post" modelAttribute="newUser">
					<div class="form-group">
						<form:label path="firstName">First Name: </form:label>
						<form:input path="firstName" type="text" />
						<form:errors path="firstName" class="text-danger" />
					</div>
					<div class="form-group">
						<form:label path="lastName">Last Name: </form:label>
						<form:input path="lastName" type="text" />
						<form:errors path="lastName" class="text-danger" />
					</div>
					<div class="form-group">
						<form:label path="email">Email: </form:label>
						<form:input path="email" type="text" />
						<form:errors path="email" class="text-danger" />
					</div>
					<div class="form-group">
						<form:label path="password">Password: </form:label>
						<form:input path="password" type="text" />
						<form:errors path="password" class="text-danger" />
					</div>
					<div class="form-group">
						<form:label path="confirmPassword">Confirm Password: </form:label>
						<form:input path="confirmPassword" type="text" />
						<form:errors path="confirmPassword" class="text-danger" />
					</div>
					<input type="submit" class="btn btn-success" value="Register User" />
				</form:form>
			</div>
			<div class="login col-9">
				<h2>Login</h2>
				<form:form action="/login" method="post" modelAttribute="newLogin">
					<div class="form-group">
						<form:label path="email">Email: </form:label>
						<form:input path="email" type="text" />
						<form:errors path="email" class="text-danger" />
					</div>
					<div class="form-group">
						<form:label path="password">Password: </form:label>
						<form:input path="password" type="text" />
						<form:errors path="password" class="text-danger" />
					</div>
					<input type="submit" class="btn btn-success" value="Login" />
				</form:form>
			</div>
		</div>
		<h3 class="text-danger"><c:out value="${error}"/></h3>
	</div>
</body>
</html>