<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page errorPage="/error.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Create a new book</title>
</head>
<body>
	<div>
			<fieldset>
				<legend>Add a Book</legend>
				<form:form commandName="book" method="post" action="book_save"> 
					<P>
						<label for="category">Category:</label>
						<form:select path="category.id" items="${categories}"  itemLabel="name" itemValue="id"/>
					</P>
					<p>
						<label for="title">Title:</label>
						<form:input  path="title"  id="title"/>
						<form:errors path="title" cssClass="error"/>
					</p>
					<p>
						<label for="author">Author:</label>
						<form:input id="author" path="author"/>
						<form:errors path="author" cssClass="author"/>
					</p>
					<p>
						<label for="isbn" >ISBN:</label>
						<form:input path="isbn" id="isbn"/>
						<form:errors path="isbn" cssClass="author"/>
					</p>
					<p>
						<label for="producedDate">producedDate</label>
						<form:input path="producedDate" id="producedDate"/>
					</p>
					<p>
						<form:errors path="producedDate" cssClass="error"/>
					</p>
					<p>
						<input id="reset" type="reset" />
						<input type="submit" value="Add Book"/>
					</p>
				</form:form>
			</fieldset>
	</div>
</body>
</html>