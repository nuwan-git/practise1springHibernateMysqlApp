<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">


<title>${title}</title>
</head>
<body>

	<div class="container">

		<div class="row">

			<div class="col-md-4"></div>

			<div class="col-md-8 mx-auto">
				<h3>Employee Register<a href="addEmp"> Add</a></h3>

				<table class="tg">
					<h3>Employee List</h3>
					<tr>
						<div class="col-md-4">
							<th>Employee ID</th>
						</div>
						<div class="col-md-8">
							<th>Employee Name</th>
						</div>
					</tr>

					<c:forEach items="${employees}" var="emp">
						<tr>
							<div class="col-md-4">
								<td>${emp.id}</td>
							</div>
							<div class="col-md-4">
								<td>${emp.name}</td>
							</div>
							<div class="col-md-4">
								<td><a href="editemp/${emp.id}">Edit</a></td>  
							</div>
							<div class="col-md-4">
								<td><a href="deleteemp/${emp.id}">Delete</a></td>  
							</div>
						</tr>
					</c:forEach>
				</table>
			</div>

		</div>

	</div>


</body>
</html>