package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class sign_002dup_002dform_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Sign up</title>\n");
      out.write("       \n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("        \n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\" integrity=\"sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk\" crossorigin=\"anonymous\">\n");
      out.write("    <style type=\"text/css\" >\n");
      out.write("          body{\n");
      out.write("            background-image: url(\"background.png\");\n");
      out.write("            position: relative;\n");
      out.write("            height :100%; \n");
      out.write("            background-position: center;\n");
      out.write("            background-repeat: no-repeat;\n");
      out.write("            background-size: cover;\n");
      out.write("             \n");
      out.write("            font-weight: bold;\n");
      out.write("\n");
      out.write("        }\n");
      out.write("            \n");
      out.write("        \n");
      out.write("      .center_div{\n");
      out.write("          padding: 35px;\n");
      out.write("          margin-top: 25px;\n");
      out.write("          line-height: 2;\n");
      out.write("        }\n");
      out.write("        #submit{\n");
      out.write("           padding:12px;\n");
      out.write("       } \n");
      out.write("        h1{\n");
      out.write("            text-align: center;\n");
      out.write("            margin-top:65px;\n");
      out.write("            margin-bottom: 60px;\n");
      out.write("         }\n");
      out.write("    </style>\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.1.1.js\"></script>\n");
      out.write("    <script>\n");
      out.write("    function validate() {\n");
      out.write("    \n");
      out.write("        var fname = document.forms[\"form\"][\"firstname\"]; \n");
      out.write("        var lname = document.forms[\"form\"][\"lastname\"]; \n");
      out.write("        var userName = document.forms[\"form\"][\"username\"]; \n");
      out.write("        var phoneNumber = document.forms[\"form\"][\"phonenumber\"]; \n");
      out.write("        var email = document.forms[\"form\"][\"email\"]; \n");
      out.write("\n");
      out.write("\n");
      out.write("        if (fname.value === \"\") \n");
      out.write("        { \n");
      out.write("            window.alert(\"Please enter your first name.\"); \n");
      out.write("            fname.focus(); \n");
      out.write("            return false; \n");
      out.write("        }\n");
      out.write("\n");
      out.write("        if (lname.value === \"\") \n");
      out.write("        { \n");
      out.write("            window.alert(\"Please enter your last name.\"); \n");
      out.write("            lname.focus(); \n");
      out.write("            return false; \n");
      out.write("        } \n");
      out.write("\n");
      out.write("        if (userName.value === \"\") \n");
      out.write("        { \n");
      out.write("            window.alert(\"Please enter your user name\"); \n");
      out.write("            userName.focus(); \n");
      out.write("            return false; \n");
      out.write("        }\n");
      out.write("\n");
      out.write("         if (phoneNumber.value === \"\") { \n");
      out.write("            window.alert( \n");
      out.write("              \"Please enter your phone number.\"); \n");
      out.write("            phoneNumber.focus(); \n");
      out.write("            return false; \n");
      out.write("        } \n");
      out.write("\n");
      out.write("        if (email.value === \"\") { \n");
      out.write("            window.alert( \n");
      out.write("              \"Please enter a valid e-mail address.\"); \n");
      out.write("            email.focus(); \n");
      out.write("            return false; \n");
      out.write("        } \n");
      out.write("\n");
      out.write("        return true;\n");
      out.write("    }\n");
      out.write("  \n");
      out.write("    $(document).ready(function(){\n");
      out.write("        $('#submit').click(function(){\n");
      out.write("            if (validate())\n");
      out.write("            {\n");
      out.write("                var fname = $('#firstname').val();\n");
      out.write("                var lname = $('#lastname').val();\n");
      out.write("                var user = $('#username').val();\n");
      out.write("                var phonenumber = $('#phonenumber').val();\n");
      out.write("                var email = $('#email').val();\n");
      out.write("                var command = $('#command').val();\n");
      out.write("                $.ajax({\n");
      out.write("                    type:'POST',\n");
      out.write("                    data:{fname:fname,lname:lname,user:user,Phonenumber:phonenumber,Email:email,command:command},\n");
      out.write("                    url: \"CustomerControllerServlet\",\n");
      out.write("                    success: function(result)\n");
      out.write("                    {\n");
      out.write("                        alert(result);\n");
      out.write("                        if (result === \"SUCCESS\")\n");
      out.write("                        {\n");
      out.write("                            window.location.href = \"sign-in.jsp\";\n");
      out.write("                        }\n");
      out.write("                        else\n");
      out.write("                        {\n");
      out.write("                            \n");
      out.write("                        }   \n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("            }\n");
      out.write("        }); \n");
      out.write("    });\n");
      out.write("\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        <h1>Sign Up</h1>\n");
      out.write("        <form id=\"form\" >  \n");
      out.write("            <input type=\"hidden\" name=\"command\" value=\"register\" id =\"command\">\n");
      out.write("        <div class=\"container center_div\">\n");
      out.write("          <div class=\"col-lg-6 offset-lg-3\">\n");
      out.write("            <label for=\"validationDefault01\">First name</label>\n");
      out.write("            <input type=\"text\" class=\"form-control\" id=\"firstname\" placeholder=\"First name\" name=\"firstname\" required >\n");
      out.write("          </div>\n");
      out.write("          <div class=\"col-lg-6 offset-lg-3\">\n");
      out.write("            <label for=\"validationDefault02\">Last name</label>\n");
      out.write("            <input type=\"text\" class=\"form-control\" id=\"lastname\" placeholder=\"Last name\" name=\"lastname\" required >\n");
      out.write("          </div>\n");
      out.write("          <div class=\"col-lg-6 offset-lg-3\">\n");
      out.write("            <label for=\"validationDefaultUsername\">Username</label>\n");
      out.write("            <div class=\"input-group\">\n");
      out.write("             \n");
      out.write("              <input type=\"text\" class=\"form-control\" id=\"username\" placeholder=\"Username\" name=\"username\" aria-describedby=\"inputGroupPrepend2\" required >\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"col-lg-6 offset-lg-3\">\n");
      out.write("            <label for=\"validationDefault03\">Phone Number</label>\n");
      out.write("            <input type=\"text\" class=\"form-control\" id=\"phonenumber\" placeholder=\"Phone Number\" name=\"phonenumber\" required >\n");
      out.write("          </div>\n");
      out.write("          <div class=\"col-lg-6 offset-lg-3\">\n");
      out.write("            <label for=\"validationDefault04\">Email</label>\n");
      out.write("            <input type=\"email\" class=\"form-control\" id=\"email\" placeholder=\"Email\" name=\"email\" required >\n");
      out.write("          </div>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("            \n");
      out.write("        </form>\n");
      out.write("        <div class=\"col-lg-6 offset-lg-3 text-center\" id=\"submit\" style=\"padding-top: 0;\">\n");
      out.write("            <button type=\"submit\" id=\"submit\" name=\"submit\" class=\"btn btn-primary\">sign up</button>\n");
      out.write("        </div>\n");
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
