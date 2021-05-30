<%-- 
    Document   : changeCredentials
    Created on : Jan 13, 2021, 12:01:01 PM
    Author     : Mahmoud Esmail
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="https://code.jquery.com/jquery-3.1.1.js"></script>
  
  
    <script>
    function validate() 
    {
        var fname = document.forms["form"]["firstname"]; 
        var lname = document.forms["form"]["lastname"]; 
        var password = document.getElementById("password").value;
        var confirmedPassword = document.getElementById("confirmedpassword").value;
        var phoneNumber = document.forms["form"]["phonenumber"]; 
        
     
        
        if (fname.value === "") 
        { 
            window.alert("Please enter your first name."); 
            fname.focus(); 
            return false; 
        } 
          if (lname.value === "") 
        { 
            window.alert("Please enter your last name."); 
            fname.focus(); 
            return false; 
        } 
        if (password === "") 
        { 
            window.alert("Please enter your password."); 
            password.focus(); 
            return false; 
        } 
         if (confirmedPassword === "") 
        { 
            window.alert("Please confirm your password."); 
            confirmedPassword.focus(); 
            return false; 
        } 
           if (!(password === confirmedPassword)) 
        { 
            window.alert("Password doesn't match."); 
            lname.focus(); 
            return false;
            
        }
        
          if (phoneNumber.value === "") 
        { 
            window.alert("Please enter your phonenumber."); 
            lname.focus(); 
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
                
                var phonenumber = $('#phonenumber').val();
                var password = $('#password').val();
                var command = $('#command').val();
                $.ajax({
                    type:'POST',
                    data:{fname:fname,lname:lname,phonenumber:phonenumber,command:command,password:password},
                    url: "CustomerControllerServlet",
                    success: function(result)
                    {
                        alert(result);
                        
                    }
                });
            }
        }); 
    });
    </script>
 
      
      
  <style type="text/css" >
      
       body{
            position: relative;
            height :100%; 
            color: black;
            font-family: 'Tangerine', serif;
            font-size: 20px;
           

        }
      .center_div{
          padding: 35px;
          margin-top: 25px;
          line-height: 2;
        }
      .edit{
          margin: 30px;
          text-align: center;
      }
      .edit2{
          padding-top: 35px;
      }
    
  </style>
</head>
<body>

<nav class="navbar navbar-inverse ">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand">Hotel Bookings</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="temp.jsp">Home</a></li>
        <li class="active"><a href="temp.jsp?req=viewReservation">View Reservations</a></li>
        <li class="dropdown">
        
          <ul class="dropdown-menu">
            <li></li>
            <li></li>
            <li></li>
          </ul>
        </li>
        <li></li>
        <li></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span>My Account</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Sign out</a></li>
      </ul>
    </div>
  </div>
</nav>
   
    <% 
        
        String fname = session.getAttribute("session_fname").toString();
        String lname = session.getAttribute("session_lname").toString();
        String phoneNumber = session.getAttribute("session_phonenumber").toString();

    %>
    
     <form id="form" >  
            <input type="hidden" name="command" value="updateInfo" id ="command">
        <div class="container center_div">
          <div class="col-lg-6 offset-lg-3">
            <label for="validationDefault01">First name</label>
            <input type="text" class="form-control" id="firstname" placeholder="<%= fname %>" name="firstname" required >
          </div>
          <div class="col-lg-6 offset-lg-3">
            <label for="validationDefault02">Last name</label>
            <input type="text" class="form-control" id="lastname" placeholder="<%= lname%>" name="lastname" required >
          </div>
          <div class="col-lg-6 offset-lg-3">
            <label for="validationDefaultUsername">Password</label>
            <div class="input-group">
             
              <input type="password" class="form-control" id="password" placeholder="*********" name="password" aria-describedby="inputGroupPrepend2" required >
            </div>
          </div>
             <div class="col-lg-6 offset-lg-3">
            <label for="validationDefaultUsername">Confirm Password</label>
            <div class="input-group">
             
              <input type="password" class="form-control" id="confirmedpassword" placeholder="*********" name="confirmedpassword" aria-describedby="inputGroupPrepend2" required >
            </div>
          </div>
          <div class="col-lg-6 offset-lg-3">
            <label for="validationDefault03">Phone Number</label>
            <input type="text" class="form-control" id="phonenumber" placeholder="<%= phoneNumber %>" name="phonenumber" required >
          </div>
          
            
            
        </div>
   
        </form>
    
     <div class="col-lg-6 offset-lg-3 text-center" id="submit">
        <button class="btn btn-primary"  type="submit">Confirm changes</button>
     </div>
    
   

 
           
</body>
</html>