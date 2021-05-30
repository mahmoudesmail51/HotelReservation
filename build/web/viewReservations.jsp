<%-- 
    Document   : viewReservations
    Created on : Jan 14, 2021, 11:45:46 PM
    Author     : Mahmoud Esmail
--%>

<%@page import="com.myhotel.Booking"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Reservations</title>
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

.crud{
    width: auto;
    color: white !important;
    font-size: 25px;
    font-weight: 600;
}
.home
{
     width: auto;
    color: white !important;
    font-size: 25px;
    font-weight: 600;
}

.sub_msg{
    text-align: center;
    padding: 10px 0px 20px 0px;
}

.signup{
    border: 1px solid #e7e7e7;
    text-align: center;
    width: 60%;
    height: auto;
    margin: auto;
}
.button
{   text-align: left;
     height: 40px;
    font-size: 20px;
    font-weight: bold;
    background-color: #1e8bc3;
    color: white !important;
}
.input_group{
    margin: 0px 20px 20px 20px;
}

.input_group input{
    height: 40px;
    font-size: 20px;
}

input[type="submit"]{
    height: 40px;
    font-size: 20px;
    font-weight: bold;
    background-color: #1e8bc3;
    color: white !important;
}

</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <% 
        
        List<Booking> bookings = (List<Booking>) request.getAttribute("BOOKINGS"); 
        
    %>
    
    <script>
      
        function cancelReservation(command,bookingID)
        {
            $.ajax
            ({
                type:'POST',
                data:{command:command,bookingID:bookingID},
                url: "CustomerControllerServlet",
                 success: function(result)
                 {
                       if(result === "canceled")
                       {
                            alert("Canceled successfully");
                            command="viewReservation";
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
                       }
                       else
                           alert("something went wrong!");

                 }
            });
        }
     
    </script>
    </head>
    
    <body>
        <!-- <nav class="navbar navbar-inverse ">
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
</nav> -->
         <div class="container">
<!--We use bootstrap to create tabs on the index.php page-->
   
<ul class="nav nav-tabs" id="myTab">
       <li>Search Results</li>
       
    </ul>

<!--    Here we add the forms elements of the various tabs-->
    <div class="tab-content">
      
    
       
     
       <div id="table">
        <table class="table">
        <thead>
            <tr>
            <th scope="col">Reservation Number</th>
            <th scope="col">Room Number</th>
            <th scope="col">Expected Price</th>
            </tr>
            
            
                <% for (int i = 0 ; i < bookings.size(); i++)
                { %>
                <tr>
                <td><%= bookings.get(i).getId() %></td>
                <td><%= bookings.get(i).getRoomId() %></td>
                <td><%= bookings.get(i).getPrice() %></td>
                <td>
                    <button type="button" class="btn btn-danger" onclick="cancelReservation('cancelReservation',<%=  bookings.get(i).getId() %>)">Cancel Reservation</button>
                </td>
                 <td>
                     <form action="CustomerControllerServlet" method="POST">
                         <input type="hidden" name="command" value="changeReservation" id ="command">
                         <input type="hidden" name="bookingId" value="<%= bookings.get(i).getId() %>" id ="command">
                         <input type="hidden" name="hotelId" value="<%= bookings.get(i).getHotelId() %>" id ="hotelId">
                         <button type="submit" class="btn btn-warning" >Change Reservation</button>
                     </form>
                </td>
                   </tr>
                <% } %>
                
                
           
            
        </thead>
       
        </table>
      
       
     
      </div>
             
    </div>
</div> 
        
        
    </body>
</html>
