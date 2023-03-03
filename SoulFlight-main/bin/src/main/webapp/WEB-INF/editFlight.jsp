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
<title>Edit Song</title>
</head>
<body class="container">

	<h1>Edit Book</h1>
	<p><a href="/home">Cancel</a></p>
	<form:form action="/songs/edit/${song.id}" method="post"
		modelAttribute="song">
		<input type="hidden" name="_method" value="put">
		
		<p class="form-group">
			<form:label path="title">Song Title</form:label>

			<form:input path="title" class="form-control" />
			<form:errors path="title" class="text-danger" />
		</p>
		<p class="form-group">
			<form:label path="genre">Genre</form:label>
			<form:input path="genre" class="form-control" />
			<form:errors path="genre" class="text-danger" />
		</p>
		<p class="form-group">
			<form:label path="lyrics">Lyrics</form:label>
			<form:input path="lyrics" class="form-control" />
			<form:errors path="lyrics" class="text-danger" />
		</p>
		<form:hidden path="colabs" value="${song.colabs + 1}"></form:hidden>
		
		<form:hidden path="reader"/>
		
		<input type="submit" value="Edit" class="btn btn-primary" />
		<c:choose>
		<c:when test="${userId.equals(song.reader.id) }">
			<td>
			<form action="/songs/delete/${song.id}"method="post">
			<input type="hidden" name="_method" value="delete"> 
			<input type="submit" value="Delete" class="btn btn-danger">
			</form>
			</td>
		</c:when>
		</c:choose>
	</form:form>
	
	

</body>
</html>