<%@page import="java.text.SimpleDateFormat"%>
<%@page import="co.kh.dev.home.model.CommentDAO"%>
<%@page import="co.kh.dev.home.model.NoticeDAO"%>
<%@page import="co.kh.dev.home.model.NoticeVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
CustomerVO cvo = MyUtility.returnCvoBySession(session);
CommentDAO cmDAO = CommentDAO.getInstance();
if (request.getAttribute("bList") == null) {//강제로 접근시 서블릿으로 보내는 기능
	response.sendRedirect("/jspHomePage/noticeSelect.do");
	return;
}
SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd   HH:mm");
ArrayList<NoticeVO> bList = (ArrayList<NoticeVO>) request.getAttribute("bList");
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
<title>공지사항</title>
<script src="https://kit.fontawesome.com/6ff644124c.js"
	crossorigin="anonymous"></script>
<%@ include file="/home/css/commonCss.jsp"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/home/notice/css/noticePage.css" />

<script>
<%if (alertFlag) {%>
alert("<%=msg%>"); 
window.location.replace("<%=request.getContextPath()%>/home/notice/noticePage.jsp");
<%}%>
</script>

</head>
<body>
	<header>
		<nav class="headerNav">
			<%@ include file="/home/headerNavSection.jsp"%>
		</nav>
	</header>
	
	<main class="noticePage">
		<header class="noticeHeader">
		<h1>공지사항</h1>
	</header>
		<article class="article2">
		</article>
		<article class="article3">
			<div class="all">
				<form method="get" action="/jspHomePage/noticeSelect.do">
					<select name="viewTime" id="view">
						<option value="10"
							<%=(viewTime == 10) ? "selected='selected'" : ""%>>10개씩</option>
						<!-- viewTime에 맞춰서 select변경 -->
						<option value="20"
							<%=(viewTime == 20) ? "selected='selected'" : ""%>>20개씩</option>
						<!-- viewTime에 맞춰서 select변경 -->
					</select>
					<button type="submit" id="NoticeViewButton">보기</button>
				</form>
				<form method="get" action="/jspHomePage/noticeFindSelect.do">
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
					<th>조회수</th>
					<th>등록일</th>
				</tr>
				<%
				for (NoticeVO data : bList) {
				%>
				<tr>
					<td class="tbNum"><%=data.getRownum()%></td>
					<td class="tbMain"><a
						href=" <%=request.getContextPath()%>/noticeListSelect.do?no=<%=data.getNo()%>&count=1"><%=data.getTitle()%></a></td>
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
					onclick="location.href='/jspHomePage/noticeSelect.do?viewTime=${viewTime}&pageNum=1'"></i></li>
				<li><i class="fa-solid fa-angle-left"
					onclick="location.href='/jspHomePage/noticeSelect.do?viewTime=${viewTime}&pageNum=${pageNum - 1 < 0 ? 1 : pageNum - 1}'"></i></li>
				<%
				for (int i = pageStartNum; i <= pageEndNum; i++) {
				%>
				<li <%=(pageNum == i) ? "class='active'" : ""%>
					onclick="location.href='/jspHomePage/noticeSelect.do?viewTime=${viewTime}&pageNum=<%=i%>'">
					<%=i%>
				</li>
				<%
				}
				%>
				<li><i class="fa-solid fa-chevron-right"
					onclick="location.href='/jspHomePage/noticeSelect.do?viewTime=${viewTime}&pageNum=${pageNum + 1 > pageCount? pageCount : pageNum + 1}'"></i></li>
				<li><i class="fa-solid fa-angles-right"
					onclick="location.href='/jspHomePage/noticeSelect.do?viewTime=${viewTime}&pageNum=${pageCount}'"></i></li>
			</ul>

			<form action="#" method="get" name="noticeWrite.do">
				<button type="button" id="writeButton" <% %>>글쓰기</button>
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
