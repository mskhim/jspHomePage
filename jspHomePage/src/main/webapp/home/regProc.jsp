<%@page import="co.kh.dev.home.model.CustomerDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("utf-8");
CustomerDAO cdao = CustomerDAO.getInstance();
%>
<jsp:useBean id="cvo" class="co.kh.dev.home.model.CustomerVO" />
<jsp:setProperty name="cvo" property="*" />
<% 
System.out.println(cvo.toString());
boolean flag = cdao.insertDB(cvo);
%>
<html>
<head>
<title>회원가입 확인</title></head>
<link href="style.css" rel="stylesheet" type="text/css">
<body bgcolor="#FFFFCC">
<br></br>
<main>
<%
if(flag){
 out.println("<b>회원가입을 축하 드립니다.</b><br/>");
 out.println("<a href=login.jsp>로그인</a>");
}else{
 out.println("<b>다시 입력하여 주십시오.</b><br/>");
 out.println("<a href=regForm.jsp>다시 가입</a>");
}
%>
</main>
</body>
</html>