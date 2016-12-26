<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Book Edit</title>
</head>
<body>
	<div>
		<fieldset>
			<legend>Edit A Book</legend>
			<form:form commandName="book" action="${ pageContext.request.contextPath}/book_update"  method="post">
				<form:hidden path="id" id="id"/>
				<P>
						<label for="category">Category:</label>
						<form:select path="category.id" items="${categories}"  itemLabel="name" itemValue="id"/>
					</P>
					<p>
						<label for="title">Title:</label>
						<form:input  path="title"  id="title"/>
					</p>
					<p>
						<label for="author">Author:</label>
						<form:input id="author" path="author"/>
					</p>
					<p>
						<label for="isbn" >ISBN:</label>
						<form:input path="isbn" id="isbn"/>
					</p>
					<p>
						<label for="price" >price:</label>
						<input type="text" name="price"  value="<fmt:formatNumber type='currency' currencyCode='CNY' value='${price }'/>" />
					</p>
					<p>
						<label for="producedDate">producedDate</label>
						<input type="text" value="<fmt:formatDate value='${book.producedDate}' pattern='yyyy-MM-dd HH:mm:ss'/>" 
							id="producedDate" name="producedDate" />
					</p>
					<p>
						<label>Image:</label>
						<c:if test="${book.images!=null }">
							<ol>
							<c:forEach items="${book.images }" var="img">
								<li>${img.originalFilename }
								<img src="<c:url value="/images/"/>${img.originalFilename }" />
								</li>
							</c:forEach>
							</ol>
						</c:if>
					</p>
					<p>
						<input id="reset" type="reset" />
						<input type="submit" value="Edit Book"/>
					</p>
			</form:form>
		</fieldset>
	</div>
</body>
</html>