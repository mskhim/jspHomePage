<%@page import="co.kh.dev.home.model.CustomerDAO"%>
<%@page import="co.kh.dev.home.model.CustomerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    CustomerDAO cDAO = CustomerDAO.getInstance(); 
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	CustomerVO cvo = new CustomerVO();
	cvo.setId(id);
	cvo.setPwd(pwd);
	boolean idFlag = cDAO.selectByIdDB(cvo);
	boolean loginFlag = cDAO.selectLoginCheckDB(cvo);
	
	try {
		if (!idFlag) {
			response.sendRedirect("/jspStudy/member/memberLogin.jsp?error=2");//아이디일치 x
		}else {
			if (!loginFlag) {
				response.sendRedirect("/jspStudy/member/memberLogin.jsp?error=1");//비밀번호일치 x
			}else {
				session.setAttribute("id", id);
				session.setAttribute("pwd", pwd);
				response.sendRedirect("/jspStudy/member/memberLogin.jsp");
			}
			
		}

		
	} catch (Exception e) {
		e.printStackTrace();
	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>