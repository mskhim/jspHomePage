<%@page import="co.kh.dev.home.model.ProductVO"%>
<%@page import="co.kh.dev.home.model.ProductDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>상품 등록</title>
<script src="https://kit.fontawesome.com/6ff644124c.js" crossorigin="anonymous"></script>
<%@ include file="/home/css/commonCss.jsp" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/home/shop/css/shopCartPage.css" />

</head>
<body>
<header>
    <nav class="headerNav">
        <%@ include file="/home/headerNavSection.jsp" %>
    </nav>
</header>
    <div class="cart-container">
        <h1>장바구니</h1>
        <form action="/orderAll.do" method="post">
            <table class="cart-table">
                <thead>
                    <tr>
                        <th><input type="checkbox" id="checkAll" onclick="toggleAll(this)"> 전체 선택</th>
                        <th>상품명</th>
                        <th>가격</th>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${not empty sList}">
                        <c:forEach var="product" items="${sList}">
                            <tr>
                                <td><input type="checkbox" name="productNo" value="${product.no}"></td>
                                <td>${product.title}</td>
                                <td><fmt:formatNumber value="${product.price}" pattern="#,##0"/>원</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty products}">
                        <tr>
                            <td colspan="3" style="text-align: center;">장바구니가 비어 있습니다.</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
            <div class="cart-actions">
                <button type="submit" class="order-all-btn">전체 주문하기</button>
            </div>
        </form>
    </div>



<br>
<hr>
<footer>
    <%@ include file="/home/footerSection.jsp" %>
</footer>
    <script>
        function toggleAll(checkbox) {
            const checkboxes = document.querySelectorAll('input[name="productNo"]');
            checkboxes.forEach(cb => cb.checked = checkbox.checked);
        }
    </script>
<script src="${pageContext.request.contextPath}/home/js/common.js"></script>
<script src="${pageContext.request.contextPath}/home/shop/js/shopInsertPage.js"></script>
</body>
</html>