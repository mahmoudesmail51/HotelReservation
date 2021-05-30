package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class temp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("  <title>Home</title>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n");
      out.write("  <script src=\"https://code.jquery.com/jquery-3.1.1.js\"></script>\n");
      out.write("   <script src=\"https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <link href=\"https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("  \n");
      out.write("  \n");
      out.write(" \n");
      out.write("      \n");
      out.write("      \n");
      out.write("  <style type=\"text/css\" >\n");
      out.write("      \n");
      out.write("       body{\n");
      out.write("            position: relative;\n");
      out.write("            height :100%; \n");
      out.write("            color: black;\n");
      out.write("            font-family: 'Tangerine', serif;\n");
      out.write("            font-size: 20px;\n");
      out.write("           \n");
      out.write("\n");
      out.write("        }\n");
      out.write("      .center_div{\n");
      out.write("          padding: 35px;\n");
      out.write("          margin-top: 25px;\n");
      out.write("          line-height: 2;\n");
      out.write("        }\n");
      out.write("      .edit{\n");
      out.write("          margin: 30px;\n");
      out.write("          text-align: center;\n");
      out.write("      }\n");
      out.write("      .edit2{\n");
      out.write("          padding-top: 35px;\n");
      out.write("      }\n");
      out.write("    \n");
      out.write("  </style>\n");
      out.write("  <script>\n");
      out.write("               \n");
      out.write("        $(document).ready(function()\n");
      out.write("        {\n");
      out.write("            $('#viewReservationButton').click(function()\n");
      out.write("            {\n");
      out.write("                var command=\"viewReservation\";\n");
      out.write("                $.ajax\n");
      out.write("                ({\n");
      out.write("                    type:'POST',\n");
      out.write("                    data:{command:command},\n");
      out.write("                    url: \"CustomerControllerServlet\",\n");
      out.write("                     success: function(result)\n");
      out.write("                     {\n");
      out.write("                           $(\"#content\").html(result);\n");
      out.write("                     }\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("            \n");
      out.write("            $('#home').click(function()\n");
      out.write("            {\n");
      out.write("                window.location.href = \"temp.jsp\";\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("        \n");
      out.write("    </script>\n");
      out.write("     ");

         if(request.getParameter("req")!= null) {
         String s = request.getParameter("req");
            if (s.equals("viewReservation"))
            {     
      out.write("\n");
      out.write("            <script>\n");
      out.write("                var command=\"viewReservation\";\n");
      out.write("                $.ajax\n");
      out.write("                ({\n");
      out.write("                    type:'POST',\n");
      out.write("                    data:{command:command},\n");
      out.write("                    url: \"CustomerControllerServlet\",\n");
      out.write("                     success: function(result)\n");
      out.write("                     {\n");
      out.write("                           $(\"#content\").html(result);\n");
      out.write("                     }\n");
      out.write("                });\n");
      out.write("            </script>\n");
      out.write("            ");
 } 
        }
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<nav class=\"navbar navbar-inverse \">\n");
      out.write("  <div class=\"container-fluid\">\n");
      out.write("    <div class=\"navbar-header\">\n");
      out.write("      <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\n");
      out.write("        <span class=\"icon-bar\"></span>\n");
      out.write("        <span class=\"icon-bar\"></span>\n");
      out.write("        <span class=\"icon-bar\"></span>                        \n");
      out.write("      </button>\n");
      out.write("      <a class=\"navbar-brand\">Hotel Bookings</a>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\n");
      out.write("      <ul class=\"nav navbar-nav\">\n");
      out.write("        <li class=\"active\"><a id=\"home\">Home</a></li>\n");
      out.write("        <li ><a id=\"viewReservationButton\">View Reservation</a></li>\n");
      out.write("        <li class=\"dropdown\">\n");
      out.write("        \n");
      out.write("          <ul class=\"dropdown-menu\">\n");
      out.write("            <li></li>\n");
      out.write("            <li></li>\n");
      out.write("            <li></li>\n");
      out.write("          </ul>\n");
      out.write("        </li>\n");
      out.write("        <li></li>\n");
      out.write("        <li></li>\n");
      out.write("      </ul>\n");
      out.write("      <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("        <li><a href=\"changeCredentials.jsp\"><span class=\"glyphicon glyphicon-user\"></span>My Account</a></li>\n");
      out.write("        <li><a href=\"#\"><span class=\"glyphicon glyphicon-log-in\"></span> Sign out</a></li>\n");
      out.write("      </ul>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</nav>\n");
      out.write("   \n");
      out.write("    <div id=\"content\">\n");
      out.write("            \n");
      out.write("   <form action=\"CustomerControllerServlet\" method=\"POST\" >\n");
      out.write("       <input type=\"hidden\" name=\"command\" value=\"search\" id =\"command\">\n");
      out.write("       \n");
      out.write("  <div class=\"col-md-9 col-md-offset-4 text-center\">\n");
      out.write("    <div class=\"input-group col-xs-3  edit edit2\">\n");
      out.write("      <input id=\"destination\" type=\"text\" class=\"form-control input-lg\" name=\"destination\" placeholder=\"Enter your destination\">\n");
      out.write("    \n");
      out.write("        <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-user\"></i></span>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    <div class=\"input-group  edit\">\n");
      out.write("        <input id=\"checkin\" name=\"checkin\" width=\"270\" class=\"input-lg\" placeholder=\"Enter check-in date\"/>\n");
      out.write("    <script>\n");
      out.write("        $('#checkin').datepicker({\n");
      out.write("            uiLibrary: 'bootstrap'\n");
      out.write("        });\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    <div class=\"input-group col-xs-3  edit\">\n");
      out.write("       <input id=\"checkout\" name=\"checkout\" width=\"270\" class=\"input-lg\" placeholder=\"Enter check-out date\"/>\n");
      out.write("    <script>\n");
      out.write("        $('#checkout').datepicker({\n");
      out.write("            uiLibrary: 'bootstrap'\n");
      out.write("        });\n");
      out.write("    </script>\n");
      out.write("    </div>\n");
      out.write("     <div class=\"input-group col-xs-3 edit\">\n");
      out.write("        <input id=\"numberofadults\" type=\"text\" name=\"numberofadults\" class=\"form-control input-lg\" name=\"destination\" placeholder=\"Enter number of adults\">\n");
      out.write("        <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-user\"></i></span>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <div class=\"input-group col-xs-3 edit\">\n");
      out.write("      <input id=\"numberofchildren\" name=\"numberofchildren\" type=\"text\" class=\"form-control input-lg\" name=\"destination\" placeholder=\"Enter number of children\">\n");
      out.write("      <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-user\"></i></span>\n");
      out.write("    </div>\n");
      out.write("    <br>\n");
      out.write("    <div class=\"col-lg-3 sign \" id=\"sign\">\n");
      out.write("         <button class=\"btn btn-primary btn-lg\" type=\"submit\">Search   </button>\n");
      out.write("         \n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    </div>\n");
      out.write("  </form>\n");
      out.write("    \n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("           \n");
      out.write("</body>\n");
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
