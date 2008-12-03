package org.apache.jsp.example;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class sample_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");

response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server

      out.write('\r');
      out.write('\n');
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
      out.write("\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var hiddenFrame = null;\r\n");
      out.write("function getHiddenFrame(){\r\n");
      out.write("    if (hiddenFrame) return hiddenFrame;\r\n");
      out.write("    else{\r\n");
      out.write("        var id = Ext.id();\r\n");
      out.write("        var frame = document.createElement('iframe');\r\n");
      out.write("        frame.id = id;\r\n");
      out.write("        frame.name = id;\r\n");
      out.write("        frame.className = 'x-hidden';\r\n");
      out.write("        if(Ext.isIE){\r\n");
      out.write("            frame.src = Ext.SSL_SECURE_URL;\r\n");
      out.write("        }\r\n");
      out.write("        document.body.appendChild(frame);\r\n");
      out.write("        if(Ext.isIE){\r\n");
      out.write("           document.frames[id].name = id;\r\n");
      out.write("        }\r\n");
      out.write("        hiddenFrame=frame;\r\n");
      out.write("        return hiddenFrame;\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("var tbar=null;\r\n");
      out.write("var win=null;\r\n");
      out.write("var txt = new Ext.form.TextField({fieldLabel:\"Hello2\", value: \"\"});\r\n");
      out.write("var form=null;\r\n");
      out.write("    var ds=new Ext.data.JsonStore({\r\n");
      out.write("        url:'");
      out.print(contextPath);
      out.write("/example/Ext.action',\r\n");
      out.write("        root : 'root',\r\n");
      out.write("        fields: ['words','name']\r\n");
      out.write("    });\r\n");
      out.write("function loadWin(method){\r\n");
      out.write("\r\n");
      out.write("    ds.load();\r\n");
      out.write("    var alarm = function (){\r\n");
      out.write("    var na=ds.getAt(0).get(\"words\")[0];\r\n");
      out.write("    alert(na);\r\n");
      out.write("        var name = ds.data.items[0].json.words;\r\n");
      out.write("        document.getElementById(\"name\").value=name;\r\n");
      out.write("    };\r\n");
      out.write("\r\n");
      out.write("    form = new Ext.form.FormPanel({\r\n");
      out.write("           url:'");
      out.print(contextPath);
      out.write("/example/Ext.action',\r\n");
      out.write("           layout:\"form\",\r\n");
      out.write("           defaultType : \"textfield\",\r\n");
      out.write("           labelAlign:\"right\",\r\n");
      out.write("           width : 300,\r\n");
      out.write("           items : [{id:\"ssa\",fieldLabel:\"Hello\", value: \"\"},\r\n");
      out.write("           txt],\r\n");
      out.write("           deferHeight : true//,\r\n");
      out.write("           //submit : submitForm\r\n");
      out.write("        });\r\n");
      out.write("    //动态生成Toolbar\r\n");
      out.write("    xbar = new Ext.Toolbar({deferHeight : true, items:[{text:'test'}]});\r\n");
      out.write("    if (method == \"1\"){\r\n");
      out.write("        tbar = new Ext.Toolbar.Button({text:'name'});\r\n");
      out.write("        txt.setValue(\"damn\");\r\n");
      out.write("        }\r\n");
      out.write("    else\r\n");
      out.write("        tbar = new Ext.Toolbar.Button({text:'name'},{text:'name2'});;\r\n");
      out.write("    \r\n");
      out.write("     win= new Ext.Window({\r\n");
      out.write("           layout:\"fit\",\r\n");
      out.write("           title: \"hello world\",\r\n");
      out.write("           height: 400,\r\n");
      out.write("           width:300,\r\n");
      out.write("           //tbar : [tbar],\r\n");
      out.write("//           topToolbar : xbar,\r\n");
      out.write("            tbar:xbar,\r\n");
      out.write("           items : [form],\r\n");
      out.write("           buttons: [{text:'btn1',handler : normalSubmit},{text:'btn2',handler:changeTbar}]\r\n");
      out.write("        });\r\n");
      out.write("    //win.on(\"submit\",submitForm);\r\n");
      out.write("    win.show(document.body);\r\n");
      out.write("    }\r\n");
      out.write("    var setView=function(){\r\n");
      out.write("        loadWin(\"1\");\r\n");
      out.write("        };\r\n");
      out.write("    \r\n");
      out.write("    function changeTbar(){\r\n");
      out.write("       if (tbar.length == 2 ) {\r\n");
      out.write("        txt.setValue(\"damn\");\r\n");
      out.write("        }\r\n");
      out.write("        //动态增加按钮\r\n");
      out.write("        xbar = win.topToolbar;\r\n");
      out.write("        xbar.addSeparator();\r\n");
      out.write("        xbar.addButton({text:'faint'});\r\n");
      out.write("        //form.items.remove(form.items.get(0));\r\n");
      out.write("        //form.items.insert(0,new Ext.form.TextField({fieldLabel:\"dam\"}));\r\n");
      out.write("        form.doLayout();\r\n");
      out.write("        //alert(form.items.get(0).getName());\r\n");
      out.write("        \r\n");
      out.write("        form.items.get(0).TextField({fieldLabel:\"die\"});\r\n");
      out.write("        \r\n");
      out.write("        //dom表单提交\r\n");
      out.write("        //oform = document.forms[0];\r\n");
      out.write("        //改变dom的提交方向\r\n");
      out.write("        //oform.action=\"/blog/example/Ext.action\";\r\n");
      out.write("        //oform.method=\"get\";\r\n");
      out.write("        //oform.submit();\r\n");
      out.write("        //ExtJs表单提交\r\n");
      out.write("        //params为提交到parameter的参数\r\n");
      out.write("        //默认使用FormPanel定义的url\r\n");
      out.write("        //form.form.submit({params:{method:\"post\",name:\"good\",failure:true}});\r\n");
      out.write("        \r\n");
      out.write("    }\r\n");
      out.write("    function normalSubmit() {\r\n");
      out.write("        hiddenFrame = getHiddenFrame();\r\n");
      out.write("        var formEl = form.getForm().getEl().dom;\r\n");
      out.write("        formEl.target = hiddenFrame.id;\r\n");
      out.write("        formEl.action = \"");
      out.print(contextPath);
      out.write("/example/Ext_write.action\";\r\n");
      out.write("        formEl.submit();\r\n");
      out.write("    }\r\n");
      out.write("    function extAlarm(){\r\n");
      out.write("        Ext.MessageBox.alert(\"111\",\"333\");\r\n");
      out.write("    };        \r\n");
      out.write("    Ext.onReady(setView);\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
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
