<%-- 
    Document   : list_customers
    Created on : Jan 5, 2021, 11:08:57 AM
    Author     : Mahmoud Esmail
--%>
<%@page import="com.myhotel.Hotel"%>
<%@page import="java.util.List"%>
<%@ page import="java.util.*,com.myhotel.*"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customers page</title>
        <!-- send this variables to controller in order to filter -->
        <% List<Hotel> hotels = (List<Hotel>) request.getAttribute("HOTEL_LIST"); 

           String checkInDate = request.getAttribute("CHECK_IN_DATE").toString();
           String checkOutDate = request.getAttribute("CHECK_OUT_DATE").toString();
           String noOfAdults = request.getAttribute("NO_OF_ADULTS").toString();
           String noOfChildren = request.getAttribute("NO_OF_CHILDREN").toString();
  
        
        %>
        
       
  
     
      
    </head>
   
 <nav class="navbar navbar-inverse ">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
        <a href="../src/java/com/myhotel/CustomerControllerServlet.java"></a>
      </button>
      <a class="navbar-brand">Hotel Bookings</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="temp.jsp">Home</a></li>
        <li></li>
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
<!--We use bootstrap to create tabs on the index.php page-->
    <ul class="nav nav-tabs" id="myTab">
       <li><a>Search Results</a></li>
       
    </ul>
    
<!--    Here we add the forms elements of the various tabs-->
    <div class="tab-content">
      
       
       
       <div id="table" >
      
         <table class="table">
        <thead>
            <tr>
            <th scope="col">Hotel Name</th>
           
            <th scope="col">Expected Price</th>
            <th scope="col">Rating</th>
           
            <th scope="col">Image URL</th>
            <th scope="col">Location map</th>
            <th scope="col">Select Hotel</th>
            </tr>
              <% for (int i =0;i<hotels.size();i++)
            
        { %>
            <tr>
                <td><%= hotels.get(i).getHotelName() %> </td>
             
                <td> <%= hotels.get(i).getExpectedPrice() %></td>
                <td> <%= hotels.get(i).getRating() %></td>
              
                <td> <img src="background.png" alt="" border=3 height=100 width=200></img> </td>
                <td> <div> <%= hotels.get(i).getLocation() %></div> </td>
                <td> <form action="CustomerControllerServlet">
                        <input type="hidden" name="command" value="get rooms" id ="command">
                        <input type="hidden" name="checkIn" value="<%= checkInDate %>" id ="checkIn">
                        <input type="hidden" name="checkOut" value="<%= checkOutDate %>" id ="checkOut">
                        <input type="hidden" name="noOfAdults" value="<%= noOfAdults %>" id ="noOfAdults">
                        <input type="hidden" name="noOfChildren" value="<%= noOfChildren %>" id ="noOfChildren">
                        
                        <input type="hidden" name="hotel_id" value="<%= hotels.get(i).getId()%>" id ="hotel_id">
                        <button type="submit" class="btn btn-primary">Select</button>
                     </form>
                </td>
                 <td> 
                     <form action="CustomerControllerServlet" method="POST">
                         <input type="hidden" name="command" value="get reviews" id ="command">
                         <input type="hidden" name="hotelId" value="<%= hotels.get(i).getId()%>" id ="hotelId">
                        <button type="submit" class="btn btn-success">Check reviews</button>
                     </form>
                </td>
            </tr>
              <%  } %>
        </thead>
       
        </table>
      
    
       </div>
    </div>
</div> 



</body>
</html>
