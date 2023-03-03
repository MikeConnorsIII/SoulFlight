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
	
	<p><a href="/home">Cancel</a></p>
	<div id="search-results">
    <h2>Search Results</h2>
    <table>
        <thead>
            <tr>
                <th>Airline</th>
                <th>Departure</th>
                <th>Arrival</th>
                <th>Duration</th>
                <th>Price</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Airline 1</td>
                <td>City A, Airport A (ABC)</td>
                <td>City B, Airport B (DEF)</td>
                <td>2h 30m</td>
                <td>$200</td>
                <td><a href="">Book Now</a></td>
            </tr>
            <tr>
                <td>Airline 2</td>
                <td>City A, Airport A (ABC)</td>
                <td>City C, Airport C (GHI)</td>
                <td>4h 15m</td>
                <td>$350</td>
                <td><a href="">Book Now</a></td>
            </tr>
            <tr>
                <td>Airline 3</td>
                <td>City A, Airport A (ABC)</td>
                <td>City D, Airport D (JKL)</td>
                <td>7h 10m</td>
                <td>$500</td>
                <td><a href="">Book Now</a></td>
            </tr>
        </tbody>
    </table>
    
    
</div>
	<title>One Donation Dashboard</title>
</head>
<body class="container">

	<h1>Single Donation Details</h1>
	
	<p><a href="/home">Go to Dashboard</a></p>

	<table class="table table-dark">
			<tr>
			<td scope="col">From city:</td>
				<td><c:out value="${flight.fromCity }" /></td>
			<tr/>
			
			<tr>
			<td scope="col">To city:</td>
			<td><c:out value="${flight.toCity}" /></td>
			</tr>
			
			<tr>
			<td scope="col">Departure date:</td>
				<td><c:out value="${flight.departDate }" /></td>
			</tr>
			
			<tr>
				<td scope="col">Return Date:</td>
			
				<td><c:out value="${flight.returnDate }" /></td>
			</tr>
	</table>


	<p>
		<a href="/logout">Log Out</a>
	</p>

</body>
</html>

</body>
</html>