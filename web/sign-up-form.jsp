<%-- 
    Document   : sign-up-form
    Created on : Jan 5, 2021, 2:11:02 PM
    Author     : Mahmoud Esmail
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign up</title>
       
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
           padding:12px;
       } 
        h1{
            text-align: center;
            margin-top:65px;
            margin-bottom: 60px;
         }
    </style>
    <script src="https://code.jquery.com/jquery-3.1.1.js"></script>
    <script>
    function validate() {
    
        var fname = document.forms["form"]["firstname"]; 
        var lname = document.forms["form"]["lastname"]; 
        var userName = document.forms["form"]["username"]; 
        var phoneNumber = document.forms["form"]["phonenumber"]; 
        var email = document.forms["form"]["email"]; 


        if (fname.value === "") 
        { 
            window.alert("Please enter your first name."); 
            fname.focus(); 
            return false; 
        }

        if (lname.value === "") 
        { 
            window.alert("Please enter your last name."); 
            lname.focus(); 
            return false; 
        } 

        if (userName.value === "") 
        { 
            window.alert("Please enter your user name"); 
            userName.focus(); 
            return false; 
        }

         if (phoneNumber.value === "") { 
            window.alert( 
              "Please enter your phone number."); 
            phoneNumber.focus(); 
            return false; 
        } 

        if (email.value === "") { 
            window.alert( 
              "Please enter a valid e-mail address."); 
            email.focus(); 
            return false; 
        } 

        return true;
    }
  
    $(document).ready(function(){
        $('#submit').click(function(){
            if (validate())
            {
                var fname = $('#firstname').val();
                var lname = $('#lastname').val();
                var user = $('#username').val();
                var phonenumber = $('#phonenumber').val();
                var email = $('#email').val();
                var command = $('#command').val();
                $.ajax({
                    type:'POST',
                    data:{fname:fname,lname:lname,user:user,Phonenumber:phonenumber,Email:email,command:command},
                    url: "CustomerControllerServlet",
                    success: function(result)
                    {
                        alert(result);
                        if (result === "SUCCESS")
                        {
                            window.location.href = "sign-in.jsp";
                        }
                        else
                        {
                            
                        }   
                    }
                });
            }
        }); 
    });


    </script>
    </head>
    
    <body>
        <h1>Sign Up</h1>
        <form id="form" >  
            <input type="hidden" name="command" value="register" id ="command">
        <div class="container center_div">
          <div class="col-lg-6 offset-lg-3">
            <label for="validationDefault01">First name</label>
            <input type="text" class="form-control" id="firstname" placeholder="First name" name="firstname" required >
          </div>
          <div class="col-lg-6 offset-lg-3">
            <label for="validationDefault02">Last name</label>
            <input type="text" class="form-control" id="lastname" placeholder="Last name" name="lastname" required >
          </div>
          <div class="col-lg-6 offset-lg-3">
            <label for="validationDefaultUsername">Username</label>
            <div class="input-group">
             
              <input type="text" class="form-control" id="username" placeholder="Username" name="username" aria-describedby="inputGroupPrepend2" required >
            </div>
          </div>
          <div class="col-lg-6 offset-lg-3">
            <label for="validationDefault03">Phone Number</label>
            <input type="text" class="form-control" id="phonenumber" placeholder="Phone Number" name="phonenumber" required >
          </div>
          <div class="col-lg-6 offset-lg-3">
            <label for="validationDefault04">Email</label>
            <input type="email" class="form-control" id="email" placeholder="Email" name="email" required >
          </div>
            
            
        </div>
            
        </form>
        <div class="col-lg-6 offset-lg-3 text-center" id="submit" style="padding-top: 0;">
            <button type="submit" id="submit" name="submit" class="btn btn-primary">sign up</button>
        </div>
    </body>
</html>