<%@ page contentType="text/html; charset=UTF-8" %>
<section class="productArticle">
    <h3>상품 요약</h3>
    <div class="productGrid">
        <!-- 상품 1 -->
        <div class="productItem">
            <img src="<%=request.getContextPath()%>/images/product1.jpg" alt="상품 1 이미지">
            <div class="price">10,000원</div>
            <div class="name">상품 1</div>
        </div>
        <!-- 상품 2 -->
        <div class="productItem">
            <img src="<%=request.getContextPath()%>/images/product2.jpg" alt="상품 2 이미지">
            <div class="price">20,000원</div>
            <div class="name">상품 2</div>
        </div>
        <!-- 상품 3 -->
        <div class="productItem">
            <img src="<%=request.getContextPath()%>/images/product3.jpg" alt="상품 3 이미지">
            <div class="price">30,000원</div>
            <div class="name">상품 3</div>
        </div>
        <!-- 상품 4 -->
        <div class="productItem">
            <img src="<%=request.getContextPath()%>/images/product4.jpg" alt="상품 4 이미지">
            <div class="price">40,000원</div>
            <div class="name">상품 4</div>
        </div>
    </div>
    <a href="<%=request.getContextPath()%>/productList.do" class="moreButton">더보기</a>
</section>
