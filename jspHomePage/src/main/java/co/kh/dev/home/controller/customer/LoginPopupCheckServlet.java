package co.kh.dev.home.controller.customer;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.kh.dev.home.model.CustomerDAO;
import co.kh.dev.home.model.CustomerVO;

@WebServlet({ "/BoardLoginPopupCheckServlet.do" })
public class LoginPopupCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginPopupCheckServlet() {
        super();
    }
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
    	CustomerDAO cDAO = CustomerDAO.getInstance(); 
     	HttpSession session = request.getSession(false);
     	String id = request.getParameter("id");
     	String pwd = request.getParameter("pwd");
     	String maint = request.getParameter("maint");
     	CustomerVO cvo = new CustomerVO();
     	cvo.setId(id);
     	cvo.setPwd(pwd);
     	try {
     		if (cDAO.selectByIdDB(cvo)==null) {
     	response.sendRedirect(request.getContextPath()+"/loginPopupPageAlertServlet.do?status=4");//아이디일치 x
     		}else {
     	if (cDAO.selectLoginCheckDB(cvo)==null) {
     		response.sendRedirect(request.getContextPath()+"/loginPopupPageAlertServlet.do?status=5");//비밀번호일치 x
     	}else {
     		if (maint != null) {
				Cookie ck = new Cookie("id", id);
				response.addCookie(ck);
			}
     		session.setAttribute("id", id);
     		session.setAttribute("pwd", pwd);
     		response.sendRedirect(request.getContextPath()+"/loginPopupPageAlertServlet.do?status=3");
     	}
     		}
     	} catch (Exception e) {
     		e.printStackTrace();
     	}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		processRequest(request, response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		processRequest(request, response);
	}

}