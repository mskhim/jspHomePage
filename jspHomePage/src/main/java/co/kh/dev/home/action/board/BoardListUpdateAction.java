package co.kh.dev.home.action.board;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.kh.dev.home.action.Action;
import co.kh.dev.home.control.ActionForward;
import co.kh.dev.home.model.BoardDAO;
import co.kh.dev.home.model.BoardVO;

public class BoardListUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BoardDAO bDAO = BoardDAO.getInstance();
		request.setCharacterEncoding("UTF-8");
		BoardVO bvo = new BoardVO(Integer.parseInt(request.getParameter("no")), request.getParameter("title"),
				request.getParameter("content"));
		bDAO.updateDB(bvo);
		ActionForward forward = new ActionForward(request.getContextPath() + "/boardPageAlertServlet.do?status=2",
				false);
		return forward;
	}

}