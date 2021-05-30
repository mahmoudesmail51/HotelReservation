<%-- 
    Document   : updateHotels
    Created on : Jan 15, 2021, 12:24:30 PM
    Author     : Mahmoud Esmail
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Home</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<script>
    function validate() {
    
        var hotelId = document.forms["form"]["hotelId"]; 
        var hotelName = document.forms["form"]["hotelName"]; 
        var hotelRating = document.forms["form"]["hotelRating"]; 
        var hotelAvailabillity = document.forms["form"]["hotelAvailabillity"]; 
        var expectedPrice = document.forms["form"]["expectedPrice"]; 
        var hotelPhoto = document.forms["form"]["hotelPhoto"]; 
        var hotelCity = document.forms["form"]["hotelCity"]; 
       


        if (hotelId.value === "") 
        { 
            window.alert("Please enter Hotel ID."); 
            hotelId.focus(); 
            return false; 
        }
        
          if (hotelName.value === "") 
        { 
            window.alert("Please enter Hotel Name."); 
            hotelName.focus(); 
            return false; 
        }
        
          if (hotelRating.value === "") 
        { 
            window.alert("Please enter Hotel Rating"); 
            hotelRating.focus(); 
            return false; 
        }
        
          if (hotelAvailabillity.value === "") 
        { 
            window.alert("Please enter Hotel Availabillity"); 
            hotelAvailabillity.focus(); 
            return false; 
        }
           if (expectedPrice.value === "") 
        { 
            window.alert("Please enter Hotel expected Price."); 
            expectedPrice.focus(); 
            return false; 
        }
        
        
          if (hotelPhoto.value === "") 
        { 
            window.alert("Please enter hotel photo url."); 
            hotelPhoto.focus(); 
            return false; 
        }
          if (hotelCity.value === "") 
        { 
            window.alert("Please enter hotel city."); 
            hotelCity.focus(); 
            return false; 
        }
     

        return true;
    }
  
    $(document).ready(function(){
        $('#submit').click(function(){
            if (validate())
            {
                var hotelId = $('#hotelId').val();
                var hotelName = $('#hotelName').val();
                var hotelAvaillability = $('#hotelAvailabillity').val();
                var hotelRating = $('#hotelRating').val();
                var expectedPrice = $('#expectedPrice').val();
                var hotelPhoto = $('#hotelPhoto').val();
                var hotelCity = $('#hotelCity').val();
                var hotelLocation = $('#hotelLocation').val();
              
                var command = $('#command').val();
                $.ajax({
                    type:'POST',
                    data:{hotelId:hotelId, hotelName:hotelName,hotelAvailabillity: hotelAvaillability,hotelRating:hotelRating,expectedPrice:expectedPrice,hotelPhoto:hotelPhoto,hotelCity:hotelCity,hotelLocation:hotelLocation,command:command},
                    url: "AdminControllerServlet",
                    success: function(result)
                    {
                        $('#updateResult').html(result);
                       
                    }
                });
            }
        }); 
    });


    </script>
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
      
               <form id="form" >  
            <input type="hidden" name="command" value="updateHotel" id ="command">
        <div class="container center_div">
          <div class="col-lg-6 offset-lg-3">
            <label for="validationDefault01">Hotel ID</label>
            <input type="text" class="form-control" id="hotelId" placeholder="hotel ID" name="hotelId" required >
          </div>
            <div class="col-lg-6 offset-lg-3">
            <label for="validationDefault01">Hotel Name</label>
            <input type="text" class="form-control" id="hotelName" placeholder="Hotel Name" name="hotelName" required >
          </div>
            <div class="col-lg-6 offset-lg-3">
            <label for="validationDefault01">Hotel Rating</label>
            <input type="text" class="form-control" id="hotelRating" placeholder="Hotel Rating" name="hotelRating" required >
          </div>
            <div class="col-lg-6 offset-lg-3">
            <label for="validationDefault01">Hotel availability</label>
            <input type="text" class="form-control" id="hotelAvailabillity" placeholder="Hotel Availabillity" name="hotelAvailabillity" required >
          </div>
            <div class="col-lg-6 offset-lg-3">
            <label for="validationDefault01">Expected Price</label>
            <input type="text" class="form-control" id="expectedPrice" placeholder="Expected Price" name="expectedPrice" required >
          </div>
            <div class="col-lg-6 offset-lg-3">
            <label for="validationDefault01">Hotel Photo</label>
            <input type="text" class="form-control" id="hotelPhoto" placeholder="Hotel Photo" name="hotelPhoto" required >
          </div>
            </div>
            <div class="col-lg-6 offset-lg-3">
            <label for="validationDefault01">Hotel City</label>
            <input type="text" class="form-control" id="hotelCity" placeholder="Hotel Photo" name="hotelCity" required >
          </div>
            
              <div class="col-lg-6 offset-lg-3">
            <label for="validationDefault01">Hotel Location</label>
            <input type="text" class="form-control" id="hotelLocation" placeholder="Hotel Location" name="hotelLocation" required >
          </div>
            
        
    
       </div>
         </form>
        
         <div class="col-lg-6 offset-lg-3 text-center" id="submit">
                <button class="btn btn-primary" type="submit">Update</button>
         </div>
        
        <span id="updateResult"></span>
    
       </div>
    </div>
    </body>
</html>

