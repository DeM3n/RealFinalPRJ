package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Login form</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/styles.css\">\n");
      out.write("        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"loginpage\">\n");
      out.write("                <form action=\"MainController\" method=\"post\">\n");
      out.write("                    <input type=\"hidden\" name=\"action\"value=\"login\"/>\n");
      out.write("                    <h2>Login</h2>\n");
      out.write("                    <div class=\"input-box\"> \n");
      out.write("                        <input type=\"text\" placeholder=\"Username\" name=\"txtUsername\" required />\n");
      out.write("                        <i class='bx bxs-user'></i>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"input-box\">\n");
      out.write("                        <input type=\"password\" placeholder=\"Password\" name=\"txtPassword\" required />\n");
      out.write("                        <i class='bx bxs-lock' ></i>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"remember-forget\">\n");
      out.write("                        <label>  <input type=\"checkbox\"/>Remember me</label>\n");
      out.write("                        <a href=\"ResetPW.jsp\">Forgot Password?</a>\n");
      out.write("                    </div>\n");
      out.write("                    <button type=\"submit\" class=\"button\">Log in</button>\n");
      out.write("                    <div class=\"register-link\">\n");
      out.write("                        <p>Don't have an account?\n");
      out.write("                            <a href=\"register.jsp\">Register</a> </p> \n");
      out.write("                    </div>\n");
      out.write("                     ");
String message = request.getAttribute("message")+""; 
      out.write("\n");
      out.write("            ");
      out.print( message.equals("null")?"":message );
      out.write("\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("       \n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
