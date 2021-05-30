package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.myhotel.Review;
import java.util.List;

public final class viewRatings_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Admin Home</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n");
      out.write("<script>\n");
      out.write("    function validate() {\n");
      out.write("    \n");
      out.write("        var customerId = document.forms[\"form\"][\"customerId\"]; \n");
      out.write("       \n");
      out.write("\n");
      out.write("\n");
      out.write("        if (customerId.value === \"\") \n");
      out.write("        { \n");
      out.write("            window.alert(\"Please enter Customer ID.\"); \n");
      out.write("            customerId.focus(); \n");
      out.write("            return false; \n");
      out.write("        }\n");
      out.write("\n");
      out.write("       \n");
      out.write("\n");
      out.write("        return true;\n");
      out.write("    }\n");
      out.write("  \n");
      out.write("    $(document).ready(function(){\n");
      out.write("        $('#submit').click(function(){\n");
      out.write("            if (validate())\n");
      out.write("            {\n");
      out.write("                var customerId = $('#customerId').val();\n");
      out.write("              \n");
      out.write("                var command = $('#command').val();\n");
      out.write("                $.ajax({\n");
      out.write("                    type:'POST',\n");
      out.write("                    data:{customerId:customerId,command:command},\n");
      out.write("                    url: \"AdminControllerServlet\",\n");
      out.write("                    success: function(result)\n");
      out.write("                    {\n");
      out.write("                        $('#customerInformation').html(result);\n");
      out.write("                       \n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("            }\n");
      out.write("        }); \n");
      out.write("    });\n");
      out.write("\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("<!-- Latest compiled and minified JavaScript -->\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>\n");
      out.write("<style type=\"text/css\" >\n");
      out.write("    body{\n");
      out.write("    background-color: #ffffff;\n");
      out.write("    font-size: 20px;\n");
      out.write("    margin: 0;\n");
      out.write("    padding: 0;\n");
      out.write("    font-family: 'Tangerine', serif;\n");
      out.write("    color: #6a6666;\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</style>\n");
      out.write("            ");

                List<Review> reviews = (List<Review>) request.getAttribute("REVIEWS");
            
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <nav class=\"navbar navbar-inverse \">\n");
      out.write("  <div class=\"container-fluid\">\n");
      out.write("    <div class=\"navbar-header\">\n");
      out.write("      <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\n");
      out.write("        <span class=\"icon-bar\"></span>\n");
      out.write("        <span class=\"icon-bar\"></span>\n");
      out.write("        <span class=\"icon-bar\"></span>                        \n");
      out.write("        <a href=\"../src/java/com/myhotel/CustomerControllerServlet.java\"></a>\n");
      out.write("      </button>\n");
      out.write("      <a class=\"navbar-brand\">Hotel Bookings</a>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\n");
      out.write("      <ul class=\"nav navbar-nav\">\n");
      out.write("        <li class=\"active\"><a href=\"adminHome.jsp\">Home</a></li>\n");
      out.write("        <li class=\"active\"><a href=\"searchCustomer.jsp\">Search Customer</a></li>\n");
      out.write("        <li class=\"active\"><a href=\"updateHotels.jsp\">Update Hotels</a></li>\n");
      out.write("        <li class=\"active\"><a href=\"checkIn.jsp\">Check in</a></li>\n");
      out.write("        <li class=\"active\"><a href=\"checkOut.jsp\">Check out</a></li>\n");
      out.write("         <li class=\"active\"><a href=\"updateRooms.jsp\">Update Rooms</a></li>\n");
      out.write("          <li class=\"active\"><a href=\"viewRatings.jsp\">View Ratings</a></li>\n");
      out.write("        <li class=\"active\"><a href=\"adminViewReservations.jsp\">View Reservations</a></li>\n");
      out.write("        \n");
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
      out.write("<!--        <li><a href=\"changeCredentials.jsp\"><span class=\"glyphicon glyphicon-user\"></span>My Account</a></li>-->\n");
      out.write("        <li><a href=\"#\"><span class=\"glyphicon glyphicon-log-in\"></span> Sign out</a></li>\n");
      out.write("      </ul>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</nav>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write(" \n");
      out.write("<div class=\"container\">\n");
      out.write("<!--We use bootstrap to create tabs on the index.php page-->\n");
      out.write("   \n");
      out.write("    \n");
      out.write("<!--    Here we add the forms elements of the various tabs-->\n");
      out.write("    <div class=\"tab-content\">\n");
      out.write("      \n");
      out.write("       <form id=\"form\" action =\"AdminControllerServlet\" method=\"POST\" >  \n");
      out.write("            <input type=\"hidden\" name=\"command\" value=\"getReviews\" id =\"command\">\n");
      out.write("        <div class=\"container center_div\">\n");
      out.write("          <div class=\"col-lg-6 offset-lg-3\">\n");
      out.write("            <label for=\"validationDefault01\">Hotel ID</label>\n");
      out.write("            <input type=\"text\" class=\"form-control\" id=\"hotelId\" placeholder=\"Hotel ID\" name=\"hotelId\" required >\n");
      out.write("          </div>\n");
      out.write("       </div>\n");
      out.write("             <div class=\"col-lg-6 offset-lg-3 text-center\" id=\"submit\">\n");
      out.write("                <button class=\"btn btn-primary\" type=\"submit\">Search</button>\n");
      out.write("         </div>\n");
      out.write("         </form>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("         <div id=\"table\" >\n");
      out.write("      \n");
      out.write("         <table class=\"table\">\n");
      out.write("        <thead>\n");
      out.write("            <tr>\n");
      out.write("            <th scope=\"col\">Review Number</th>\n");
      out.write("            <th scope=\"col\">Review comments</th>\n");
      out.write("            <th scope=\"col\">Stars</th>\n");
      out.write("           \n");
      out.write("            </tr>\n");
      out.write("           ");
   if(reviews != null)
           { 
      out.write("\n");
      out.write("              ");
 
              for (int i = 0 ; i < reviews.size(); i++)
              { 
      out.write("\n");
      out.write("              \n");
      out.write("              <tr>\n");
      out.write("                  <td>");
      out.print( reviews.get(i).getId() );
      out.write("</td>\n");
      out.write("                  <td>");
      out.print( reviews.get(i).getComment() );
      out.write("</td>\n");
      out.write("                  <td>");
      out.print( reviews.get(i).getStars() );
      out.write("</td>\n");
      out.write("              </tr>\n");
      out.write("                  \n");
      out.write("            ");
  }}
      out.write("\n");
      out.write("             \n");
      out.write("        </thead>\n");
      out.write("       \n");
      out.write("        </table>\n");
      out.write("      \n");
      out.write("    \n");
      out.write("       </div>\n");
      out.write("    \n");
      out.write("       </div>\n");
      out.write("    </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
