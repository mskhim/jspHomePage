package co.kh.dev.home.action.notice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.kh.dev.home.action.Action;
import co.kh.dev.home.control.ActionForward;
import co.kh.dev.home.model.NoticeDAO;
import co.kh.dev.home.model.NoticeVO;

public class NoticeListSelectAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	NoticeDAO bDAO = NoticeDAO.getInstance();
    	NoticeVO bvo = new NoticeVO();
		request.setCharacterEncoding("UTF-8");
    	bvo.setNo(Integer.parseInt(request.getParameter("no")));
    	bvo = bDAO.selectByNoDB(bvo);
    	bvo.setCount(bvo.getCount() + ((request.getParameter("count")==null)?0:1));
    	bDAO.updateDB(bvo);
    	request.setAttribute("bvo",bvo);
		ActionForward forward = new ActionForward("/home/notice/noticeListPage.jsp", false);
		return forward;
	}

}
