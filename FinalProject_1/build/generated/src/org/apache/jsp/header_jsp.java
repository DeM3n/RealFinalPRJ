package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dto.UserDTO;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <style>\r\n");
      out.write("        /* Reset CSS */\r\n");
      out.write("        @import url('https://fonts.googleapis.com/css2?family=Nunito+Sans:ital,opsz,wght@0,6..12,200..1000;1,6..12,200..1000&family=Nunito:ital,wght@0,200..1000;1,200..1000&display=swap');\r\n");
      out.write("        @import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css');\r\n");
      out.write("\r\n");
      out.write("        * {\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("            font-family: \"Nunito\", serif;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Body Styling */\r\n");
      out.write("        body {\r\n");
      out.write("            background-color: #FAFAFA;\r\n");
      out.write("            color: #2C2C2C;\r\n");
      out.write("            line-height: 1.8;\r\n");
      out.write("            font-size: 18px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .header {\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            background-color: #FFFFFF;\r\n");
      out.write("            height: 70px;\r\n");
      out.write("            padding: 10px 50px;\r\n");
      out.write("            display: flex;\r\n");
      out.write("            justify-content: space-between;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("            border-bottom: 2px solid #DDD;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .navtab h1 {\r\n");
      out.write("            align-items: center;\r\n");
      out.write("            border-bottom: 2px #000;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Logo */\r\n");
      out.write("        .logo {\r\n");
      out.write("            width: 20%;\r\n");
      out.write("            display: flex;\r\n");
      out.write("            height: 50px;\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .logo img {\r\n");
      out.write("            height: 100%;\r\n");
      out.write("            border-radius: 10px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .logo h1 {\r\n");
      out.write("            line-height: 20px;\r\n");
      out.write("            display: flex;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("            justify-items: center;\r\n");
      out.write("            padding: 10px;\r\n");
      out.write("            border-left: 2px solid;\r\n");
      out.write("            border-color: #000;\r\n");
      out.write("            font-size: 20px;\r\n");
      out.write("            font-weight: 700;\r\n");
      out.write("            color: #2C2C2C;\r\n");
      out.write("            margin-top: 10px;\r\n");
      out.write("            margin-left: 10px;\r\n");
      out.write("            height: 30px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Navigation */\r\n");
      out.write("        .navbar ul {\r\n");
      out.write("            align-items: center;\r\n");
      out.write("            list-style: none;\r\n");
      out.write("            display: flex;\r\n");
      out.write("            gap: 25px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .navbar ul li a {\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("            color: #333;\r\n");
      out.write("            font-size: 18px;\r\n");
      out.write("            font-weight: 500;\r\n");
      out.write("            padding: 10px 15px;\r\n");
      out.write("            transition: 0.3s;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .navbar ul li a:hover {\r\n");
      out.write("            color: #000;\r\n");
      out.write("            border-bottom: 2px solid #333;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Call-to-Action Button */\r\n");
      out.write("        .cta {\r\n");
      out.write("            display: flex;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .user-section {\r\n");
      out.write("            height: 50px;\r\n");
      out.write("            width: 20%;\r\n");
      out.write("            justify-content: right;\r\n");
      out.write("            justify-items: right;\r\n");
      out.write("            display: flex;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .user-section .signin  {\r\n");
      out.write("            justify-items: center;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("            padding: 10px 10px;\r\n");
      out.write("            font-size: 20px;\r\n");
      out.write("            font-weight: 700;\r\n");
      out.write("            background-color: transparent;\r\n");
      out.write("            height: 80%;\r\n");
      out.write("            border: none;\r\n");
      out.write("            margin: 10px;\r\n");
      out.write("            transition: 0.3s;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .user-section .signin:hover {\r\n");
      out.write("            color: #000;\r\n");
      out.write("            border-bottom: 2px solid #333;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .user-section .icon-person {\r\n");
      out.write("            margin-right: 10px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        /* Footer */\r\n");
      out.write("        .footer {\r\n");
      out.write("            background-color: #F5F5F5;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            padding: 20px;\r\n");
      out.write("            font-size: 16px;\r\n");
      out.write("            color: #777;\r\n");
      out.write("            border-top: 2px solid #DDD;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\" />\r\n");
      out.write("        <title>Test</title>\r\n");
      out.write("      \r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("       ");
 if (session.getAttribute("user") != null) {
    UserDTO user = (UserDTO) session.getAttribute("user");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<header class=\"header\">\r\n");
      out.write("    <div class=\"logo\">\r\n");
      out.write("        <img src=\"assets/images/logo.png\" alt=\"Hotel Logo\" style=\"width: 50px; height: 50px\">\r\n");
      out.write("        <h1>SISYPHUS</h1>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <nav class=\"navbar\">\r\n");
      out.write("        <ul class=\"home-btn\">\r\n");
      out.write("            <li><a href=\"#\">Home</a></li>\r\n");
      out.write("            <li><a href=\"#\">Service</a></li>\r\n");
      out.write("            <li><a href=\"#\">About Us</a></li>\r\n");
      out.write("            <li><a href=\"#\">Contact</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </nav>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"user-section\">\r\n");
      out.write("         <form action=\"MainController\" method=\"post\" >\r\n");
      out.write("              <input type=\"hidden\" name=\"action\" value=\"Log out\"/>\r\n");
      out.write("       <button class=\"signin\" onclick=\"window.location.href = 'login.jsp'\">\r\n");
      out.write("            <span class=\"fa fa-user icon-person\"></span> Log out\r\n");
      out.write("        </button>\r\n");
      out.write("         </form>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</header>\r\n");
      out.write("\r\n");
 } else { 
      out.write("\r\n");
      out.write("<header class=\"header\">\r\n");
      out.write("    <div class=\"logo\">\r\n");
      out.write("        <img src=\"assets/images/logo.png\" alt=\"Hotel Logo\" style=\"width: 50px; height: 50px\">\r\n");
      out.write("        <h1>SISYPHUS</h1>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <nav class=\"navbar\">\r\n");
      out.write("        <ul class=\"home-btn\">\r\n");
      out.write("            <li><a href=\"#\">Home</a></li>\r\n");
      out.write("            <li><a href=\"#\">Service</a></li>\r\n");
      out.write("            <li><a href=\"#\">About Us</a></li>\r\n");
      out.write("            <li><a href=\"#\">Contact</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </nav>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"user-section\">\r\n");
      out.write("        <button class=\"signin\" onclick=\"window.location.href = 'login.jsp'\">\r\n");
      out.write("            <span class=\"fa fa-user icon-person\"></span> Sign in\r\n");
      out.write("        </button>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</header>\r\n");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
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
