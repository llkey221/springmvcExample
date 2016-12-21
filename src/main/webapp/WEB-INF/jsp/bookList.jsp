<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Book List</title>
</head>
<body>
	<div>
		<p>
			<a href="book_input">Create a book</a>
		</p>
		<table border="1">
			<thead>
				<tr>
					<th>Category</th>
					<th>Title</th>
					<th>ISBN</th>
					<th>Author</th>
					<th>&nbsp;</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${bookList!=null }">
					<c:forEach var="book" items="${bookList}">
						<tr>
							<td>${book.category.name }</td>
							<td>${book.title }</td>
							<td>${book.isbn }</td>
							<td>${book.author }</td>
							<td><fmt:formatDate value="${book.producedDate}" pattern='yyyy-MM-dd HH:mm:ss'/></td>
							<td><a href="book_edit/${book.id}">Edit</a></td>
						</tr>
					</c:forEach>
				</c:if>
				
			</tbody>
		</table>
	</div>
</body>
</html>