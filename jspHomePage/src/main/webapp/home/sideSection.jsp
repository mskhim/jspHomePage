<%@ page contentType="text/html; charset=UTF-8"%>
<section class="noticeSection">
    <h3>공지사항</h3>
    <ul class="noticeList">
        <!-- 공지사항 데이터를 동적으로 표시 -->
        <li>
            <a href="<%=request.getContextPath()%>/noticeDetail.do?id=1">
                공지사항 제목 1
            </a>
            <span class="date">2024-12-19</span>
        </li>
        <li>
            <a href="<%=request.getContextPath()%>/noticeDetail.do?id=2">
                공지사항 제목 2
            </a>
            <span class="date">2024-12-18</span>
        </li>
        <li>
            <a href="<%=request.getContextPath()%>/noticeDetail.do?id=3">
                공지사항 제목 3
            </a>
            <span class="date">2024-12-17</span>
        </li>
    </ul>
    <a href="<%=request.getContextPath()%>/noticeList.do" class="moreButton">더보기</a>
</section>
<section class="recentProductSection">
    <h3>최근 본 상품</h3>
    <ul class="recentProductList">
        <!-- 최근 본 상품 데이터를 동적으로 표시 -->
        <li>
            <span class="name">상품 1</span>
            <span class="price">10,000원</span>
        </li>
        <li>
            <span class="name">상품 2</span>
            <span class="price">20,000원</span>
        </li>
        <li>
            <span class="name">상품 3</span>
            <span class="price">30,000원</span>
        </li>
    </ul>
      <a href="<%=request.getContextPath()%>/noticeList.do" class="moreButton">더보기</a>
</section>