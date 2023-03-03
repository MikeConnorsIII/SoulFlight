<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Start a new Song!</title>
</head>
<body class="container">

	<h1>Search for a flight</h1>
	
	<form:form action="/flights/new" method="post"
		modelAttribute="newSong">
		<p class="form-group">
			<form:label path="fromCity">From where</form:label>
			<form:input path="fromCity" class="form-control" />
			<form:errors path="fromCity" class="text-danger" />
		</p>
		<p class="form-group">
			<form:label path="toCity">To where</form:label>
			<form:input path="toCity" class="form-control" />
			<form:errors path="toCity" class="text-danger" />
		</p>
		<p class="form-group">
			<form:label path="lyrics">Lyrics</form:label>
			<form:input path="lyrics" class="form-control" />
			<form:errors path="lyrics" class="text-danger" />
		</p>
		
		<form:hidden path="colabs" value="0"></form:hidden>
		
		
		<form:hidden path="reader" value="${userId}"/>
		
		<input type="submit" value="Submit" class="btn btn-primary" />
	</form:form>
	<p><a href="/home">Cancel</a></p>
	

</body>
</html>