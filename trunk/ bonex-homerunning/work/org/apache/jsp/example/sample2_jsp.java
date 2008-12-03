package org.apache.jsp.example;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class sample2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/example/../common/ext-header.jsp");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\r\n");
      out.write("<title>Reorder TreePanel</title>\r\n");
      out.write('\n');
 String contextPath = request.getContextPath();
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(contextPath);
      out.write("/ext/resources/css/ext-all.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(contextPath);
      out.write("/ext/adapter/ext/ext-base.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(contextPath);
      out.write("/ext/ext-all-debug.js\"></script>");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"example.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- Common Styles for the examples -->\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(contextPath);
      out.write("/ext/examples/samples.css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(contextPath);
      out.write("/ext/examples/samples.js\"></script> <!-- EXAMPLES -->\r\n");
      out.write("<h1>Drag and Drop ordering in a TreePanel</h1>\r\n");
      out.write("<p>This example shows basic drag and drop node moving in a tree. In this implementation there are no restrictions and \r\n");
      out.write("anything can be dropped anywhere except appending to nodes marked &quot;leaf&quot; (the files). <br></p>\r\n");
      out.write("<p>Drag along the edge of the tree to trigger auto scrolling while performing a drag and drop.</p>\r\n");
      out.write("<p>In order to demonstrate drag and drop insertion points, sorting was <b>not</b> enabled.</p>\r\n");
      out.write("<p>The data for this tree is asynchronously loaded with a JSON TreeLoader.</p>\r\n");
      out.write("<p>The js is not minified so it is readable. See <a href=\"reorder.js\">reorder.js</a>.</p>\r\n");
      out.write("\r\n");
      out.write("<div id=\"tree-div\" style=\"overflow:auto; height:300px;width:250px;border:1px solid #c3daf9;\"></div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
