<%@page import="co.kh.dev.home.model.CommentVO"%>
<%@page import="co.kh.dev.common.MyUtility"%>
<%@page import="co.kh.dev.home.model.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="co.kh.dev.home.model.CustomerVO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd   HH:mm");
ArrayList<BoardVO> bList = (ArrayList<BoardVO>) request.getAttribute("bList");
%>
<article class="boardArticle">
	<h3>게시판 요약</h3>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성일자</th>
			</tr>
		</thead>
		<tbody>
	 		<%
			int count = 0;
			for (BoardVO data : bList) {
				count++;
			%>
			<tr>
				<td class="tbNum"><%=count%></td>
				<td class="tbMain"><a
					href=" <%=request.getContextPath()%>/boardListSelect.do?no=<%=data.getNo()%>&count=1"><%=data.getTitle()%></a></td>
				<td class="tbDate"><%=sf.format(data.getSubdate())%></td>
			</tr>
			<%
			}
			%> 

		</tbody>
	</table>
	<a href="<%=request.getContextPath()%>/boardSelect.do"
		class="moreButton">더보기</a>
</article>

