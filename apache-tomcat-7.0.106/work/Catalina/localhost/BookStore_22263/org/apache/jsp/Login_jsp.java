/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.106
 * Generated at: 2021-12-26 06:51:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>Login</title>\n");
      out.write("<link href=\"templatemo_style.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("function validate()\n");
      out.write("{\n");
      out.write("\tvar emailid=document.getElementById(\"emailid\").value;\n");
      out.write("\t\n");
      out.write("\tvar password=document.getElementById(\"password\").value;\n");
      out.write("\tif(emailid==\"\")\n");
      out.write("\t{\n");
      out.write("\tdocument.getElementById(\"Eemailid\").innerHTML=\"please enter email Id\";\n");
      out.write("     return false;\n");
      out.write("     }\n");
      out.write("else\n");
      out.write("\t{\n");
      out.write("\tdocument.getElementById(\"Eemailid\").innerHTML=\"\";\n");
      out.write("\t}\n");
      out.write("\tif(password==\"\")\n");
      out.write("\t\t{\n");
      out.write("\t\tdocument.getElementById(\"epassword\").innerHTML=\"please enter password\";\n");
      out.write("\t     return false;\n");
      out.write("\t     }\n");
      out.write("\telse\n");
      out.write("\t\t{\n");
      out.write("\t\tdocument.getElementById(\"epassword\").innerHTML=\"\";\n");
      out.write("\t\t}\n");
      out.write("return true;\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<center>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("<form onsubmit=\"return validate()\" action=\"LoginServlet\" method=\"post\" >\n");
      out.write("<h1><u><b>Login</b></u></h1>\n");
      out.write("<table  bOrders=\"1\">\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("<th><input type=\"hidden\" ></th>\n");
      out.write("<th><select  name=\"type\">\n");
      out.write("<option value=\"admin\">Admin</option>\n");
      out.write("<option value=\"customer\">Customer</option>\n");
      out.write("</select></th>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<th>Email Id</th>\n");
      out.write("<th><input id=\"emailid\" type=\"text\" name=\"emailid\"></th>\n");
      out.write("<td> <span id=\"Eemailid\" style=\"color:red\" ></span></td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<th>Password</th>\n");
      out.write("<th><input id=\"password\" type=\"text\" name=\"password\"></th>\n");
      out.write("<td> <span id=\"epassword\" style=\"color:red\" ></span></td> \n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("\n");
      out.write("<th><input type=\"reset\"  value=\"Cancel\" name=\"\" ></th>\n");
      out.write("\n");
      out.write("<th><input type=\"submit\" value=\"Login\" name=\"action\"></th>\n");
      out.write("</tr>\n");
      out.write("</table>\n");
      out.write("</form>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("</center>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
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
