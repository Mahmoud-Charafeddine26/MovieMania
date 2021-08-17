<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MovieMania</title>
</head>
<body>
<form action="../AddUser" method="get" class="form">
			<label>Username  </label><input type="text" " name="username">
			<br>
			<label>Password    </label><input type="password" placeholder="Password" name="pwd">
			<br>
			<label hidden>Admin    </label><input type="checkbox" name="admin"  hidden>
			<br>
			<button type="submit" id="login-button">Create</button>  <button type="reset">Cancel</button>
		</form>
</body>
</html>
