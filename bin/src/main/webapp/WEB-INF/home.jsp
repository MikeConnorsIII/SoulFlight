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
<title>All Song Labs</title>
</head>
<body class="container">
	


	<h1>Welcome, ${ userName}</h1>
	<p>
		<a href="/logout">Log Out</a>
	</p>


	<table class="table table-dark">
		<thead>
			<tr>
				<th scope="col">#ID</th>
				<th scope="col">Song Name</th>
				<th scope="col">Genre Name</th>
				<th scope="col">Collaborations</th>
				<th></th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="eachSong" items="${ songList}">
				<tr>
					<td scope="row"><c:out value="${eachSong.id }" /></td>
					<td>
					<a href="/songs/${eachSong.id }"><c:out value="${eachSong.title}" /></a>
					</td>
					<td><c:out value="${eachSong.genre}" /></td>
					<td><c:out value="${eachSong.colabs}" /></td>
					<!--eachSong.reader.collaborations  -->
				</tr>
			</c:forEach>

		</tbody>
	</table>
	
	<p>
		<a href="/songs/new">Add a Song</a>
	</p>



	

</body>
</html>