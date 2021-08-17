<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MovieMania</title>
</head>
<body>
<form action="Login" method="get" class="form">
			<label>Username  </label><input type="text" name="username">
			<br>
			
			<label>Password    </label><input type="password" placeholder="Password" name="pwd">
			<br>
			<button type="submit" id="login-button">Login</button>
</form>

<br>

<form action="User/AddUser.jsp" method="get" class="form">
			<label>Are you new ? Create an Account  </label>
			<br>
			
			<button type="submit" id="adduser">Sign UP</button>
</form>

</body>
</html>