/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.97
 * Generated at: 2024-12-16 09:01:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.home;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import co.kh.dev.common.MyUtility;
import co.kh.dev.home.model.CustomerVO;

public final class CustomerUpdatePage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/home/footer.jsp", Long.valueOf(1733897706878L));
    _jspx_dependants.put("/home/headerNav.jsp", Long.valueOf(1734066927819L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(3);
    _jspx_imports_classes.add("co.kh.dev.common.MyUtility");
    _jspx_imports_classes.add("co.kh.dev.home.model.CustomerVO");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

CustomerVO cvo = MyUtility.returnCvoBySession(session);
if(cvo==null){
response.sendRedirect(request.getContextPath()+"/mainPageAlertServlet.do?status=8");//로그인 안되있을시 메인으로가서 8번 경고문 출력
return;
}
String id = cvo.getId();
String pwd = cvo.getPwd();
String name = cvo.getName();
String nickName = cvo.getNickName();
String email = cvo.getEmail();
String tel = cvo.getTel();
String phone = cvo.getPhone();
String birth = cvo.getBirth(); // 생년월일이 Date 형식이라고 가정
String zipcode = cvo.getZipcode();
String address1 = cvo.getAddress1();
String address2 = cvo.getAddress2();

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>메인 화면</title>\r\n");
      out.write("	<script src=\"https://kit.fontawesome.com/6ff644124c.js\"	crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/home/css/common.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/home/css/headerNav.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/home/css/registPage.css\" />\r\n");
      out.write(" 	\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<header>\r\n");
      out.write(" <nav class=\"headerNav\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"headerNav\">\r\n");
      out.write("      <i class=\"fa-solid fa-cat\" onClick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/home/mainPage.jsp'\"></i>\r\n");
      out.write("	<ul class=\"mainMenu\">\r\n");
      out.write("		<li data-menu=\"one\">Item One</li>\r\n");
      out.write("		<li data-menu=\"two\">Item Two</li>\r\n");
      out.write("		<li data-menu=\"three\">Item Three</li>\r\n");
      out.write("		<li data-menu=\"four\">고객 지원</li>\r\n");
      out.write("	</ul>\r\n");
      out.write("	");

  CustomerVO cvo2 = MyUtility.returnCvoBySession(session);
  if(cvo2==null){
  
      out.write("\r\n");
      out.write("	<button class=\"Button\" class=\"authButton\" onClick=\"openLoginPopup();\">로그인</button>\r\n");
      out.write("	");

  } else{
  
      out.write("\r\n");
      out.write("	<button class=\"Button\" class=\"authButton\" onClick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/home/logout.jsp'\">로그아웃</button>\r\n");
      out.write("	");

  }
  
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"subMenuContainer\">\r\n");
      out.write("	<ul class=\"subMenu\" data-submenu=\"one\">\r\n");
      out.write("		<li><a href=\"#\">Submenu 1</a></li>\r\n");
      out.write("		<li><a href=\"#\">Submenu 2</a></li>\r\n");
      out.write("		<li><a href=\"#\">Submenu 3</a></li>\r\n");
      out.write("	</ul>\r\n");
      out.write("	<ul class=\"subMenu\" data-submenu=\"two\">\r\n");
      out.write("		<li><a href=\"#\">Submenu A</a></li>\r\n");
      out.write("		<li><a href=\"#\">Submenu B</a></li>\r\n");
      out.write("		<li><a href=\"#\">Submenu C</a></li>\r\n");
      out.write("	</ul>\r\n");
      out.write("	<ul class=\"subMenu\" data-submenu=\"three\">\r\n");
      out.write("		<li><a href=\"#\">Submenu X</a></li>\r\n");
      out.write("		<li><a href=\"#\">Submenu Y</a></li>\r\n");
      out.write("		<li><a href=\"#\">Submenu Z</a></li>\r\n");
      out.write("	</ul>\r\n");
      out.write("	<ul class=\"subMenu\" data-submenu=\"four\">\r\n");
      out.write("		<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/home/boardPage.jsp\">게시판</a></li>\r\n");
      out.write("		<li><a href=\"#\">Submenu Beta</a></li>\r\n");
      out.write("		<li><a href=\"#\">Submenu Gamma</a></li>\r\n");
      out.write("	</ul>\r\n");
      out.write("</div>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/home/js/headerNav.js\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/home/js/common.js\"></script>");
      out.write("\r\n");
      out.write("</nav>\r\n");
      out.write("</header>\r\n");
      out.write("    <main class=\"registPage\">\r\n");
      out.write("       <h4>정  보  수  정</h4>\r\n");
      out.write("    <form action=\"/jspHomePage/customerUpdateServlet.do\" method=\"post\" id=\"div-main\" class=\"myForm\" name=\"regForm\">\r\n");
      out.write("      <div class=\"title-table\">사이트 이용정보 수정</div>\r\n");
      out.write("      <table>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td class=\"col-key\">아이디</td>\r\n");
      out.write("          <td>\r\n");
      out.write("            <input\r\n");
      out.write("              id=\"input-id\"\r\n");
      out.write("              type=\"text\"\r\n");
      out.write("              name=\"id\"\r\n");
      out.write("              value=\"");
      out.print(id);
      out.write("\"\r\n");
      out.write("              required\r\n");
      out.write("              readonly=\"readonly\"\r\n");
      out.write("            /><span></span>\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td class=\"col-key\">비밀번호</td>\r\n");
      out.write("          <td>\r\n");
      out.write("            <input\r\n");
      out.write("              id=\"input-pw1\"\r\n");
      out.write("              type=\"password\"\r\n");
      out.write("              title=\"비밀번호는 영문자와 숫자 6~10자리입니다\"\r\n");
      out.write("              name=\"pwd\"\r\n");
      out.write("              value=\"");
      out.print(pwd);
      out.write("\"\r\n");
      out.write("              required\r\n");
      out.write("            /><span></span>\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td class=\"col-key\">비밀번호 확인</td>\r\n");
      out.write("          <td>\r\n");
      out.write("            <input\r\n");
      out.write("              id=\"input-pw2\"\r\n");
      out.write("              type=\"password\"\r\n");
      out.write("              name=\"\"\r\n");
      out.write("              value=\"");
      out.print(pwd);
      out.write("\"\r\n");
      out.write("              required\r\n");
      out.write("            /><span></span>\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("      </table>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"title-table\">개인정보 수정</div>\r\n");
      out.write("      <table>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td class=\"col-key\">이름</td>\r\n");
      out.write("          <td>\r\n");
      out.write("            <input\r\n");
      out.write("              id=\"input-name\"\r\n");
      out.write("              type=\"text\"\r\n");
      out.write("              name=\"name\"\r\n");
      out.write("              value=\"");
      out.print(name);
      out.write("\"\r\n");
      out.write("              required\r\n");
      out.write("            /><span></span>\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td class=\"col-key\">닉네임</td>\r\n");
      out.write("          <td>\r\n");
      out.write("            공백없이 한글,영문,숫자만 입력 가능(4글자 이상)<br />닉네임을\r\n");
      out.write("            바꾸시면 앞으로 1일 이내에는 변경 할 수 없습니다.<br />\r\n");
      out.write("            <input\r\n");
      out.write("              id=\"input-nickname\"\r\n");
      out.write("              type=\"text\"\r\n");
      out.write("              name=\"nickName\"\r\n");
      out.write("              value=\"");
      out.print(nickName);
      out.write("\"\r\n");
      out.write("              required\r\n");
      out.write("            /><span></span>\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td class=\"col-key\">E-mail</td>\r\n");
      out.write("          <td>\r\n");
      out.write("            <input\r\n");
      out.write("              id=\"input-email\"\r\n");
      out.write("              type=\"email\"\r\n");
      out.write("              name=\"email\"\r\n");
      out.write("              value=\"");
      out.print(email);
      out.write("\"\r\n");
      out.write("              required\r\n");
      out.write("            /><span></span>\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td class=\"col-key\">가입경로</td>\r\n");
      out.write("          <td>\r\n");
      out.write("            <input type=\"radio\" name=\"joinRoute\" value=\"\" />인터넷검색\r\n");
      out.write("            <input type=\"radio\" name=\"joinRoute\" value=\"\" />배너광고\r\n");
      out.write("            <input type=\"radio\" name=\"joinRoute\" value=\"\" />관련기사를 보고\r\n");
      out.write("            <input type=\"radio\" name=\"joinRoute\" value=\"\" />미라지 홈페이지 보고\r\n");
      out.write("            <input type=\"radio\" name=\"joinRoute\" value=\"\" />주변사람 소개\r\n");
      out.write("            <input type=\"radio\" name=\"joinRoute\" value=\"\" />기타\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td class=\"col-key\">전화번호</td>\r\n");
      out.write("          <td>\r\n");
      out.write("            <input\r\n");
      out.write("              id=\"input-tel\"\r\n");
      out.write("              type=\"tel\"\r\n");
      out.write("              name=\"tel\"\r\n");
      out.write("              value=\"");
      out.print(tel);
      out.write("\"\r\n");
      out.write("              required\r\n");
      out.write("            /><span></span>\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td class=\"col-key\">휴대폰번호</td>\r\n");
      out.write("          <td>\r\n");
      out.write("            <input\r\n");
      out.write("              id=\"input-mobile\"\r\n");
      out.write("              type=\"tel\"\r\n");
      out.write("              name=\"phone\"\r\n");
      out.write("              value=\"");
      out.print(phone);
      out.write("\"\r\n");
      out.write("              required\r\n");
      out.write("            /><span></span>\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td class=\"col-key\">생년월일</td>\r\n");
      out.write("          <td><input type=\"date\" name=\"birth\" value=\"");
      out.print(birth);
      out.write("\"/><span></span></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td class=\"col-key\">주소</td>\r\n");
      out.write("          <td id=\"input-address\">\r\n");
      out.write("            <input\r\n");
      out.write("              type=\"text\"\r\n");
      out.write("              id=\"zipcode\"\r\n");
      out.write("              value=\"");
      out.print(zipcode);
      out.write("\"\r\n");
      out.write("              name=\"zipCode\"\r\n");
      out.write("              size=\"4px\"\r\n");
      out.write("              required\r\n");
      out.write("            /><span></span>\r\n");
      out.write("            <input id=\"btn-searchAddr\" type=\"button\" value=\"주소 검색\" onClick=\"zipCheck()\"/><br />\r\n");
      out.write("            <input\r\n");
      out.write("              type=\"text\"\r\n");
      out.write("              id=\"addr1\"\r\n");
      out.write("              value=\"");
      out.print(address1);
      out.write("\"\r\n");
      out.write("              size=\"35px\"\r\n");
      out.write("              required\r\n");
      out.write("              readonly=\"readonly\"\r\n");
      out.write("              name=\"address1\"\r\n");
      out.write("            />\r\n");
      out.write("            기본주소<br />\r\n");
      out.write("            <input type=\"text\" id=\"addr2\" value=\"\" size=\"35px\" name=\"address2\" value=\"");
      out.print(address2);
      out.write("\" />\r\n");
      out.write("            상세주소<br />\r\n");
      out.write("            <input type=\"text\" name=\"\" value=\"\" size=\"35px\" name=\"address3\"/> 참고항목\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("      </table>\r\n");
      out.write("\r\n");
      out.write("      <div id=\"btns-submit\">\r\n");
      out.write("        <input id=\"btn-join\" type=\"submit\" value=\"정보수정\" />\r\n");
      out.write("        <input\r\n");
      out.write("          id=\"btn-cancel\"\r\n");
      out.write("          type=\"button\"\r\n");
      out.write("          value=\"취소\"\r\n");
      out.write("          onclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/home/mainPage.jsp'\"\r\n");
      out.write("        />\r\n");
      out.write("      </div>\r\n");
      out.write("    </form>\r\n");
      out.write("    </main>\r\n");
      out.write("        <hr>\r\n");
      out.write("    <footer>\r\n");
      out.write("     ");
      out.write("\r\n");
      out.write("      <article>\r\n");
      out.write("        <div><a href=\"#\">로그인 | </a><a href=\"#\">전체서비스 | </a><a href=\"#\">서비스안내 | </a><a href=\"#\">오류신고 | </a><a href=\"#\">고객센터 | </a></div>\r\n");
      out.write("        <div>직접 콘텐츠를 편집합니다.</div>\r\n");
      out.write("        <div>이 콘텐츠의 저작권은 저작권자 또는 제공처에 있으며, 이를 무단 이용하는 경우 저작권법 등에 따라 법적 책임을 질 수 있습니다.</div>\r\n");
      out.write("      </article>");
      out.write("\r\n");
      out.write("    </footer>\r\n");
      out.write("    <script src=\"");
      out.print(request.getContextPath());
      out.write("/home/js/registPage.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}