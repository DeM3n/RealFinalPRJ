package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AboutUs_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
      out.write("         <style>\n");
      out.write("        * { margin: 0; padding: 0; box-sizing: border-box; }\n");
      out.write("        body { font-family: Arial, sans-serif; }\n");
      out.write("        .container { display: flex; height: 100vh; }\n");
      out.write("        .left { width: 50%; position: relative; overflow: hidden; }\n");
      out.write("        .left img { width: 100%; height: 100vh; object-fit: cover; position: absolute; opacity: 0; transition: opacity 1s; }\n");
      out.write("        .left img.active { opacity: 1; }\n");
      out.write("        .right { width: 50%; display: flex; justify-content: center; align-items: center; padding: 40px; background: #f8f8f8; }\n");
      out.write("        .content { max-width: 500px; text-align: justify; }\n");
      out.write("        h1 { font-size: 36px; color: #333; margin-bottom: 20px; }\n");
      out.write("        p { font-size: 18px; color: #666; }\n");
      out.write("    </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         <div class=\"container\">\n");
      out.write("        <div class=\"left\">\n");
      out.write("            <img src=\"img1.jpg\" class=\"active\" alt=\"Luxury Hotel 1\">\n");
      out.write("            <img src=\"img2.jpg\" alt=\"Luxury Hotel 2\">\n");
      out.write("            <img src=\"img3.jpg\" alt=\"Luxury Hotel 3\">\n");
      out.write("            <img src=\"img4.jpg\" alt=\"Luxury Hotel 4\">\n");
      out.write("            <img src=\"img5.jpg\" alt=\"Luxury Hotel 5\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"right\">\n");
      out.write("            <div class=\"content\">\n");
      out.write("                <h1>Welcome to Our Luxury Hotel</h1>\n");
      out.write("                <p>Experience the pinnacle of elegance and comfort at our five-star luxury hotel. Nestled in the heart of the city, our hotel offers world-class accommodations, gourmet dining, and unparalleled service. Whether you are here for business or leisure, indulge in a sanctuary of sophistication where every moment is crafted to perfection.</p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        let index = 0;\n");
      out.write("        const images = document.querySelectorAll(\".left img\");\n");
      out.write("        function switchImage() {\n");
      out.write("            images.forEach(img => img.classList.remove(\"active\"));\n");
      out.write("            index = (index + 1) % images.length;\n");
      out.write("            images[index].classList.add(\"active\");\n");
      out.write("        }\n");
      out.write("        setInterval(switchImage, 3000);\n");
      out.write("    </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
