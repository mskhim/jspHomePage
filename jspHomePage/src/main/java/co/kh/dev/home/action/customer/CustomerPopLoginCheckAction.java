package co.kh.dev.home.action.customer;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import co.kh.dev.home.action.Action;
import co.kh.dev.home.control.ActionForward;
import co.kh.dev.home.model.CustomerDAO;
import co.kh.dev.home.model.CustomerVO;

public class CustomerPopLoginCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = null;
		CustomerDAO cDAO = CustomerDAO.getInstance();
		HttpSession session = request.getSession(false);
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String maint = request.getParameter("maint");
		CustomerVO cvo = new CustomerVO();
		cvo.setId(id);
		cvo.setPwd(pwd);
			if (cDAO.selectByIdDB(cvo) == null) {
				forward = new ActionForward(request.getContextPath() + "/popLoginAlert.do?status=4", true);//아이디 x
				return forward;
			} else {
				if (cDAO.selectLoginCheckDB(cvo) == null) {
					forward = new ActionForward(request.getContextPath() + "/popLoginAlert.do?status=5", true);//비밀번호x
					return forward;
				} else {
					if (maint != null) {
						Cookie ck = new Cookie("id", id);
						response.addCookie(ck);
					}
					session.setAttribute("id", id);
					session.setAttribute("pwd", pwd);
				}
			}
		forward = new ActionForward(request.getContextPath() + "/popLoginAlert.do?status=3", true);
		return forward;
	}

}