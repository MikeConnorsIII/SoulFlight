<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">

<title>Soul Flight</title>
<style>
html {
	background: url(./images/background-image1.jpg) no-repeat center center
		fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
}

.nav-link {
	color: white
}

.nav-link:hover {
	color: #FFFFFF;
}
.btn-dark {
	background: #545454;
}
.btn-outline-dark:hover {
	color: white;
	background: #545454;
}
</style>
</head>

<body class="bg-transparent">
	<div class="navbar" style="background-color: #545454; height: 100px;">
		<div
			class="container d-flex align-items-center justify-content-between">
			<!-- <img src="./images/soulflightlogofinal.png" alt="soulflightlogo" height="80px"> -->
			<img src="${pageContext.request.contextPath}/images/soulflightlogofinal.png" alt="soulflightlogo" height="80px">
			
			<div class="text-white d-flex gap-4">
				<a href="" class="text-decoration-none text-reset">Book</a> <a
					href="" class="text-decoration-none text-reset">My Trips</a> <a
					href="" class="text-decoration-none text-reset">Mileage Program</a>
				<a href="/" class="text-decoration-none text-reset">Sign In/
					Register</a>
			</div>
		</div>

	</div>
	<div class="container col d-flex gap">
		<div class="col-6 bg-white rounded m-3">
			<!-- Nav tabs -->
			<ul class="nav nav-tabs" id="myTab" role="tablist"
				style="background-color: #545454">
				<li class="nav-item" role="presentation">
					<button class="nav-link active" id="home-tab" data-bs-toggle="tab"
						data-bs-target="#home" type="button" role="tab"
						aria-controls="home" aria-selected="true">Book</button>
				</li>
				<li class="nav-item" role="presentation">
					<button class="nav-link" id="profile-tab" data-bs-toggle="tab"
						data-bs-target="#profile" type="button" role="tab"
						aria-controls="profile" aria-selected="false">Flight
						Status</button>
				</li>
				<li class="nav-item" role="presentation">
					<button class="nav-link" id="messages-tab" data-bs-toggle="tab"
						data-bs-target="#messages" type="button" role="tab"
						aria-controls="messages" aria-selected="false">My Trips</button>
				</li>
				<li class="nav-item" role="presentation">
					<button class="nav-link" id="settings-tab" data-bs-toggle="tab"
						data-bs-target="#settings" type="button" role="tab"
						aria-controls="settings" aria-selected="false">Settings</button>
				</li>
			</ul>
			<!-- Tab panes -->
			<div class="tab-content">
				<div class="tab-pane active" id="home" role="tabpanel" aria-labelledby="home-tab" tabindex="0">
					<div id="search-results" class="container">
						<h2 class="mb-2">Search Results</h2>
						<form action="/flights/new" method="post">
							<div class="d-flex align-items-center justify-content-around">
								<input class="form-control mb-2" placeholder="From:" type="text" id="fromCity" name="fromCity" required>
								<input class="form-control mb-2" placeholder="To:"  type="text" id="toCity" name="toCity" required> 
							</div>
							<div class="d-flex align-items-center justify-content-around col">
								<div class="mb-2 col-6">
									<label for="departDate">Departure Date:</label> 
									<input class="form-control"type="date" id="departDate" name="departDate" required>
								</div>
								<div class="mb-2 col-6">
								  	<label for="returnDate">Return Date:</label>
								  	<input class="form-control"type="date" id="returnDate" name="returnDate" required>
								</div>
							</div>
							<div class="d-flex align-items-center justify-content-around col">
								<div class="col-4">							
									<label for="adult">Adults:</label> 
									<input class="form-control"type="number" id="adult" name="adult" min="1" max="10" required> 
								</div>
								<div class="col-4">
									<label for="child">Children:</label> 
									<input class="form-control"type="number" id="child" name="child" min="0" max="10" required>
								</div>
								<div class="col-4">
									<label for="infant">Infant:</label>
									<input class="form-control"type="number" id="infant" name="infant" min="0" max="10" required> 
								</div>
							</div>
							<div>
								<label for="cabin">Class:</label><br> 
								<select class="btn btn-outline-dark" id="cabin" name="cabin" required>
									<option value="economy">Economy</option>
									<option value="business">Business</option>
									<option value="first">First Class</option>
								</select> 
							</div>
							<div class="my-3">
								<input class="btn btn-dark float-right" type="submit" value="Submit">
							</div>
						</form>

					</div>
				</div>
				<div class="tab-pane" id="profile" role="tabpanel" aria-labelledby="profile-tab" tabindex="0">
					<div class="container pb-2">
						<h2 class="mb-2">Flight Information</h2>
						<form>
							<div class="d-flex align-items-center justify-content-around">
									<input class="form-control mb-2" placeholder="From:" type="text" id="fromCity" name="fromCity" required>
									<input class="form-control mb-2" placeholder="To:"  type="text" id="toCity" name="toCity" required> 
							</div>
							<p class="text-secondary">and/or</p>
							<div class="col d-flex">
								<div class="mb-2 col-6">
									<label for="flightID">Flight number:</label>
									<input id="flightID" class="form-control" type="text"/>
								</div>
								<div class="mb-2 col-6">
									<label for="departDate">Departure Date:</label> 
									<input class="form-control"type="date" id="departDate" name="departDate" required>
								</div>
							</div>
							<div class='d-flex align-items-center col'>
								<p class="col-6">Search for flight information >></p>
								<button class="btn btn-dark col-6">Search</button>
							</div>
						</form>
					</div>
				</div>
				<div class="tab-pane" id="messages" role="tabpanel" aria-labelledby="messages-tab" tabindex="0">
					<div class='container'>
						<form>
							<h2 class="mb-3">My trips</h2>
							<input placeholder='Flight number*' type='text' class="form-control mb-3" />
							<input placeholder='Last name*' type='text' class="form-control mb-3" />
							<button class='btn btn-dark mb-3'>Search</button>
						</form>
					</div>
				</div>
				<div class="tab-pane" id="settings" role="tabpanel"
					aria-labelledby="settings-tab" tabindex="0">;ajf;laskdjf</div>
			</div>



		</div>
		<div class="col-2">
			<h1></h1>
		</div>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous">
            const triggerTabList = document.querySelectorAll('#myTab button')
            triggerTabList.forEach(triggerEl => {
                const tabTrigger = new bootstrap.Tab(triggerEl)
                triggerEl.addEventListener(e => {
                    e.preventDefault()
                    tabTrigger.show()
                })
            })
        </script>
</body>

</html>