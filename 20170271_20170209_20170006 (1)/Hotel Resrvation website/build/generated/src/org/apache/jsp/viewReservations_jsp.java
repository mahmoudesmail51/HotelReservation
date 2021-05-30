package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.myhotel.Booking;
import java.util.List;

public final class viewReservations_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        \n");
      out.write("    \n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>View Reservations</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n");
      out.write("        <style type=\"text/css\" >\n");
      out.write("    body{\n");
      out.write("    background-color: #ffffff;\n");
      out.write("    font-size: 20px;\n");
      out.write("    margin: 0;\n");
      out.write("    padding: 0;\n");
      out.write("    font-family: 'Tangerine', serif;\n");
      out.write("    color: #6a6666;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".crud{\n");
      out.write("    width: auto;\n");
      out.write("    color: white !important;\n");
      out.write("    font-size: 25px;\n");
      out.write("    font-weight: 600;\n");
      out.write("}\n");
      out.write(".home\n");
      out.write("{\n");
      out.write("     width: auto;\n");
      out.write("    color: white !important;\n");
      out.write("    font-size: 25px;\n");
      out.write("    font-weight: 600;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".sub_msg{\n");
      out.write("    text-align: center;\n");
      out.write("    padding: 10px 0px 20px 0px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".signup{\n");
      out.write("    border: 1px solid #e7e7e7;\n");
      out.write("    text-align: center;\n");
      out.write("    width: 60%;\n");
      out.write("    height: auto;\n");
      out.write("    margin: auto;\n");
      out.write("}\n");
      out.write(".button\n");
      out.write("{   text-align: left;\n");
      out.write("     height: 40px;\n");
      out.write("    font-size: 20px;\n");
      out.write("    font-weight: bold;\n");
      out.write("    background-color: #1e8bc3;\n");
      out.write("    color: white !important;\n");
      out.write("}\n");
      out.write(".input_group{\n");
      out.write("    margin: 0px 20px 20px 20px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".input_group input{\n");
      out.write("    height: 40px;\n");
      out.write("    font-size: 20px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("input[type=\"submit\"]{\n");
      out.write("    height: 40px;\n");
      out.write("    font-size: 20px;\n");
      out.write("    font-weight: bold;\n");
      out.write("    background-color: #1e8bc3;\n");
      out.write("    color: white !important;\n");
      out.write("}\n");
      out.write("\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("<!-- Latest compiled and minified JavaScript -->\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>\n");
      out.write("    ");
 
        List<Booking> bookings = (List<Booking>) request.getAttribute("BOOKINGS"); 
        
    
      out.write("\n");
      out.write("    \n");
      out.write("    <script>\n");
      out.write("      \n");
      out.write("        function cancelReservation(command,bookingID)\n");
      out.write("        {\n");
      out.write("            $.ajax\n");
      out.write("            ({\n");
      out.write("                type:'POST',\n");
      out.write("                data:{command:command,bookingID:bookingID},\n");
      out.write("                url: \"CustomerControllerServlet\",\n");
      out.write("                 success: function(result)\n");
      out.write("                 {\n");
      out.write("                       if(result === \"canceled\")\n");
      out.write("                       {\n");
      out.write("                            alert(\"Canceled successfully\");\n");
      out.write("                            command=\"viewReservation\";\n");
      out.write("                            $.ajax\n");
      out.write("                            ({\n");
      out.write("                                type:'POST',\n");
      out.write("                                data:{command:command},\n");
      out.write("                                url: \"CustomerControllerServlet\",\n");
      out.write("                                 success: function(result)\n");
      out.write("                                 {\n");
      out.write("                                       $(\"#content\").html(result);\n");
      out.write("                                 }\n");
      out.write("                            });\n");
      out.write("                       }\n");
      out.write("                       else\n");
      out.write("                           alert(\"something went wrong!\");\n");
      out.write("\n");
      out.write("                 }\n");
      out.write("            });\n");
      out.write("        }\n");
      out.write("     \n");
      out.write("    </script>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        <!-- <nav class=\"navbar navbar-inverse \">\n");
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
      out.write("        <li class=\"active\"><a href=\"temp.jsp\">Home</a></li>\n");
      out.write("        <li class=\"dropdown\">\n");
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
      out.write("</nav> -->\n");
      out.write("         <div class=\"container\">\n");
      out.write("<!--We use bootstrap to create tabs on the index.php page-->\n");
      out.write("   \n");
      out.write("<ul class=\"nav nav-tabs\" id=\"myTab\">\n");
      out.write("       <li>Search Results</li>\n");
      out.write("       \n");
      out.write("    </ul>\n");
      out.write("\n");
      out.write("<!--    Here we add the forms elements of the various tabs-->\n");
      out.write("    <div class=\"tab-content\">\n");
      out.write("      \n");
      out.write("    \n");
      out.write("       \n");
      out.write("     \n");
      out.write("       <div id=\"table\">\n");
      out.write("        <table class=\"table\">\n");
      out.write("        <thead>\n");
      out.write("            <tr>\n");
      out.write("            <th scope=\"col\">Reservation Number</th>\n");
      out.write("            <th scope=\"col\">Room Number</th>\n");
      out.write("            <th scope=\"col\">Expected Price</th>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("                ");
 for (int i = 0 ; i < bookings.size(); i++)
                { 
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                <td>");
      out.print( bookings.get(i).getId() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( bookings.get(i).getRoomId() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( bookings.get(i).getPrice() );
      out.write("</td>\n");
      out.write("                <td>\n");
      out.write("                    <button type=\"button\" class=\"btn btn-danger\" onclick=\"cancelReservation('cancelReservation',");
      out.print(  bookings.get(i).getId() );
      out.write(")\">Cancel Reservation</button>\n");
      out.write("                </td>\n");
      out.write("                 <td>\n");
      out.write("                     <form action=\"CustomerControllerServlet\" method=\"POST\">\n");
      out.write("                         <input type=\"hidden\" name=\"command\" value=\"changeReservation\" id =\"command\">\n");
      out.write("                         <input type=\"hidden\" name=\"bookingId\" value=\"");
      out.print( bookings.get(i).getId() );
      out.write("\" id =\"command\">\n");
      out.write("                         <input type=\"hidden\" name=\"hotelId\" value=\"");
      out.print( bookings.get(i).getHotelId() );
      out.write("\" id =\"hotelId\">\n");
      out.write("                         <button type=\"submit\" class=\"btn btn-warning\" >Change Reservation</button>\n");
      out.write("                     </form>\n");
      out.write("                </td>\n");
      out.write("                   </tr>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("                \n");
      out.write("                \n");
      out.write("           \n");
      out.write("            \n");
      out.write("        </thead>\n");
      out.write("       \n");
      out.write("        </table>\n");
      out.write("      \n");
      out.write("       \n");
      out.write("     \n");
      out.write("      </div>\n");
      out.write("             \n");
      out.write("    </div>\n");
      out.write("</div> \n");
      out.write("        \n");
      out.write("        \n");
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
