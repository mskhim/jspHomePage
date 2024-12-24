package co.kh.dev.home.action.shop;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.kh.dev.home.action.Action;
import co.kh.dev.home.control.ActionForward;
import co.kh.dev.home.model.ShopDAO;
import co.kh.dev.home.model.ShopVO;

public class ShopCartSelectAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("id") == null) {
            // 로그인 정보가 없으면 메인 페이지로 리다이렉트
            ActionForward forward = new ActionForward(request.getContextPath() + "/mainPageAlert.do?status=", true);
            return forward;
        }

        String userId = (String) session.getAttribute("id");

        // 쿠키에서 장바구니 데이터 읽기
        Cookie[] cookies = request.getCookies();
        String cartData = "";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(userId)) {
                    // 쿠키 값 디코딩
                    cartData = URLDecoder.decode(cookie.getValue(), "UTF-8");
                    break;
                }
            }
        }

        // 쿠키 데이터가 비어 있는 경우 빈 리스트 설정 및 JSP로 포워딩
        if (cartData.isEmpty()) {
            request.setAttribute("sList", new ArrayList<ShopVO>());
            ActionForward forward = new ActionForward("/home/shop/shopCartPage.jsp", false);
            return forward;
        }

        // 상품 번호 리스트로 변환
        String[] productNos = cartData.split(",");

        // ShopDAO를 이용하여 상품 정보를 가져옴
        ShopDAO sDAO = ShopDAO.getInstance();
        ArrayList<ShopVO> sList = new ArrayList<>();
        for (String productNo : productNos) {
            try {
                int no = Integer.parseInt(productNo.trim());
                ShopVO svo = new ShopVO();
                svo.setNo(no);
                ShopVO svo2 = sDAO.selectByNoDB(svo);
                if (svo2 != null) {
                    sList.add(svo2);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        // 가져온 상품 리스트를 request에 설정
        request.setAttribute("sList", sList);

        // JSP로 포워딩
        ActionForward forward = new ActionForward("/home/shop/shopCartPage.jsp", false);
        return forward;
    }
}
