package co.kh.dev.home.action.shop;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.kh.dev.home.action.Action;
import co.kh.dev.home.control.ActionForward;
import co.kh.dev.home.model.ShopDAO;
import co.kh.dev.home.model.ShopImgDAO;
import co.kh.dev.home.model.ShopImgVO;
import co.kh.dev.home.model.ShopVO;

public class ShopListSelectAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(false);
		ShopVO svo1= null;
		ShopVO svo2= null;
		ShopVO svo3= null;
		if(session.getAttribute("svo1")!=null) {svo1=(ShopVO)session.getAttribute("svo1");}
		if(session.getAttribute("svo2")!=null) {svo2=(ShopVO)session.getAttribute("svo2");}
		if(session.getAttribute("svo3")!=null) {svo3=(ShopVO)session.getAttribute("svo3");}
		ShopDAO sDAO = ShopDAO.getInstance();
    	ShopImgDAO siDAO = ShopImgDAO.getInstance();
    	ShopVO svo = new ShopVO();
    	ShopImgVO sivo = new ShopImgVO();
		ArrayList<ShopImgVO> siList= new ArrayList<ShopImgVO>();
    	request.setCharacterEncoding("UTF-8");
    	svo.setNo(Integer.parseInt(request.getParameter("no")));
    	svo.setType(Integer.parseInt(request.getParameter("type")));
    	svo = sDAO.selectListDB(svo);
    	sivo.setShopNo(svo.getNo());
    	System.out.println(svo.getRownum());
    	siList= siDAO.selectContentDB(sivo);
    	request.setAttribute("svo",svo);
    	request.setAttribute("siList",siList);
    	session.setAttribute("svo1", svo);
    	session.setAttribute("svo2", svo1);
    	session.setAttribute("svo3", svo2);
    	session.setAttribute("svo4", svo3);
    	
		ActionForward forward = new ActionForward("/home/shop/shopListPage.jsp", false);
		return forward;
	}

}