package co.kh.dev.home.action.mainPage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.kh.dev.home.action.Action;
import co.kh.dev.home.control.ActionForward;
import co.kh.dev.home.model.BoardDAO;
import co.kh.dev.home.model.BoardVO;

public class miniBoardSelectAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BoardDAO bDAO = BoardDAO.getInstance();
    	int viewTime = 5; 						 // 한페이지에 보여줄 리스트 개수
    	int recordCount = bDAO.selectRecordDB(); //전체 리스트 개수 findText값이 있을시 해당 항목으로 변경
		int startListNum =(recordCount-viewTime<0)?1:recordCount-viewTime;	 //출력할 리스트번호 시작
		int endListNum =recordCount;			 //출력할 리스트번호 마지막
		ArrayList<BoardVO> bList = bDAO.selectDB(startListNum, endListNum);//원하는 구간의 db를 출력
		request.setAttribute("bList", bList);
		ActionForward forward = new ActionForward("/mainPageAlert.do", false);
		return forward;
	}

}