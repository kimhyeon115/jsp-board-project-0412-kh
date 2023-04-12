<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작성 글내용 보기</title>
</head>
<body>
	<h2>글 내용 보기</h2>
	<hr>
	<table border="1" cellspacing="0" cellpadding="0" width="600">
		<tr>
			<th>번호</th>
			<th>글쓴이</th>
			<th>제목</th>
			<th>내용</th>
			<th>등록일</th>			
		</tr>	
		<tr>
			<td>${contentDto.bnum }</td>
			<td>${contentDto.writer }</td>
			<td>${contentDto.sunject }</td>
			<td>${contentDto.content }</td>
			<td>${contentDto.wdate }</td>
		</tr>
	</table>
	<input type="button" value="글삭제" onclick="script:window.location.href='delete.do?bnum=${contentDto.bnum}'">
	<input type="button" value="글목록" onclick="script:window.location.href='list.do'">
</body>
</html>