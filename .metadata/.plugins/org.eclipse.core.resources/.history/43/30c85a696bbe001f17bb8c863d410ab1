<%@page import="java.text.SimpleDateFormat"%>
<%@page import="co.kh.dev.home.model.CommentDAO"%>
<%@page import="co.kh.dev.home.model.CommentVO"%>
<%@page import="co.kh.dev.home.model.NoticeDAO"%>
<%@page import="co.kh.dev.home.model.NoticeVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%
SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd   HH:mm");
CustomerVO cvo = MyUtility.returnCvoBySession(session);
ArrayList<CommentVO> cmList = (ArrayList<CommentVO>) request.getAttribute("cmList");
NoticeVO bvo = (NoticeVO) request.getAttribute("bvo");
if (bvo == null) {
	response.sendRedirect("/jspHomePage/home/notice/noticePage.jsp");
}
String msg=(String)request.getAttribute("msg");
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
	href="<%=request.getContextPath()%>/home/notice/css/noticeContentPage.css" />
	<%
if(alertFlag){
%>	
<script>
alert("<%=msg%>");
window.location.replace("<%=request.getContextPath()%>/noticeListSelect.do?no=<%=bvo.getNo()%>");
</script>
<%
}
%>
</head>
<body>
	<header>
		<nav class="headerNav">
			<%@ include file="/home/headerNavSection.jsp"%>
		</nav>
	</header>
	<main class="noticeContentPage">
		<section class="noticeView">
			<h2>게시글 상세 조회</h2>
			<!-- 게시글 상세 정보 -->
			<div class="postDetail">
				<table>
					<tr>
						<th>제목</th>
						<td id="postTitle"><%=bvo.getTitle()%></td>
					</tr>
					<tr>
						<th>작성일</th>
						<td id="postDate"><%=sf.format(bvo.getSubdate())%></td>
					</tr>
					<tr>
						<th>조회수</th>
						<td id="postDate"><%=bvo.getCount()%></td>
					</tr>
				</table>
				<div id="postContent"><%=bvo.getContent()%></div>

				<div
					class=<%=(cvo != null && "admin".equals(cvo.getId())) ? "postActions" : "dispNone"%>>
					<form method="post"
						action="/jspHomePage/home/notice/noticeListUpdatePage.jsp">
						<input type="hidden" name="no" value="<%=bvo.getNo()%>"> <input
							type="hidden" name="title" value="<%=bvo.getTitle()%>"> <input
							type="hidden" name="content" value="<%=bvo.getContent()%>">
						<button type="submit" class="editBtn">수정</button>
					</form>
					<button type="button" class="deleteBtn"
						onclick="deletePost(<%=bvo.getNo()%>)">삭제</button>
				</div>
			</div>
		</section>
		<div class="toList">
			<button onclick="location.href='<%=request.getContextPath()%>/home/notice/noticePage.jsp'">목록으로</button>
		</div>
	</main>

	<hr>
	<footer>
		<%@ include file="/home/footerSection.jsp"%>
	</footer>
	<script src="<%=request.getContextPath()%>/home/notice/js/noticeContentPage.js"></script>
	<script src="<%=request.getContextPath()%>/home/js/common.js"></script>
</body>
</html>