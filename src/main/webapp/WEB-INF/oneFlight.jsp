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
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>One Song Dashboard</title>
</head>
<body class="container">
 
	<h1>${song.title }</h1>
	
	<p><a href="/home">Cancel</a></p>
	<c:choose>
		<c:when test="${user.id == song.reader.id}"> 
			<p> You started ${song.title} in the genre: ${song.genre}</p>
			<h3>Here are your lyrics:</h3>
		</c:when>
		<c:otherwise>
		<p>${song.reader.userName} started ${song.title} in the genre: ${song.genre}</p>
		<h3>Here are ${song.reader.userName} thoughts: </h3>
		</c:otherwise>
	</c:choose>
	<br>
	<p>${song.lyrics}</p>
	<br>
	
			<p>
			<a class="btn btn-primary" href="/songs/edit/${song.id }">Contribute</a>
			</p>
	<c:choose>
		<c:when test="${userId.equals(song.reader.id) }">
			<td>
			<form action="/songs/delete/${song.id}"method="post">
			<input type="hidden" name="_method" value="delete"> 
			<input type="submit" value="Delete" class="btn btn-danger">
			</form>
			</td>
		</c:when>
		<c:otherwise>
					
		</c:otherwise>
	</c:choose>
	
</body>
</html>