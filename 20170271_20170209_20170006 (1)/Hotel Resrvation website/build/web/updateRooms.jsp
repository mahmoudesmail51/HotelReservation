<%-- 
    Document   : updateRooms
    Created on : Jan 15, 2021, 12:28:07 PM
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
    
        var roomId = document.forms["form"]["roomId"]; 
        var roomType = document.forms["form"]["roomType"]; 
        var roomPrice = document.forms["form"]["roomPrice"]; 
        var roomCapacity = document.forms["form"]["roomCapacity"]; 
        var roomAvailability = document.forms["form"]["isBooked"]; 
       
       
        console.log(roomAvailability);

        if (roomId.value === "") 
        { 
            window.alert("Please enter Room ID."); 
            roomId.focus(); 
            return false; 
        }
        
          if (roomType.value === "") 
        { 
            window.alert("Please enter Room Type."); 
            roomType.focus(); 
            return false; 
        }
        
          if (roomPrice.value === "") 
        { 
            window.alert("Please enter Room price"); 
            roomPrice.focus(); 
            return false; 
        }
        
          if (roomCapacity.value === "") 
        { 
            window.alert("Please enter Room Capacity"); 
            roomCapacity.focus(); 
            return false; 
        }
        
        
          if (roomAvailability.value === "") 
        { 
            window.alert("Please enter Room Availability."); 
            roomAvailability.focus(); 
            return false; 
        }
        
//          if (roomAvailability.value !==() 0 || roomAvailability.value !== 1 ) 
//        { 
//            window.alert("Please enter 1 or 0."); 
//            roomAvailability.focus(); 
//            return false; 
//        }
       
     

        return true;
    }
  
    $(document).ready(function(){
        $('#submit').click(function(){
            if (validate())
            {
                var roomId = $('#roomId').val();
                var roomType = $('#roomType').val();
                var roomPrice = $('#roomPrice').val();
                var roomCapacity = $('#roomCapacity').val();
                var isBooked = $('#isBooked').val();
                var command = $('#command').val();
                $.ajax({
                    type:'POST',
                    data:{roomId:roomId, roomType:roomType,roomPrice: roomPrice,roomCapacity:roomCapacity,isBooked:isBooked,command:command},
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
            <input type="hidden" name="command" value="updateRoom" id ="command">
        <div class="container center_div">
          <div class="col-lg-6 offset-lg-3">
            <label for="validationDefault01">Room ID</label>
            <input type="text" class="form-control" id="roomId" placeholder="Room ID" name="roomId" required >
          </div>
            <div class="col-lg-6 offset-lg-3">
            <label for="validationDefault01">Room Type</label>
            <input type="text" class="form-control" id="roomType" placeholder="Room Type" name="roomType" required >
          </div>
            <div class="col-lg-6 offset-lg-3">
            <label for="validationDefault01">Room Price</label>
            <input type="text" class="form-control" id="roomPrice" placeholder="Room Price" name="roomPrice" required >
          </div>
            <div class="col-lg-6 offset-lg-3">
            <label for="validationDefault01">Room capacity</label>
            <input type="text" class="form-control" id="roomCapacity" placeholder="Room capacity"  name="roomCapacity" required >
          </div>
            <div class="col-lg-6 offset-lg-3">
            <label for="validationDefault01">Availability (0 OR 1)</label>
            <input type="text" class="form-control" id="isBooked" placeholder="Availability" name="isBooked" required >
          </div>
           
            </div>
       
       </form>
        <br>
         <div class="col-lg-6 offset-lg-3 text-center" id="submit">
                <button class="btn btn-primary" type="submit">Update</button>
         </div>
        
        <span id="updateResult"></span>
       </div>
    </div>
    </body>
</html>


