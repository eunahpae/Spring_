<%@page import="java.util.List"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%-- <%
//1. 사용자 입력 정보 추출
String seq = request.getParameter("seq");

// 2. DB 연동 처리
BoardVO vo = new BoardVO();
vo.setSeq(Integer.parseInt(seq));

BoardDAO boardDAO = new BoardDAO();
boardDAO.deleteBoard(vo);

// 3. 화면 네비게이션
response.sendRedirect("getBoardList.do");
%> --%>

<%-- <%
// 세션에 저장된 글 목록을 꺼낸다.
List<BoardVO> boardList = (List) session.getAttribute("boardList");
%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="message.board.list.mainTitle" /></title>
</head>
<body>
	<center>
		<h1><spring:message code="message.board.list.mainTitle" /></h1>
		<h3>
			${userName}<spring:message code="message.board.list.welcomeMsg" />...<a href="logout.do">Log-out</a>
		</h3>
		<!-- 검색 시작 -->
		<form action="getBoardList.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0" width="700">
				<tr>
					<td align="right"><select name="searchCondition">
							<c:forEach items="${conditionMap }" var="option">
								<option value="${option.value }">${option.key }
							</c:forEach>
					</select> <input name="searchKeyword" type="text" /> <input type="submit"
						value="<spring:message code="message.board.list.search.condition.btn" />" /></td>
				</tr>
			</table>
		</form>
		<!-- 검색 종료 -->
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="orange" width="100"><spring:message code="message.board.list.table.head.seq" /></th>
				<th bgcolor="orange" width="200"><spring:message code="message.board.list.table.head.title" /></th>
				<th bgcolor="orange" width="150"><spring:message code="message.board.list.table.head.writer" /></th>
				<th bgcolor="orange" width="150"><spring:message code="message.board.list.table.head.regDate" /></th>
				<th bgcolor="orange" width="100"><spring:message code="message.board.list.table.head.cnt" /></th>
			</tr>
			<c:forEach items="${boardList}" var="board">
				<tr>
					<td>${board.seq}</td>
					<td align="left"><a href="getBoard.do?seq=${board.seq}">${board.title}</a></td>
					<td>${board.writer}</td>
					<td>${board.regDate}</td>
					<td>${board.cnt}</td>
				</tr>
			</c:forEach>

		</table>
		<br> <a href="insertBoard.jsp"><spring:message code="message.board.list.link.insertBoard" /></a>
	</center>
</body>
</html>