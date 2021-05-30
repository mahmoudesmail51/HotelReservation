<%-- 
    Document   : roomsResult
    Created on : Jan 13, 2021, 4:25:47 PM
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
    </head>
      <% List<Room> rooms = (List<Room>) request.getAttribute("ROOM_LIST"); 
            String checkInDate = request.getAttribute("CHECK_IN_DATE").toString();
           String checkOutDate = request.getAttribute("CHECK_OUT_DATE").toString();
           String noOfAdults = request.getAttribute("NO_OF_ADULTS").toString();
           String noOfChildren = request.getAttribute("NO_OF_CHILDREN").toString();
      
      %>
       
                        
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
<!--We use bootstrap to create tabs on the index.php page-->
   
<p style="float: left;border-bottom: 1px solid #ddd;width: 40%;">Rooms</p>
<div id="reservedRooms" style="border-bottom: 1px solid #ddd;width: 60%;float: left;">Selected Rooms:</div>
<!--    Here we add the forms elements of the various tabs-->
    <div class="tab-content">
      
    
       
     
       <div id="table">
        <table class="table">
        <thead>
            <tr>
            <th scope="col">Room Number</th>
            <th scope="col">Room Type</th>
            <th scope="col">Expected Price</th>
            <th scope="col">Capacity</th>
            <th scope="col">Available or not</th>
            </tr>
            <% for(int i=0;i<rooms.size();i++)
            { %>
            <tr>
                <td><%= rooms.get(i).getId()%></td>
                <td><%= rooms.get(i).getType() %></td>
                <td><%= rooms.get(i).getPrice() %></td>
                <td><%= rooms.get(i).getCapacity() %></td>
                <td><%= rooms.get(i).isBooked() %></td>
                 <td>
                 <button type="button" onClick="reserveRoom(<%= rooms.get(i).getId()%>)" class="btn btn-primary">Select</button>
                   <button type="button" onClick="removeRoom(<%= rooms.get(i).getId()%>)" class="btn btn-danger">Remove</button>
                </td>
            </tr>
             <%  } %>
        </thead>
       
        </table>
        <br>
        <form id="reservationForm" action="CustomerControllerServlet" method="POST">

            <input type="hidden" id="command" name="command" value="select rooms">
               <input type="hidden" name="checkIn" value="<%= checkInDate %>" id ="checkIn">
            <input type="hidden" name="checkOut" value="<%= checkOutDate %>" id ="checkOut">
            <input type="hidden" name="noOfAdults" value="<%= noOfAdults %>" id ="noOfAdults">
            <input type="hidden" name="noOfChildren" value="<%= noOfChildren %>" id ="noOfChildren">
             <input type="hidden" id="reservedRoomsString" name="reservedRoomsString" value="">
        </form>
        <br/>
        <button onClick="reserve()" id="button" type="button" class="btn btn-primary" style="margin-left: 35%;padding: 10px 130px;"> Submit</button>
     
      </div>
             
    </div>
</div> 
        
        
    </body>
    
    <script>
        let reservedRooms = [];
        function fillReservedRooms(){
            var s = 'Selected Rooms: ';
            for(let i = 0; i < reservedRooms.length; i++){
                if(i === 0)
                    s += reservedRooms[i];
                else
                    s += " - " + reservedRooms[i];
                                    
            }
            document.getElementById("reservedRooms").innerHTML = s;
        }
        
        function reserveRoom(room_id){
            let found = reservedRooms.indexOf(room_id);
            if(found === -1){
                reservedRooms.push(room_id);
//                document.getElementById("reservedRooms").innerHTML += room_id;
                fillReservedRooms();
                console.log(reservedRooms);
            }
        }
      function removeRoom(room_id)
      {
          const index = reservedRooms.indexOf(room_id);
          if (index > -1)
          {
              reservedRooms.splice(index,1);
              //document.getElementById("reservedRooms").innerHTML = room_id;
              fillReservedRooms();
              console.log(reservedRooms);
          }

      }
        
        function reserve()
        {
            
            let reservedRoomsString = "";
            for(let i = 0; i < reservedRooms.length; i++){
                if(i === 0)
                    reservedRoomsString += reservedRooms[i];
                else
                    reservedRoomsString += "," + reservedRooms[i];
            }
           if(reservedRoomsString !== "")
           {
             $('#reservedRoomsString').val(reservedRoomsString);
             $('#reservationForm').submit();
           }
           else
               alert("CHOOSE ITEMS");
        }
    </script>
</html>
