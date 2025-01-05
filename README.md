# 🛍 JSP 기반 홈페이지: 쇼핑몰 시스템

## 📅 프로젝트 개요

- **프로젝트 이름**: ShoppingMallService
- **제작 기간**: 2024년 12월 11일 ~ 1월 2일
- **목적**: 사용자와 관리자를 위한 직관적이고 효율적인 쇼핑몰 시스템 구축

---

## 🛠 개발 환경

### 언어 및 플랫폼

- **Java**
  - JDK 21.0.4
  - Eclipse IDE

- **Servlet & JSP**
  - Servlet 3.0
  - JSP 페이지로 UI 구현
  - **MVC2 패턴** 적용으로 역할 분리

### 템플릿 언어

- **EL(Expression Language)**: JSP 내 동적 데이터 처리에 활용
- **JSTL(JavaServer Pages Standard Tag Library)**: 반복문, 조건문 등의 표현을 간소화

### 서버

- **Apache Tomcat**
  - 버전: 9.0

### 데이터베이스

- **Oracle DB**
  - 버전: 21c Express Edition
  - SQL Developer로 데이터베이스 관리

---

## 📌 주요 기능

### 사용자용 기능

1. **회원가입 및 로그인**
   - 신규 사용자 회원가입 및 중복 확인 기능
   - 로그인 및 세션 관리
2. **상품 조회**
   - 로그인 없이 상품 정보 조회 가능
   - 카테고리 및 키워드 기반 검색
3. **장바구니 관리**
   - 상품 추가, 수정 및 삭제 가능
4. **주문 관리**
   - 주문 내역 조회 및 상태 확인
5. **마이페이지**
   - 개인정보 확인 및 수정
   - 회원 탈퇴 기능 제공

### 관리자용 기능

1. **상품 관리**
   - 상품 등록, 수정, 삭제
2. **공지사항 관리**
   - 공지사항 등록, 수정, 삭제
3. **회원 관리**
   - 사용자 정보 관리

---

## 🗂 데이터베이스 설계

### 주요 테이블

1. **PRODUCT**: 상품 정보 관리
   - **주요 컬럼**: 상품 ID, 이름, 설명, 가격, 재고 수량
2. **CART**: 장바구니 정보
   - **주요 컬럼**: 사용자 ID, 상품 ID, 수량
3. **ORDER**: 주문 정보
   - **주요 컬럼**: 주문 ID, 사용자 ID, 주문 날짜, 상태
4. **CUSTOMER**: 사용자 정보
   - **주요 컬럼**: 사용자 ID, 이름, 이메일, 전화번호
5. **NOTICE**: 공지사항 정보
   - **주요 컬럼**: 공지 ID, 제목, 내용, 작성 날짜

### ERD

![image](https://github.com/user-attachments/assets/e8a3d788-aead-4b81-9261-a0c087dae321)


---

## 🚀 실행 방법

1. **환경 설정**:
   - Oracle DB 21c Express Edition 설치 후 데이터베이스 테이블 생성
   - `src/main/java/co/kh/dev/common/db.properties` 파일에서 데이터베이스 연결 정보 수정
2. **Tomcat 서버 설정**:
   - Apache Tomcat 9.0 설치 후 프로젝트 배포
   - `/WEB-INF/web.xml`에 정의된 URL 패턴 확인
3. **구동**:
   - 브라우저에서 `http://localhost:8080/ShoppingMallService`로 접속

---

## 🌟 핵심 트러블 슈팅

1. **공지사항 페이징 처리**
   - **뷰 생성**:
     ```sql
     CREATE OR REPLACE VIEW notice_rnum AS
     SELECT ROWNUM AS rnum, no, title, content, count, subdate
     FROM (SELECT * FROM notice ORDER BY subdate DESC)
     ORDER BY rnum;
     ```
   - **문제 해결**: 공지사항 목록이 많아질 경우 서버 부하를 줄이기 위해 페이징 처리 구현.

2. **회원가입 시 중복 확인**
   - **문제**: 중복된 사용자 ID가 입력될 경우 데이터베이스 오류 발생.
   - **해결 방법**:
     ```sql
     ALTER TABLE CUSTOMER ADD CONSTRAINT CUSTOMER_ID_PK PRIMARY KEY(ID);
     ```
     - 회원가입 시 프론트엔드에서 AJAX로 실시간 중복 체크.

3. **장바구니 동시 접근 문제**
   - **문제**: 여러 사용자가 동일한 상품에 대해 장바구니를 동시에 수정할 때 데이터 충돌 발생.
   - **해결 방법**:
     ```sql
     ALTER TABLE CART ADD CONSTRAINT cart_user_product_unique UNIQUE (USER_ID, PRODUCT_ID);
     ```
     - 동시성 문제를 해결하기 위해 데이터베이스 제약 조건추가.

---

## 💡 추가 정보

- 프로젝트 경로에 포함된 `docs` 폴더에서 자세한 SQL 스크립트와 설정 파일 확인 가능
- CSS 및 JavaScript 파일은 `src/main/webapp/home`에 포함되어 있으며, 프로젝트의 UI/UX를 개선하기 위해 활용됨

---

## 📜 라이선스

본 프로젝트는 MIT 라이선스를 따릅니다.
