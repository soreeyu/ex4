<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		
	
		$(".this").click(function() {
			document.frm.curPage.value=$(this).attr("title");
			document.frm.kind.value='${info.kind}';
			document.frm.search.value='${info.search}';
			document.frm.submit();
			
			//var curPage = $(this).attr("title");
			//location.href="${board}List?curPage="+curPage+"&search=${info.search}&kind=${info.kind}"
		});
		
		
		
	});
</script>
</head>
<body>
	<h1><a href="${board}List" style="text-decoration: none;">${board}</a></h1>
	
		<div>
			<form action="${board }List" name="frm">
				<input type="hidden" name="curPage">
				<select name="kind" >
					<option value="title">TITLE</option>
					<option value="writer">WRITER</option>
					<option value="contents">CONTENTS</option>
				</select>
				<input type="text" name="search">
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
		
		<div>
			<c:if test="${info.curBlock > 1 }">
				<span class="this" title="${info.startNum-1 }" style="cursor: pointer;">[이전]</span>
			</c:if>
			<c:forEach begin="${info.startNum }" end="${info.lastNum }" var="i">
				<span class="this" title="${i }" style="cursor: pointer;">${i }</span>
			</c:forEach>
			<c:if test="${info.curBlock < info.totalBlock }">
				<span class="this" title="${info.lastNum+1 }" style="cursor: pointer;">[다음]</span>
			</c:if>
		</div>
		
		<a href="${board }Write">BOARD WRITE</a>
		
		
</body>
</html>