package co.kh.dev.home.action.shop;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.kh.dev.home.action.Action;
import co.kh.dev.home.control.ActionForward;

public class ShopOrderSelectAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	String[] cartNoList= request.getParameterValues("cartNo");
    	ArrayList<String> qtList = new ArrayList<String>();
    	ArrayList<String> shopNoList = new ArrayList<String>();
    	for(String data:cartNoList) {
    		qtList.add(request.getParameter("qt"+data));
    		shopNoList.add(request.getParameter("shopNo"+data));
    	}
    	
    	
    	for(int i =0 ;i<qtList.size();i++) {
    		
    		
    	}
    	
        ActionForward forward = new ActionForward("/home/shop/shopCartPage.jsp", false);
        return forward;
    }
}