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
<title>Mini-Share</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<a href="/collections/1/edit">Go back</a>
		<h1>Add the minis below to your collection!</h1>
		<h2>
			<c:out value="${set.setName}" />
		</h2>
		<c:forEach var="mini" items="${set.getSetMinis()}">
			<div class="setMini">
				<c:out value="#${mini.setNum} ${mini.name}" />
				<div>
					<p>${mini.rarity}</p>
					<p>${mini.size}</p>
				</div>
				<div class="setMiniImgContainer">
					<img
						src="/TheWildBeyondTheWitchlight/${mini.setNum}${mini.name}.jpg"
						height="100%" width="100%" alt="${mini.name}" />
				</div>
				<div>
					<form action="/collections/${collection.id}/sets/${mini.id}/add" method="post">
					<input type="submit" value="Add"/>
					</form>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>