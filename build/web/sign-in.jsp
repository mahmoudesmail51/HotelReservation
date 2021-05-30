<%-- 
    Document   : sign-in
    Created on : Jan 6, 2021, 2:52:32 PM
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
         
       function signUp()
       {
           window.location.href = "sign-up-form.jsp";
       }
    function validate() 
    {
        var username = document.forms["form"]["username"]; 
        var password = document.forms["form"]["password"]; 
        if (username.value === "") 
        { 
            window.alert("Please enter your user name."); 
            fname.focus(); 
            return false; 
        } 
        if (password.value === "") 
        { 
            window.alert("Please enter your password."); 
            lname.focus(); 
            return false; 
        } 
      
        return true;
    }
  
    $(document).ready(function()
    {
        $('#submit').click(function()
        {

        var username = $('#username').val();
        var password = $('#password').val();
        var command = $('#command').val();

        $.ajax
        ({
            type:'POST',
            data:{username:username,password:password,command:command},
            url: "CustomerControllerServlet",
             success: function(result)
             {
                   if(result == "1")
                   {
                       window.location.href = "temp.jsp";
                   }
                   else
                       alert("Wrong credentials!")
                        
             }
        });
        });
      
    });


    </script>
    
    </head>
    
    <body>
        <h1>Sign In</h1>
        <form id="form" method ="POST" >   
            <input type="hidden" name="command" value="sign in" id ="command">
            
        <div class="container center_div">
          <div class="col-lg-6 offset-lg-3">
            <label for="validationDefaultUsername">Username</label>
            <div class="input-group">
             
              <input type="text" class="form-control" id="username" placeholder="Username" aria-describedby="inputGroupPrepend2" >
            </div>
          </div>
            
          <div class="col-lg-6 offset-lg-3">
            <label for="validationDefault03">Password</label>
            <input type="password" class="form-control" id="password" placeholder="Password">
          </div>
       
        </div>

        </form>
        
         <div class="col-lg-6 offset-lg-3 text-center" id="submit">
                <button class="btn btn-primary" type="submit">Sign In</button>
            </div>
        <div class="col-lg-6 offset-lg-3 text-center" id="sign">
                <button class="btn btn-primary" onClick="signUp();" type="button">Sign up New Account</button>            
            </div>
     
        
    </body>
</html>

