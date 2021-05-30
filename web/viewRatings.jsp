<%-- 
    Document   : viewRatings
    Created on : Jan 15, 2021, 12:26:24 PM
    Author     : Mahmoud Esmail
--%>

<%@page import="com.myhotel.Review"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Home</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
    function validate() {
    
        var hotelId = document.forms["form"]["hotelId"]; 
       


        if (hotelId.value === "") 
        { 
            window.alert("Please enter Hotel ID."); 
            hotelId.focus(); 
            return false; 
        }

       

        return true;
    }
  
    $(document).ready(function(){
        $('#submit').click(function(){
           validate();
        }); 
    });


    </script>
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



</style>
            <%
                List<Review> reviews = (List<Review>) request.getAttribute("REVIEWS");
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
        <li class="active"><a href="adminHome.jsp">Home</a></li>
        <li class="active"><a href="searchCustomer.jsp">Search Customer</a></li>
        <li class="active"><a href="updateHotels.jsp">Update Hotels</a></li>
        <li class="active"><a href="checkIn.jsp">Check in</a></li>
        <li class="active"><a href="checkOut.jsp">Check out</a></li>
         <li class="active"><a href="updateRooms.jsp">Update Rooms</a></li>
          <li class="active"><a href="viewRatings.jsp">View Ratings</a></li>
        <li class="active"><a href="adminHome.jsp?req=viewReservation">View Reservations</a></li>
        
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
<!--        <li><a href="changeCredentials.jsp"><span class="glyphicon glyphicon-user"></span>My Account</a></li>-->
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Sign out</a></li>
      </ul>
    </div>
  </div>
</nav>
    <body>
        
 
<div class="container">
<!--We use bootstrap to create tabs on the index.php page-->
   
    
<!--    Here we add the forms elements of the various tabs-->
    <div class="tab-content">
      
       <form id="form" action ="AdminControllerServlet" method="POST" >  
            <input type="hidden" name="command" value="getReviews" id ="command">
        <div class="container center_div">
          <div class="col-lg-6 offset-lg-3">
            <label for="validationDefault01">Hotel ID</label>
            <input type="text" class="form-control" id="hotelId" placeholder="Hotel ID" name="hotelId" required >
          </div>
       </div>
             <div class="col-lg-6 offset-lg-3 text-center" id="submit">
                <button class="btn btn-primary" type="submit">Search</button>
         </div>
         </form>
        
        
        
         <div id="table" >
      
         <table class="table">
        <thead>
            <tr>
            <th scope="col">Review Number</th>
            <th scope="col">Review comments</th>
            <th scope="col">Stars</th>
           
            </tr>
           <%   if(reviews != null)
           { %>
              <% 
              for (int i = 0 ; i < reviews.size(); i++)
              { %>
              
              <tr>
                  <td><%= reviews.get(i).getId() %></td>
                  <td><%= reviews.get(i).getComment() %></td>
                  <td><%= reviews.get(i).getStars() %></td>
              </tr>
                  
            <%  }}%>
             
        </thead>
       
        </table>
      
    
       </div>
    
       </div>
    </div>
    </body>
</html>

