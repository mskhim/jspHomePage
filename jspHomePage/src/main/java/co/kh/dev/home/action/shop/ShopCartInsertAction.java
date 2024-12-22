package co.kh.dev.home.action.shop;

import java.io.IOException;
import java.net.URLEncoder;
import java.net.URLDecoder;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.kh.dev.home.action.Action;
import co.kh.dev.home.control.ActionForward;

public class ShopCartInsertAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);

        String userId = (String) session.getAttribute("id");
        if (userId == null) {
            ActionForward forward = new ActionForward(request.getContextPath() + "/loginPage.do", true);
            return forward;
        }

        String newProductNo = request.getParameter("no");
        if (newProductNo == null || newProductNo.isEmpty()) {
            ActionForward forward = new ActionForward(request.getContextPath() + "/errorPage.do?error=missingProductNo", true);
            return forward;
        }

        // 쿠키 리스트에서 사용자의 ID를 키로 검색
        Cookie[] cookies = request.getCookies();
        String existingCart = ""; // 기존 장바구니 데이터
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(userId)) {
                    existingCart = URLDecoder.decode(cookie.getValue(), "UTF-8"); // 디코딩
                    break;
                }
            }
        }

        // Set을 사용하여 중복 제거
        Set<String> productSet = new LinkedHashSet<>();
        if (!existingCart.isEmpty()) {
            productSet.addAll(Arrays.asList(existingCart.split(","))); // 기존 데이터 추가
        }
        productSet.add(newProductNo); // 새 상품 번호 추가

        // Set을 문자열로 변환
        String newCart = String.join(",", productSet);
        String encodedCart = URLEncoder.encode(newCart, "UTF-8"); // 인코딩

        // 쿠키에 저장
        Cookie cartCookie = new Cookie(userId, encodedCart);
        cartCookie.setMaxAge(7 * 24 * 60 * 60); // 7일 유효
        cartCookie.setPath("/"); // 모든 경로에서 접근 가능
        response.addCookie(cartCookie);

        // 장바구니 추가 성공 후 리다이렉트
        ActionForward forward = new ActionForward(request.getContextPath() + "/shopPageAlert.do?type=" + request.getParameter("type") + "&status=4", true);
        return forward;
    }
}
