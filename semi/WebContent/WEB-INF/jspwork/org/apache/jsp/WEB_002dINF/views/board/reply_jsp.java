/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.66
 * Generated at: 2021-07-02 08:46:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class reply_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1623371904277L));
    _jspx_dependants.put("jar:file:/C:/workspace/localRepository/aclass210316_webserver/semi/WebContent/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/fmt.tld", Long.valueOf(1425946270000L));
    _jspx_dependants.put("jar:file:/C:/workspace/localRepository/aclass210316_webserver/semi/WebContent/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

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
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<style>\n");
      out.write("/*댓글*/\n");
      out.write(".replyWrite>table {	margin-top: 100px; }\n");
      out.write(".rWriter {\n");
      out.write("	display: inline-block;\n");
      out.write("	vertical-align: top;\n");
      out.write("	font-size : 1.2em;\n");
      out.write("	font-weight: bold;\n");
      out.write("}\n");
      out.write(".rDate { display: inline-block; }\n");
      out.write(".rContent, .replyBtnArea {\n");
      out.write("	height: 100%;\n");
      out.write("	width: 100%;\n");
      out.write("}\n");
      out.write(".replyBtnArea { text-align: right; }\n");
      out.write(".replyUpdateContent {\n");
      out.write("	resize: none;\n");
      out.write("	width: 100%;\n");
      out.write("}\n");
      out.write(".reply-row{\n");
      out.write("	border-top : 1px solid #ccc;\n");
      out.write("	padding : 15px 0;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("<div id=\"reply-area \">\n");
      out.write("	<!-- 댓글 작성 부분 -->\n");
      out.write("	<div class=\"replyWrite\">\n");
      out.write("		<table align=\"center\">\n");
      out.write("			<tr>\n");
      out.write("				<td id=\"replyContentArea\">\n");
      out.write("					<textArea rows=\"3\" id=\"replyContent\"></textArea>\n");
      out.write("				</td>\n");
      out.write("				<td id=\"replyBtnArea\">\n");
      out.write("					<button class=\"btn btn-primary\" id=\"addReply\" onclick=\"addReply();\">\n");
      out.write("						댓글<br>등록\n");
      out.write("					</button>\n");
      out.write("				</td>\n");
      out.write("			</tr>\n");
      out.write("		</table>\n");
      out.write("	</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("	<!-- 댓글 출력 부분 -->\n");
      out.write("	<div class=\"replyList mt-5 pt-2\">\n");
      out.write("		<ul id=\"replyListArea\">\n");
      out.write("			");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("		</ul>\n");
      out.write("	</div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("\n");
      out.write("// 로그인한 회원의 회원 번호, 비로그인 시 \"\" (빈문자열)\n");
      out.write("const loginMemberNo = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginMember.memberNo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\n");
      out.write("\n");
      out.write("// 현재 게시글 번호\n");
      out.write("const boardNo = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.boardNo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(";\n");
      out.write("\n");
      out.write("// 수정 전 댓글 요소를 저장할 변수 (댓글 수정 시 사용)\n");
      out.write("let beforeReplyRow;\n");
      out.write("\n");
      out.write("\n");
      out.write("//-----------------------------------------------------------------------------------------\n");
      out.write("// 댓글 등록\n");
      out.write("function addReply()	{\n");
      out.write("	\n");
      out.write("	// 작성된 댓글 내용 얻어오기\n");
      out.write("	const replyContent = $(\"#replyContent\").val();\n");
      out.write("	\n");
      out.write("	// 로그인이 되어있지 않은 경우\n");
      out.write("	if(loginMemberNo == \"\"){\n");
      out.write("		swal(\"로그인 후 이용해주세요.\");\n");
      out.write("	}else{\n");
      out.write("		\n");
      out.write("		if(replyContent.trim() == \"\"){ // 작성된 댓글이 없을 경우\n");
      out.write("			swal(\"댓글 작성 후 클릭해주세요.\");\n");
      out.write("		}else{\n");
      out.write("			\n");
      out.write("			// 로그인 O, 댓글 작성 O\n");
      out.write("			$.ajax({ \n");
      out.write("				url : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/reply/insertReply\", // 필수 속성!!!!\n");
      out.write("				type : \"POST\",\n");
      out.write("				data : { \"memberNo\" : loginMemberNo,\n");
      out.write("								 \"boardNo\" : boardNo,\n");
      out.write("								 \"replyContent\" : replyContent },\n");
      out.write("				success : function(result){\n");
      out.write("					\n");
      out.write("					if(result > 0){ // 댓글 삽입 성공\n");
      out.write("						swal({\"icon\" : \"success\" , \"title\" : \"댓글 등록 성공\"});\n");
      out.write("						$(\"#replyContent\").val(\"\"); // 댓글 작성 내용 삭제\n");
      out.write("						selectReplyList();  // 비동기로 댓글 목록 갱신\n");
      out.write("						\n");
      out.write("					}\n");
      out.write("				},\n");
      out.write("				error : function(){\n");
      out.write("					console.log(\"댓글 삽입 실패\");\n");
      out.write("				}\n");
      out.write("			});\n");
      out.write("			\n");
      out.write("		}\n");
      out.write("	}\n");
      out.write("	\n");
      out.write("}	\n");
      out.write("	\n");
      out.write("\n");
      out.write("\n");
      out.write("//-----------------------------------------------------------------------------------------\n");
      out.write("//해당 게시글 댓글 목록 조회\n");
      out.write("function selectReplyList(){\n");
      out.write("\n");
      out.write("	$.ajax({ \n");
      out.write("		url : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/reply/list\",\n");
      out.write("		data : {\"boardNo\" : boardNo},\n");
      out.write("		type : \"POST\",\n");
      out.write("		dataType : \"JSON\",   // 응답되는 데이터의 형식이 JSON임을 알려줌 -> 자바스크립트 객체로 변환됨\n");
      out.write("		success : function(rList){\n");
      out.write("			console.log(rList);\n");
      out.write("	\n");
      out.write("       $(\"#replyListArea\").html(\"\"); // 기존 정보 초기화\n");
      out.write("       // 왜? 새로 읽어온 댓글 목록으로 다시 만들어서 출력하려고!\n");
      out.write("       \n");
      out.write("       $.each(rList, function(index, item){\n");
      out.write("    	   	// $.each() : jQuery의 반복문\n");
      out.write("    	   	// rList : ajax 결과로 받은 댓글이 담겨있는 객체 배열\n");
      out.write("    	   	// index : 순차 접근 시 현재 인덱스\n");
      out.write("    	   	// item : 순차 접근 시 현재 접근한 배열 요소(댓글 객체 하나)\n");
      out.write("          \n");
      out.write("          var li = $(\"<li>\").addClass(\"reply-row\");\n");
      out.write("       \n");
      out.write("          // 작성자, 작성일, 수정일 영역 \n");
      out.write("          var div = $(\"<div>\");\n");
      out.write("          var rWriter = $(\"<p>\").addClass(\"rWriter\").text(item.memberName);\n");
      out.write("          var rDate = $(\"<p>\").addClass(\"rDate\").text(\"작성일 : \" + item.createDate);\n");
      out.write("          div.append(rWriter).append(rDate)\n");
      out.write("          \n");
      out.write("          \n");
      out.write("          // 댓글 내용\n");
      out.write("          var rContent = $(\"<p>\").addClass(\"rContent\").html(item.replyContent);\n");
      out.write("          \n");
      out.write("          \n");
      out.write("          // 대댓글, 수정, 삭제 버튼 영역\n");
      out.write("          var replyBtnArea = $(\"<div>\").addClass(\"replyBtnArea\");\n");
      out.write("          \n");
      out.write("          // 현재 댓글의 작성자와 로그인한 멤버의 아이디가 같을 때 버튼 추가\n");
      out.write("          if(item.memberNo == loginMemberNo){\n");
      out.write("             \n");
      out.write("             // ** 추가되는 댓글에 onclick 이벤트를 부여하여 버튼 클릭 시 수정, 삭제를 수행할 수 있는 함수를 이벤트 핸들러로 추가함. \n");
      out.write("             var showUpdate = $(\"<button>\").addClass(\"btn btn-primary btn-sm ml-1\").text(\"수정\").attr(\"onclick\", \"showUpdateReply(\"+item.replyNo+\", this)\");\n");
      out.write("             var deleteReply = $(\"<button>\").addClass(\"btn btn-primary btn-sm ml-1\").text(\"삭제\").attr(\"onclick\", \"deleteReply(\"+item.replyNo+\")\");\n");
      out.write("             \n");
      out.write("             replyBtnArea.append(showUpdate).append(deleteReply);\n");
      out.write("          }\n");
      out.write("          \n");
      out.write("          \n");
      out.write("          // 댓글 요소 하나로 합치기\n");
      out.write("          li.append(div).append(rContent).append(replyBtnArea);\n");
      out.write("          \n");
      out.write("          \n");
      out.write("          // 합쳐진 댓글을 화면에 배치\n");
      out.write("          $(\"#replyListArea\").append(li);\n");
      out.write("       });\n");
      out.write("			\n");
      out.write("		},\n");
      out.write("		\n");
      out.write("		error : function(){\n");
      out.write("			console.log(\"댓글 목록 조회 실패\");\n");
      out.write("		}\n");
      out.write("		\n");
      out.write("	});\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("// -----------------------------------------------------------------------------------------\n");
      out.write("// 일정 시간마다 댓글 목록 갱신\n");
      out.write("/*const replyInterval = setInterval(function(){\n");
      out.write("	selectReplyList();\n");
      out.write("}, 5000);*/\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("// -----------------------------------------------------------------------------------------\n");
      out.write("// 댓글 수정 폼\n");
      out.write("\n");
      out.write("function showUpdateReply(replyNo, el){\n");
      out.write("	// el : 수정 버튼 클릭 이벤트가 발생한 요소\n");
      out.write("	\n");
      out.write("	// 이미 열려있는 댓글 수정 창이 있을 경우 닫아주기\n");
      out.write("	if($(\".replyUpdateContent\").length > 0){\n");
      out.write("		$(\".replyUpdateContent\").eq(0).parent().html(beforeReplyRow);\n");
      out.write("	}\n");
      out.write("		\n");
      out.write("	// 댓글 수정화면 출력 전 요소를 저장해둠.\n");
      out.write("	beforeReplyRow = $(el).parent().parent().html();\n");
      out.write("	\n");
      out.write("	\n");
      out.write("	// 작성되어있던 내용(수정 전 댓글 내용) \n");
      out.write("	var beforeContent = $(el).parent().prev().html();\n");
      out.write("	\n");
      out.write("	\n");
      out.write("	// 이전 댓글 내용의 크로스사이트 스크립트 처리 해제, 개행문자 변경\n");
      out.write("	// -> 자바스크립트에는 replaceAll() 메소드가 없으므로 정규 표현식을 이용하여 변경\n");
      out.write("	beforeContent = beforeContent.replace(/&amp;/g, \"&\");	\n");
      out.write("	beforeContent = beforeContent.replace(/&lt;/g, \"<\");	\n");
      out.write("	beforeContent = beforeContent.replace(/&gt;/g, \">\");	\n");
      out.write("	beforeContent = beforeContent.replace(/&quot;/g, \"\\\"\");	\n");
      out.write("	\n");
      out.write("	beforeContent = beforeContent.replace(/<br>/g, \"\\n\");	\n");
      out.write("	\n");
      out.write("	\n");
      out.write("	// 기존 댓글 영역을 삭제하고 textarea를 추가 \n");
      out.write("	$(el).parent().prev().remove();\n");
      out.write("	var textarea = $(\"<textarea>\").addClass(\"replyUpdateContent\").attr(\"rows\", \"3\").val(beforeContent);\n");
      out.write("	$(el).parent().before(textarea);\n");
      out.write("	\n");
      out.write("	// 수정 버튼\n");
      out.write("	var updateReply = $(\"<button>\").addClass(\"btn btn-primary btn-sm ml-1 mb-4\").text(\"댓글 수정\").attr(\"onclick\", \"updateReply(\" + replyNo + \", this)\");\n");
      out.write("	\n");
      out.write("	// 취소 버튼\n");
      out.write("	var cancelBtn = $(\"<button>\").addClass(\"btn btn-primary btn-sm ml-1 mb-4\").text(\"취소\").attr(\"onclick\", \"updateCancel(this)\");\n");
      out.write("	\n");
      out.write("	var replyBtnArea = $(el).parent();\n");
      out.write("	\n");
      out.write("	$(replyBtnArea).empty(); \n");
      out.write("	$(replyBtnArea).append(updateReply); \n");
      out.write("	$(replyBtnArea).append(cancelBtn); \n");
      out.write("}\n");
      out.write("\n");
      out.write("//-----------------------------------------------------------------------------------------\n");
      out.write("//댓글 수정 취소 시 원래대로 돌아가기\n");
      out.write("function updateCancel(el){\n");
      out.write("	$(el).parent().parent().html( beforeReplyRow );\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write("//-----------------------------------------------------------------------------------------\n");
      out.write("// 댓글 수정\n");
      out.write("function updateReply(replyNo, el){\n");
      out.write("	\n");
      out.write("	// 수정된 댓글 내용\n");
      out.write("	const replyContent = $(el).parent().prev().val();\n");
      out.write("	\n");
      out.write("	$.ajax({\n");
      out.write("		url : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/reply/updateReply\",\n");
      out.write("		type : \"POST\",\n");
      out.write("		data : {\"replyNo\" : replyNo,\n");
      out.write("						\"replyContent\" : replyContent },\n");
      out.write("		success : function(result){\n");
      out.write("			\n");
      out.write("			if(result > 0){\n");
      out.write("				swal({\"icon\" : \"success\" , \"title\" : \"댓글 수정 성공\"});\n");
      out.write("				selectReplyList();\n");
      out.write("			}\n");
      out.write("			\n");
      out.write("		},\n");
      out.write("		error : function(){\n");
      out.write("			console.log(\"댓글 수정 실패\");\n");
      out.write("		}\n");
      out.write("		\n");
      out.write("	});\n");
      out.write("	\n");
      out.write("	\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write("//-----------------------------------------------------------------------------------------\n");
      out.write("//댓글 삭제\n");
      out.write("function deleteReply(replyNo){\n");
      out.write("	if(confirm(\"정말로 삭제하시겠습니까?\")){\n");
      out.write("		var url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/reply/deleteReply\";\n");
      out.write("		\n");
      out.write("		$.ajax({\n");
      out.write("			url : url,\n");
      out.write("			data : {\"replyNo\" : replyNo},\n");
      out.write("			success : function(result){\n");
      out.write("				if(result > 0){\n");
      out.write("					selectReplyList(boardNo);\n");
      out.write("					\n");
      out.write("					swal({\"icon\" : \"success\" , \"title\" : \"댓글 삭제 성공\"});\n");
      out.write("				}\n");
      out.write("				\n");
      out.write("			}, error : function(){\n");
      out.write("				console.log(\"ajax 통신 실패\");\n");
      out.write("			}\n");
      out.write("		});\n");
      out.write("	}\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write("</script>");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /WEB-INF/views/board/reply.jsp(50,3) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/board/reply.jsp(50,3) '${rList}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${rList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      // /WEB-INF/views/board/reply.jsp(50,3) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("reply");
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\n");
            out.write("				<li class=\"reply-row\">\n");
            out.write("					<div>\n");
            out.write("						<p class=\"rWriter\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reply.memberName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</p>\n");
            out.write("						<p class=\"rDate\">작성일 : ");
            if (_jspx_meth_fmt_005fformatDate_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
              return true;
            out.write("</p>\n");
            out.write("					</div>\n");
            out.write("	\n");
            out.write("					<p class=\"rContent\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reply.replyContent }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</p>\n");
            out.write("					\n");
            out.write("					\n");
            out.write("					");
            if (_jspx_meth_c_005fif_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
              return true;
            out.write("\n");
            out.write("				</li>\n");
            out.write("			");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_fmt_005fformatDate_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatDate
    org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag _jspx_th_fmt_005fformatDate_005f0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag) _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag.class);
    boolean _jspx_th_fmt_005fformatDate_005f0_reused = false;
    try {
      _jspx_th_fmt_005fformatDate_005f0.setPageContext(_jspx_page_context);
      _jspx_th_fmt_005fformatDate_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
      // /WEB-INF/views/board/reply.jsp(54,29) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_fmt_005fformatDate_005f0.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reply.createDate }", java.util.Date.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      // /WEB-INF/views/board/reply.jsp(54,29) name = pattern type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_fmt_005fformatDate_005f0.setPattern("yyyy년 MM월 dd일 HH:mm");
      int _jspx_eval_fmt_005fformatDate_005f0 = _jspx_th_fmt_005fformatDate_005f0.doStartTag();
      if (_jspx_th_fmt_005fformatDate_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatDate_005f0);
      _jspx_th_fmt_005fformatDate_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_fmt_005fformatDate_005f0, _jsp_getInstanceManager(), _jspx_th_fmt_005fformatDate_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
      // /WEB-INF/views/board/reply.jsp(60,5) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reply.memberNo == loginMember.memberNo}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("					<div class=\"replyBtnArea\">\n");
          out.write("						<button class=\"btn btn-primary btn-sm ml-1\" id=\"updateReply\" onclick=\"showUpdateReply(");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reply.replyNo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write(", this)\">수정</button>\n");
          out.write("						<button class=\"btn btn-primary btn-sm ml-1\" id=\"deleteReply\" onclick=\"deleteReply(");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reply.replyNo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write(")\">삭제</button>\n");
          out.write("					</div>\n");
          out.write("					");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }
}
