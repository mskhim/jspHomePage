<%@page import="java.text.SimpleDateFormat"%>
<%@page import="co.kh.dev.home.model.CommentDAO"%>
<%@page import="co.kh.dev.home.model.BoardDAO"%>
<%@page import="co.kh.dev.home.model.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
CustomerVO cvo = MyUtility.returnCvoBySession(session);
CommentDAO cmDAO = CommentDAO.getInstance();
if (request.getAttribute("bList") == null) {//강제로 접근시 서블릿으로 보내는 기능
	response.sendRedirect("/jspHomePage/boardSelect.do");
	return;
}
SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd   HH:mm");
ArrayList<BoardVO> bList = (ArrayList<BoardVO>) request.getAttribute("bList");
int viewTime = (int) request.getAttribute("viewTime");
int pageNum = (int) request.getAttribute("pageNum");
int pageStartNum = (int) request.getAttribute("pageStartNum");
int pageEndNum = (int) request.getAttribute("pageEndNum");
int pageCount = (int) request.getAttribute("pageCount");
String msg = (String) request.getAttribute("msg");
boolean alertFlag=(request.getAttribute("alertFlag")==null)?false:(boolean)request.getAttribute("alertFlag");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시판</title>
<script src="https://kit.fontawesome.com/6ff644124c.js"
	crossorigin="anonymous"></script>
<%@ include file="/home/css/commonCss.jsp"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/home/board/css/boardPage.css" />

<script>
<%if (alertFlag) {%>
alert("<%=msg%>"); 
window.location.replace("<%=request.getContextPath()%>/home/board/boardPage.jsp");
<%}%>
</script>

</head>
<body>
	<header>
		<nav class="headerNav">
			<%@ include file="/home/headerNavSection.jsp"%>
		</nav>
	</header>
	
	<main class="boardPage">
		<header class="boardHeader">
		<h1>자유게시판</h1>
	</header>
		<article class="article2">
			<p class="notice">- 본 게시판과 관련이 없거나 상업적인 내용, 특정인이나 특정사안을 비방하는 내용
				등은 예고없이 삭제될 수 있습니다.</p>
		</article>
		<article class="article3">
			<div class="all">
				<form method="get" action="/jspHomePage/boardSelect.do">
					<select name="viewTime" id="view">
						<option value="10"
							<%=(viewTime == 10) ? "selected='selected'" : ""%>>10개씩</option>
						<!-- viewTime에 맞춰서 select변경 -->
						<option value="20"
							<%=(viewTime == 20) ? "selected='selected'" : ""%>>20개씩</option>
						<!-- viewTime에 맞춰서 select변경 -->
					</select>
					<button type="submit" id="BoardViewButton">보기</button>
				</form>
				<form method="get" action="/jspHomePage/boardFindSelect.do">
					<select name="findValue" id="find">
						<option value="title">제목</option>
						<option value="text">내용</option>
					</select> <input type="text" name="findText" id="findText" />
					<button type="submit" id="findButton">검색</button>
				</form>
			</div>
		</article>
		<article class="article4">
			<table>
				<tr>
					<th>번호</th>
					<th width="800">제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>등록일</th>
				</tr>
				<%
				for (BoardVO data : bList) {
				%>
				<tr>
					<td class="tbNum"><%=data.getRownum()%></td>
					<td class="tbMain"><a
						href=" <%=request.getContextPath()%>/boardListSelect.do?no=<%=data.getNo()%>&count=1"><%=data.getTitle()%></a>&nbsp;&nbsp;
						[<%=data.getCommentNum()%>]</td>
					<td class="tbWriter"><%=data.getCustomerId()%></td>
					<td class="tbView"><%=data.getCount()%></td>
					<td class="tbDate"><%=sf.format(data.getSubdate())%></td>
				</tr>
				<%
				}
				%>

			</table>
		</article>
		<article class="article5">
			<ul>
				<li><i class="fa-solid fa-angles-left"
					onclick="location.href='/jspHomePage/boardSelect.do?viewTime=${viewTime}&pageNum=1'"></i></li>
				<li><i class="fa-solid fa-angle-left"
					onclick="location.href='/jspHomePage/boardSelect.do?viewTime=${viewTime}&pageNum=${pageNum - 1 < 0 ? 1 : pageNum - 1}'"></i></li>
				<%
				for (int i = pageStartNum; i <= pageEndNum; i++) {
				%>
				<li <%=(pageNum == i) ? "class='active'" : ""%>
					onclick="location.href='/jspHomePage/boardSelect.do?viewTime=${viewTime}&pageNum=<%=i%>'">
					<%=i%>
				</li>
				<%
				}
				%>
				<li><i class="fa-solid fa-chevron-right"
					onclick="location.href='/jspHomePage/boardSelect.do?viewTime=${viewTime}&pageNum=${pageNum + 1 > pageCount? pageCount : pageNum + 1}'"></i></li>
				<li><i class="fa-solid fa-angles-right"
					onclick="location.href='/jspHomePage/boardSelect.do?viewTime=${viewTime}&pageNum=${pageCount}'"></i></li>
			</ul>

			<form action="#" method="get" name="boardWrite.do">
				<button type="button" id="writeButton" onclick=<%=(cvo == null) ? "openLoginPopup()" : "location.href='/jspHomePage/home/board/boardWritePage.jsp';"%>>글쓰기</button>
			</form>
		</article>
	</main>
	<hr>
	<footer>
		<%@ include file="/home/footerSection.jsp"%>
	</footer>
	<script src="<%=request.getContextPath()%>/home/js/common.js"></script>
</body>
</html>
