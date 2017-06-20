<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var m ='${message}';
	if(m != ''){
		alert(m);
	}
</script>
</head>
<body>
	<h1>${board}</h1>
	
		<div>
			<form action="${board }List">
				<select name="search">
					<option value="title">TITLE</option>
					<option value="writer">WRITER</option>
					<option value="contents">CONTENTS</option>
				</select>
				<input type="text" name="find">
				<input type="submit" value="SEARCH">
			</form>
		</div>
	
		<table>
			<tr>
				<td>Num</td><td>Title</td><td>Writer</td><td>Contents</td><td>Date</td><td>Hit</td>
			</tr>
			<c:forEach items="${list }" var="i">
			<tr>
				<td>${i.num }</td>
				<td>
				<c:catch>
					
						<c:forEach begin="1" end="${i.depth }">
							&nbsp;&nbsp;
						</c:forEach>
					
				</c:catch>
						<a href="${board}View?num=${i.num }">${i.title }</a>
						
				</td>
				<td>${i.writer }</td>
				<td>${i.contents }</td>
				<td>${i.reg_date }</td>
				<td>${i.hit }</td>
			</tr>
			</c:forEach>
		</table>
		<a href="${board }Write">FREEBOARD WRITE</a>
</body>
</html>