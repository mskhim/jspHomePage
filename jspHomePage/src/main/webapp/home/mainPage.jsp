<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메인 화면</title>
<script src="https://kit.fontawesome.com/6ff644124c.js"	crossorigin="anonymous"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/home/css/common.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/home/css/MainPageStyle.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/home/css/carouselStyle.css" />

</head>
<body>
    <nav class="menu">Menu</nav>
<header>
 <div class="carousel">
<%@ include file="/home/carousel.jsp"%>
</div>
</header>
    <div class="container">
        <div class="side-menu">Side Menu</div>
        <div class="main-section">
            <!-- 게시판 요약 정보 -->
            <div class="board-summary">
                <h3>게시판 요약</h3>
                <table>
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>제목</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td>게시판 테스트 제목</td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>다른 게시판 제목</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <!-- 상품 요약 정보 -->
            <div class="product-summary">
                <h3>상품 요약</h3>
                <table>
                    <thead>
                        <tr>
                            <th>상품명</th>
                            <th>가격</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>상품 1</td>
                            <td>10,000원</td>
                        </tr>
                        <tr>
                            <td>상품 2</td>
                            <td>20,000원</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="login">Login</div>
    </div>
        <hr>
    <footer>
     <%@ include file="/home/footer.jsp" %>
    </footer>
</body>

</html>

