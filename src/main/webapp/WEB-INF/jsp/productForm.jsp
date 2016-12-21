<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<c:if test="${errors !=null}">
		<p>
			Errors:
			<ul>
				<c:forEach var="error" items="${requestScope.errors}">
					<li>${error}</li>
				</c:forEach>
			</ul>
		</p>
	</c:if>
</div>

<form action="save" method="post">
	<div>			
		<fieldset>
			<legend>Add a product</legend>
			
			<p>
				<label for="name">Product Name:</label>
				<input type="text" name="name" tabindex="1" />
			</p>
			<p>
				<label for="price">Product Price:</label>
				<input type="text" name="price" tabindex="2"/>
			</p>			
			<p>
				<label for="produced">Product produced:</label>
				<input type="text" name="produced" tabindex="3"/>
			</p>
			<p>
				<label for="description">Product "description":</label>
				<input type="text" name="description" tabindex="4"/>
			</p>
			
			<p>
				<input type="reset" value="reset" tabindex="5"/>
				<input type="submit" value="Add Product" tabindex="6"/>
			</p>
			
		</fieldset>
	</div>
</form>
</body>
</html>