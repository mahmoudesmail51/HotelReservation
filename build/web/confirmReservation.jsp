<%-- 
    Document   : confirmReservation
    Created on : Jan 14, 2021, 10:11:19 AM
    Author     : Mahmoud Esmail
--%>

<%@page import="com.myhotel.Room"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rooms</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
 <style type="text/css" >
 body{
    background-color: #ffffff;
    font-size: 20px;
    margin: 0;
    padding: 0;
    font-family: 'Tangerine', serif;
    color: #6a6666;
}

</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <%
            List<Room> rooms = (List<Room>) request.getAttribute("SELECTED_ROOMS");
            String reservedRoomString = request.getAttribute("RESERVED_ROOM_STRING").toString();
             
            String checkInDate = request.getAttribute("CHECK_IN_DATE").toString();
            String checkOutDate = request.getAttribute("CHECK_OUT_DATE").toString();
            
            String pw = request.getAttribute("PASSWORD").toString();
        %>  
        
    <p><%= pw %></p>

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script>
 function validate() 
    {
    
        var password = document.getElementById("password").value;
        var confirmedPassword = document.getElementById("confirmedPassword").value;
        
        
     
        
         
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
           
            return false;
            
        }
        
       
      
        return true;
    }
    $(document).ready(function(){
        $('#submit').click(function(){
            if(validate())
            {
                 var password = document.getElementById("password").value;
                 
               
                 
                if ( password == <%= pw %> )
                {
                    $("#confirmForm").submit();
                }
                else
                    alert("WRONG PASSWORD");
            }
        }); 
    });
      
</script>
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
        <li><a href="changeCredentials.jsp"><span class="glyphicon glyphicon-user"></span>My Account</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Sign out</a></li>
      </ul>
    </div>
  </div>
</nav>
        
        <div class="container">

    <ul class="nav nav-tabs" id="myTab">
       <li>Confirm Reservation - Final checkout</li>
    </ul>
    
<!--    Here we add the forms elements of the various tabs-->
    <div class="tab-content">
        
        <h1 style="float:left;width:50%">Welcome, <%= session.getAttribute("session_fname")  %>. </h1>
       
        <p style="margin-top: 10px;float: left;width: 50%;">Check in Date:<%= checkInDate %></p>
        <p>Check out Date:<%= checkOutDate %></p>
          
        
        
         <h3>Confirm your password in-order to continue. </h3>
        
        <div class="col-lg-6 offset-lg-3" style="margin-top: 15px;">
            <label for="validationDefault01">Password</label>
            <input type="password" class="form-control" id="password" placeholder="" name="password" required >
        </div>
        
        <div class="col-lg-6 offset-lg-3" style="margin-top: 15px;">
            <label for="validationDefault01">Confirm password</label>
            <input type="password" class="form-control" id="confirmedPassword" placeholder="" name="confirmedPassword" required >
            <br>
         </div>
        
        
        <h3>Order Summary</h3>
      
    
       
    <div id="table">
         <table class="table">
        <thead>
            <tr>
            <th></th>
            <th scope="col">Room Number</th>
            <th scope="col">Room Type</th>
            <th scope="col">Capacity</th>
            <th scope="col">Expected Price</th>
            </tr>
            <% int total = 0;
                for(int i=0;i<rooms.size();i++)
            {
                total += rooms.get(i).getPrice();
                %>
            <tr>
                <td><img src="background.png" border=3 height=100 width=200 /></td>
                <td><%= rooms.get(i).getId()%></td>
                <td><%= rooms.get(i).getType() %></td>
                <td><%= rooms.get(i).getCapacity() %></td>
                <td><%= rooms.get(i).getPrice() %></td>
            </tr>
             <%  } %>
             <tr>
                <td></td>
                <td></td>
                <td></td>
                <td style="color: green"><b>Total</b></td>
                 <td>
                     <%= total %>
                 </td>
             </tr>
             <tr>
                <td style="border-top: none;"></td>
                <td style="border-top: none;"></td>
                <td style="border-top: none;"></td>
                <td colspan="2">
                    <form action="CustomerControllerServlet" method="POST" id="confirmForm">
                         <input type="hidden" name="command" value="reserve" id ="command">
                          <input type="hidden" name="reservedRoomString" value="<%= reservedRoomString%>" id ="reservedRoomString">
                        <input type="hidden" name="checkIn" value="<%= checkInDate %>" id ="checkIn">
                        <input type="hidden" name="checkOut" value="<%= checkOutDate %>" id ="checkOut">
                         <input type="hidden" name="userName" value="<%= session.getAttribute("session_username") %>" id ="userName">
                        
                    </form>
                     <button type="submit" id="submit" class="btn btn-success">Confirm Reservation</button>
                 </td>
             </tr>
        </thead>
       
        </table>
        

       
    </div>
</div> 
        
        
    </body>
    
   
    </script
</html>
