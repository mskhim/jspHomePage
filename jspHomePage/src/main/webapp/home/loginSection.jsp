<%@page import="co.kh.dev.common.MyUtility"%>
<%@ page contentType="text/html; charset=UTF-8"%>


<%
String name = (String) session.getAttribute("name");
if (MyUtility.isNullOrEmpty(name)) {
%>
	 <script>
	<%if(request.getParameter("error")!=null&&request.getParameter("error").equals("2")){ %>
            alert("아이디 또는 비밀번호가 맞지 않습니다.");
	<%} else{ if(request.getParameter("error")!=null&&request.getParameter("error").equals("1")){ %>
            alert("비밀번호가 맞지 않습니다.");
	
	<%}}  %>
   </script>
   <article class="loginInput">
	<form method="post" action="loginCheck.jsp">
		 <ul>
              <li>
                <input
                  type="text"
                  name="id"
                  id="id"
                  placeholder=" 아이디 또는 전화번호"
                />
              </li>
              <li>
                <input
                  type="password"
                  name="psw"
                  id="psw"
                  placeholder=" 비밀번호"
                />
              </li>
            </ul>
            <!-- 상태유지 -->
            <div class="maint">
              <input type="checkbox" name="maint" class="maint" />
              <label for="maint">로그인 상태 유지</label>
            </div>
            <!-- 로그인 버튼 -->
            <button type="submit">로그인</button>
	</form>
	</article>
	 <nav class="loginNav">
        <ul style=" display: flex">
          <li><a href="#">비밀번호 찾기</a></li>
          <li><a href="#">아이디 찾기</a></li>
          <li><a href="registPage.jsp">회원가입</a></li>
        </ul>
      </nav>
<%
} else {
%>
	<table border="1" width="300" align="center" class="loginPage">
		<tr>
			<td width="300" align="center"><%=name%> 님 로그인 되었습니다.</td>
		</tr>
	</table>
	<div class="buttons">
	<a href="/jspStudy/member/memberMyPage.jsp"><input type="button"
						value="마이페이지"></a>
				&nbsp;&nbsp;<a href="/jspStudy/board/boardMain.jsp"><input type="button"
						value="게시판"></a>
				&nbsp;&nbsp; <a href="/jspStudy/memberLogoutServlet.do"><input type="button"
						value="로그아웃"></a>
		</div>
<%
}
%>