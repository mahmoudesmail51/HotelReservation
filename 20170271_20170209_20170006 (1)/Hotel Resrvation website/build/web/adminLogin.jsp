<%-- 
    Document   : adminLogin
    Created on : Jan 15, 2021, 11:44:24 AM
    Author     : Mahmoud Esmail
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign in</title>
       
        <link type="text/css" rel="stylesheet" href="css/style.css">
        
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <style type="text/css" >
          body{
            background-image: url("background.png");
            position: relative;
            height :100%; 
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
            font-weight: bold;

        }
            
        
      .center_div{
          padding: 35px;
          margin-top: 25px;
          line-height: 2;
        }
         #submit{
           padding:30px;
       } 
        h1{
            text-align: center;
            margin-top:65px;
            margin-bottom: 60px;
         }
        #sign{
            border-top: 1px solid white;
            padding-top: 30px;
        }
    </style>
     <script src="https://code.jquery.com/jquery-3.1.1.js"></script>
     <script>
    function validate() 
    {
        var username = document.forms["form"]["username"]; 
        var password = document.forms["form"]["password"]; 
        if (username.value === "") 
        { 
            window.alert("Please enter your user name."); 
            username.focus(); 
            return false; 
        } 
        if (password.value === "") 
        { 
            window.alert("Please enter your password."); 
            password.focus(); 
            return false; 
        } 
      
        return true;
    }
  
    $(document).ready(function()
    {
        $('#submit').click(function()
        {
          if(validate)
          {
              var username = $('#username').val();
               var password = $('#password').val();
                var command = $('#command').val();

        $.ajax
        ({
            type:'POST',
            data:{username:username,password:password,command:command},
            url: "AdminControllerServlet",
             success: function(result)
             {
                 
                   if(result == "1")
                   {
                       window.location.href = "adminHome.jsp";
                   }
                   else
                       alert("Wrong credentials!")
                        
             }
        }); 
          }
       
        });
    });


    </script>
    
    </head>
    
    <body>
        <h1>Admin Login</h1>
        <form id="form" method ="POST" >   
            <input type="hidden" name="command" value="sign in" id ="command">
        <div class="container center_div">
          <div class="col-lg-6 offset-lg-3">
            <label for="validationDefaultUsername">Username</label>
            <div class="input-group">
             
              <input type="text" class="form-control" id="username" placeholder="Username" name="username" aria-describedby="inputGroupPrepend2" required >
            </div>
          </div>
            
          <div class="col-lg-6 offset-lg-3">
            <label for="validationDefault03">Password</label>
            <input type="password" class="form-control" id="password" placeholder="Password" required>
          </div>
       
        </div>

        </form>
        
         <div class="col-lg-6 offset-lg-3 text-center" id="submit">
                <button class="btn btn-primary" type="submit">Sign In</button>
            </div>
        <div class="col-lg-6 offset-lg-3 text-center" id="sign">
                <button class="btn btn-primary" type="button">Sign up New Account</button>            
            </div>
     
        
    </body>
</html>