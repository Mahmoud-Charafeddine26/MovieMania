<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Movies</title>
</head>
<body>

<form action="../AddMovies" method="get" class="form">
			<label>Name      </label>     <input type="text" " name="Name">
			<br>
			<label>Author    </label>    <input type="text" name="Author">
			<br>
			<label>Duration in minutes     </label>     <input type="number" name="Duration">
			<br>
			<label>Genre      </label>     <input type="text" name="Genre">
			<br>
			<label>Rate       </label>     <input type="range" min="0" max="5" name="Rate">
			<br>
			<label>Image       </label>     <input type="file" name="Image">
			<br>
			<label>Description    </label><textarea type="text" name="Description"></textarea>
			<br>
			
			<button type="submit" id="addmovie">Add Movie</button> <button type="reset">Cancel</button>
		</form>
</body>
</html>
