<%-- 
    Document   : viewReviews
    Created on : Jan 15, 2021, 4:54:18 PM
    Author     : Mahmoud Esmail
--%>

<%@page import="com.myhotel.Review"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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
.moving{
    margin-left:370px; 
    padding-top: 150px;
}

.pad{
    margin-top:60px;
}
.checked {
  color: orange;
}

</style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customers page</title>
        <!-- send this variables to controller in order to filter -->
        <% List<Review> reviews = (List<Review>) request.getAttribute("REVIEWS"); 


           int hotelId = (int) request.getAttribute("hotelId");

          
  
        
        %>
    
       
    <script>
               
        $(document).ready(function()
        {
            $('#reviewButton').click(function()
            {
                var command="review";
                var hotelId ="<%= hotelId %>" ;
                var comment = $("#review").val();
                var stars = $("#stars").val();
                $.ajax
                ({
                    type:'POST',
                    data:{command:command,comment:comment,hotelId:hotelId,stars:stars},
                    url: "CustomerControllerServlet",
                     success: function(result)
                     {
                        command = "get reviews";
                        window.location.href = "CustomerControllerServlet?command=get reviews&hotelId=" + hotelId;
                     }
                });
            });
            
            $('#home').click(function()
            {
                window.location.href = "temp.jsp";
            });
        });
        
    </script>
     
      
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
       <li><a>Reviews </a></li>
       
    </ul>
    
<!--    Here we add the forms elements of the various tabs-->
    <div class="tab-content">
      
       <div id="table" >
      
         <table class="table">
        <thead>
            <tr>
            <th scope="col">Review Number</th>
            <th scope="col">Review comments</th>
            <th scope="col">Stars</th>
           
            </tr>
              
              <% 
              for (int i = 0 ; i < reviews.size(); i++)
              { %>
              
              <tr>
                  <td><%= reviews.get(i).getId() %></td>
                  <td><%= reviews.get(i).getComment() %></td>
                  <td><%= reviews.get(i).getStars() %></td>
              </tr>
                  
            <%  }%>
             
        </thead>
       
        </table>
            
            <div class="container">
            <div class="input-group edit edit2 moving" >
                <textarea id="review" type="text" class="form-control input-lg" placeholder="Enter your review"></textarea>
                <div class="pad">
                <select id="stars" >
                    <option value="1"><span class="fa fa-star checked"></span> 1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select>
                     <button id="reviewButton" style="margin-left: 100px">Review</button>
                </div>    
                
           </div>
            </div>
    
       </div>
    </div>
</div> 



</body>
</html>