<%-- 
    Document   : temp
    Created on : Jan 12, 2021, 4:14:39 PM
    Author     : Mahmoud Esmail
--%>

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
   <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
  
  
 
      
      
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
  <script>
               
        $(document).ready(function()
        {
            $('#viewReservationButton').click(function()
            {
                var command="viewReservation";
                $.ajax
                ({
                    type:'POST',
                    data:{command:command},
                    url: "CustomerControllerServlet",
                     success: function(result)
                     {
                           $("#content").html(result);
                     }
                });
            });
              $('#signOutButton').click(function()
            {
                var command="sign out";
                $.ajax
                ({
                    type:'POST',
                    data:{command:command},
                    url: "CustomerControllerServlet",
                     success: function()
                     {
                           window.location.href = "sign-in.jsp";
                     }
                });
            });
            $('#home').click(function()
            {
                window.location.href = "temp.jsp";
            });
        });
        
    </script>
     <%
         if(request.getParameter("req")!= null) {
         String s = request.getParameter("req");
            if (s.equals("viewReservation"))
            {     %>
            <script>
                var command="viewReservation";
                $.ajax
                ({
                    type:'POST',
                    data:{command:command},
                    url: "CustomerControllerServlet",
                     success: function(result)
                     {
                           $("#content").html(result);
                     }
                });
            </script>
            <% } 
        }%>
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
        <li class="active"><a id="home">Home</a></li>
        <li ><a id="viewReservationButton">View Reservation</a></li>
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
        <li><a id="signOutButton"><span class="glyphicon glyphicon-log-in"></span> Sign out</a></li>
      </ul>
    </div>
  </div>
</nav>
   
    <div id="content">
            
   <form action="CustomerControllerServlet" method="POST" >
       <input type="hidden" name="command" value="search" id ="command">
       
  <div class="col-md-9 col-md-offset-4 text-center">
    <div class="input-group col-xs-3  edit edit2">
      <input id="destination" type="text" class="form-control input-lg" name="destination" placeholder="Enter your destination" required>
    
        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
        </div>

    <div class="input-group  edit">
        <input id="checkin" name="checkin" width="270" class="input-lg" placeholder="Enter check-in date" required>
    <script>
        $('#checkin').datepicker({
            uiLibrary: 'bootstrap'
        });
    </script>

    </div>
    
    <div class="input-group col-xs-3  edit">
       <input id="checkout" name="checkout" width="270" class="input-lg" placeholder="Enter check-out date" required>
    <script>
        $('#checkout').datepicker({
            uiLibrary: 'bootstrap'
        });
    </script>
    </div>
     <div class="input-group col-xs-3 edit">
        <input id="numberofadults" type="text" name="numberofadults" class="form-control input-lg" name="destination" placeholder="Enter number of adults" required>
        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>

    </div>
    <div class="input-group col-xs-3 edit">
      <input id="numberofchildren" name="numberofchildren" type="text" class="form-control input-lg" name="destination" placeholder="Enter number of children" required>
      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
    </div>
    <br>
    <div class="col-lg-3 sign " id="sign">
         <button class="btn btn-primary btn-lg" type="submit">Search   </button>
         
    </div>
    
    </div>
  </form>
    
    </div>
    
           
</body>
</html>
