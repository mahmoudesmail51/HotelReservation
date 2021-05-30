/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhotel;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 *
 * @author Mahmoud Esmail
 */
@WebServlet(name = "CustomerControllerServlet", urlPatterns = {"/CustomerControllerServlet"})
public class CustomerControllerServlet extends HttpServlet {

    private CustomerDbUtil customerDbUtil;
    
    private HotelDbUtil hotelDbUtil;
    
    private RoomDbUtil roomDbUtil;
    
    private BookingDbUtil bookingDbUtil;
    
    private ReviewsDbUtil reviewsDbUtil;
    
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        
        try
        {
           dataSource =  getMySQLDataSource();
           
           customerDbUtil = new CustomerDbUtil(dataSource);
            hotelDbUtil = new HotelDbUtil(dataSource);
             bookingDbUtil = new BookingDbUtil(dataSource);
            roomDbUtil = new RoomDbUtil(dataSource);
            
            reviewsDbUtil = new ReviewsDbUtil(dataSource);
             
            
        }catch(Exception exc)
        {
            exc.printStackTrace();
        }
    }
    
    public static DataSource getMySQLDataSource()
    {
        
        String url = "jdbc:mysql://localhost:3306/my_hotel"; 
        String userName = "webstudent";
        String password = "webstudent"; 
        MysqlDataSource DS = new MysqlDataSource();
        
        DS.setURL(url);
        DS.setUser(userName);
        DS.setPassword(password);
     
        
        
        
        return DS;     
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            String command = request.getParameter("command");
            
            
            
            switch(command)
            {
                case "register":
                    registerCustomer(request,response);
                    break;
                    
                case "sign in":
                    login(request,response);
                    break;
                    
                case "search":
                    searchResults(request,response);
                    break;
                    
                case "get rooms":
                    getRooms(request,response);
                    break;
                    
                case "select rooms":
                    selectRooms(request,response);
                    break;
                 
                    
                case "get reviews":
                    getReviews(request,response);
                    break;
                    
                    
                case "reserve":
                    reserve(request,response);
                    break;
                
                    
                case "updateInfo":
                    updateInfo(request,response);
                    break;
                    
                case "viewReservation":
                    viewReservation(request,response);
                    break;
                case "cancelReservation":
                    cancelReservation(request,response);
                    break;
                    
                case "changeReservation":
                    changeReservation(request,response);
                    break;
                    
                case "confirmChangeReservation":
                    confirmChangeReservation(request,response);
                    break;
                    
                case "review":
                    review(request,response);
                    break;
                    
                case "sign out":
                    signOut(request,response);
                    break;
                
            }
            
          
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CustomerControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CustomerControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private List<Customer> getCustomers() throws SQLException
    {
        List<Customer> customers = customerDbUtil.getCustomers();
        
        
        return customers;
    }
    private void registerCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, Exception 
    {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String userName = request.getParameter("user");
        String phoneNumber = request.getParameter("Phonenumber");
        String email = request.getParameter("Email");
        
        String password = strongLevelPass(10).toString();
        Customer tempCustomer = new Customer(fname,lname,userName,password,email,phoneNumber);
        
        boolean flag = customerDbUtil.addCustomer(tempCustomer);
        
        PrintWriter out = response.getWriter();
        if(flag)
        {
            out.print("SUCCESS");
            MailSender.send(email,  "HERE IS YOUR PASSWORD : "+password,"ADMIN - PASSWORD"); 
        }
        else
            out.print("USER NAME ALREADY EXISTED");
      
      
      
      
        
        
        
        
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException 
    {
        String userName = request.getParameter("username");
        
        String password = request.getParameter("password");
        
        
        List<Customer> customers = getCustomers();
        PrintWriter out = response.getWriter();
     
        
        boolean isFound = false;
        
        Customer loggedInCustomer = null;
        for (int i = 0; i < customers.size();i++)
        {
            if(customers.get(i).getUserName().equals( userName) && customers.get(i).getPassword().equals(password))
            {
                isFound = true;
                loggedInCustomer = customers.get(i);
                break;
            }
        }
        HttpSession session =request.getSession(true);
        
        session.setAttribute("session_fname", loggedInCustomer.getFirstName() );
        session.setAttribute("session_lname", loggedInCustomer.getLastName() );
        session.setAttribute("session_username", loggedInCustomer.getUserName() );
        session.setAttribute("session_phonenumber", loggedInCustomer.getPhoneNumber());
        
        if(isFound)
            out.print("1");
        else
            out.print("NOT FOUND");
        
        
       
    }

    private void searchResults(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException 
    {
        String destination = request.getParameter("destination");
        String checkInDate = request.getParameter("checkin");
        String checkOutDate = request.getParameter("checkout");
        String numberOfAdults = request.getParameter("numberofadults");
        String numberOfChildren = request.getParameter("numberofchildren");
        
         PrintWriter out = response.getWriter();
         
         out.print(destination+" "+ checkInDate+" "+checkOutDate+" "+numberOfAdults+" "+numberOfChildren);
         
         List<Hotel> hotels = hotelDbUtil.getHotels(destination);
         
         
         
         request.setAttribute("HOTEL_LIST", hotels);
         
         request.setAttribute("CHECK_IN_DATE", checkInDate);
         request.setAttribute("CHECK_OUT_DATE", checkOutDate);
         request.setAttribute("NO_OF_ADULTS", numberOfAdults);
         request.setAttribute("NO_OF_CHILDREN", numberOfChildren);
         
         
         RequestDispatcher dispatcher = request.getRequestDispatcher("/searchResults.jsp");
         
         dispatcher.forward(request,response);
         
         
         
        
       
    }

    private void getRooms(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException 
    {
        String checkInDate = request.getParameter("checkIn");
        String checkOutDate = request.getParameter("checkOut");
        String numberOfAdults = request.getParameter("noOfAdults");
        String numberOfChildren = request.getParameter("noOfChildren");
        
        int hotelId = Integer.parseInt(request.getParameter("hotel_id"));
        
        
        List<Room> rooms = roomDbUtil.getRoomsByHotelId(hotelId);
        
        
          request.setAttribute("ROOM_LIST", rooms);
         
         request.setAttribute("CHECK_IN_DATE", checkInDate);
         request.setAttribute("CHECK_OUT_DATE", checkOutDate);
         request.setAttribute("NO_OF_ADULTS", numberOfAdults);
         request.setAttribute("NO_OF_CHILDREN", numberOfChildren);
         
         
         RequestDispatcher dispatcher = request.getRequestDispatcher("/roomsResult.jsp");
         
         dispatcher.forward(request,response);
         
        
        
       
    }

    private void selectRooms(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException 
    {
        String checkInDate = request.getParameter("checkIn");
        String checkOutDate = request.getParameter("checkOut");
        String numberOfAdults = request.getParameter("noOfAdults");
        String numberOfChildren = request.getParameter("noOfChildren");
        
        String tempRooms[] = request.getParameter("reservedRoomsString").split(",");
        
         List<Room> rooms = roomDbUtil.getRooms();
         
       
        
         
         List<Room> filteredRooms = new ArrayList();
         
         for (int i = 0; i < rooms.size();i++)
         {
             for(int j = 0 ; j < tempRooms.length; j++)
             {
                 if(rooms.get(i).getId() == Integer.parseInt(tempRooms[j]))
                 {
                     filteredRooms.add(rooms.get(i));
                     break;
                 }
             }
         }
         
            Customer requiredCustomer = null;
        
        List<Customer> customers = customerDbUtil.getCustomers();
          HttpSession session = request.getSession(true);
        
       String userName = session.getAttribute("session_username").toString();
        
        for (int i = 0 ; i < customers.size(); i++)
        {
            Customer tempCustomer = customers.get(i);
            if(tempCustomer.getUserName().equals(userName))
            {
                requiredCustomer = tempCustomer;
                break;
            }
        }
         
         
         
           request.setAttribute("SELECTED_ROOMS", filteredRooms);
         
         request.setAttribute("CHECK_IN_DATE", checkInDate);
         request.setAttribute("CHECK_OUT_DATE", checkOutDate);
         request.setAttribute("PASSWORD",requiredCustomer.getPassword());
         
         request.setAttribute("RESERVED_ROOM_STRING",request.getParameter("reservedRoomsString"));
         
         RequestDispatcher dispatcher = request.getRequestDispatcher("/confirmReservation.jsp");
         
         dispatcher.forward(request,response);
    }

    private void reserve(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException 
    {
        String tempRooms[] = request.getParameter("reservedRoomString").split(",");
        String checkInDate = request.getParameter("checkIn");
        String checkOutDate = request.getParameter("checkOut");
        
        String userName = request.getParameter("userName");
        
       PrintWriter out = response.getWriter();
  
    
        Customer requiredCustomer = null;
        
        List<Customer> customers = customerDbUtil.getCustomers();
        
        
        for (int i = 0 ; i < customers.size(); i++)
        {
            Customer tempCustomer = customers.get(i);
            if(tempCustomer.getUserName().equals(userName))
            {
                requiredCustomer = tempCustomer;
                break;
            }
        }
      
        
        List<Room> rooms = roomDbUtil.getRooms();
        
        
        List<Room> filteredRooms = new ArrayList();
        
         for (int i = 0; i < rooms.size();i++)
         {
             for(int j = 0 ; j < tempRooms.length; j++)
             {
                 if(rooms.get(i).getId() == Integer.parseInt(tempRooms[j]))
                 {
                     filteredRooms.add(rooms.get(i));
                     break;
                 }
             }
         }
         
         List<Booking> bookings = new ArrayList();
         Booking tempBooking = null;
    
         for(int i = 0; i < filteredRooms.size(); i++)
         {
             tempBooking = new Booking(checkInDate, checkOutDate, filteredRooms.get(i).getHotelID(),filteredRooms.get(i).getId(), requiredCustomer.getId(),filteredRooms.get(i).getPrice());
             bookings.add(tempBooking);
         }
        
        // reserve
        bookingDbUtil.addBooking(bookings);
        //change availabilty of reseved rooms
        roomDbUtil.changeAvailabiltiy(filteredRooms);
        
        // check if the hotel is avaiable any more or not
        
       
        //get all rooms in this hotel and change availablty to false if all is booked
        
        List<Room> hotelRooms = roomDbUtil.getRoomsByHotelId(filteredRooms.get(0).getHotelID());
        
        
        
        // pass it to hotel DB
        
        hotelDbUtil.changeAvailability(hotelRooms);
        
        
        // return to home
        
        
          response.sendRedirect("temp.jsp");
        
       
        
        
        
        
        
        
        
    }

    private void updateInfo(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException 
    {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String phoneNumber = request.getParameter("phonenumber");
        String password = request.getParameter("password");
        
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        
       String userName = session.getAttribute("session_username").toString();
        
      
        
        Customer updatedCustomer = new Customer(fname,lname, userName, password, phoneNumber);
        
        customerDbUtil.updateInfo(updatedCustomer);
        
        out.print("UPDATED SUCCESFULLY");
        
       
    }

    private void viewReservation(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException
    {
       PrintWriter out = response.getWriter();
       
       
        Customer requiredCustomer = null;
        
        List<Customer> customers = customerDbUtil.getCustomers();
          HttpSession session = request.getSession(true);
        
       String userName = session.getAttribute("session_username").toString();
        
        for (int i = 0 ; i < customers.size(); i++)
        {
            Customer tempCustomer = customers.get(i);
            if(tempCustomer.getUserName().equals(userName))
            {
                requiredCustomer = tempCustomer;
                break;
            }
        }
        
        List<Booking> bookings = bookingDbUtil.getAllBookings(requiredCustomer.getId());
                
        request.setAttribute("BOOKINGS", bookings);
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/viewReservations.jsp");
         
        dispatcher.forward(request,response);
    }

    private void cancelReservation(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, Exception
    {
        int bookingID = Integer.parseInt(request.getParameter("bookingID"));
        
        bookingDbUtil.deleteBookingById(bookingID);
        
          List<Customer> customers = customerDbUtil.getCustomers();
       HttpSession session = request.getSession(true);
       Customer requiredCustomer = null;
       
       String userName = session.getAttribute("session_username").toString();
      
        
        for (int i = 0 ; i < customers.size(); i++)
        {
            Customer tempCustomer = customers.get(i);
            if(tempCustomer.getUserName().equals(userName))
            {
                requiredCustomer = tempCustomer;
                break;
            }
        }
        
        MailSender.send("friendshotel.99@gmail.com", "Canceling booking", "Booking Number: "+bookingID);
        
        
        PrintWriter out = response.getWriter();
        out.print("canceled");
    }

    private void changeReservation(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException 
    {
        
        int hotelId = Integer.parseInt(request.getParameter("hotelId"));
        
        
        
        
        int bookingId = Integer.parseInt(request.getParameter("bookingId"));
        
        
        
        
        List<Room> rooms = roomDbUtil.getRoomsByHotelId(hotelId);
        
        
        request.setAttribute("CHANGED_ROOMS",rooms);
        
         request.setAttribute("BOOKING_ID",bookingId);
        
        
         RequestDispatcher dispatcher = request.getRequestDispatcher("/changeRooms.jsp");
         
        dispatcher.forward(request,response);
        
        
        
        
        
        
        
        
        
        
    }

    private void confirmChangeReservation(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException
    {
        String roomId = request.getParameter("newRoomId");
        
        
        
        
        
        
        int bookingId = Integer.parseInt(request.getParameter("bookingId"));
        
       
        
        bookingDbUtil.updateBooking(bookingId, roomId);
        
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/temp.jsp");
         
        dispatcher.forward(request,response);
        
        
        
        
    }

    private void getReviews(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException 
    {
       
       int hotelId = Integer.parseInt(request.getParameter("hotelId"));
       
       
       List<Review> reviews = reviewsDbUtil.getReviewsByHotelId(hotelId);
       
       
         request.setAttribute("REVIEWS", reviews);
         
        
         request.setAttribute("hotelId",hotelId);
         
         RequestDispatcher dispatcher = request.getRequestDispatcher("/viewReviews.jsp");
         
         dispatcher.forward(request,response);
       
       
      
    }

    private void review(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        
        String comment = request.getParameter("comment");
        int hotelId = Integer.parseInt(request.getParameter("hotelId"));
        String stars = request.getParameter("stars");
        PrintWriter out = response.getWriter();
       List<Customer> customers = customerDbUtil.getCustomers();
       HttpSession session = request.getSession(true);
       Customer requiredCustomer = null;
       
       String userName = session.getAttribute("session_username").toString();
      
        
        for (int i = 0 ; i < customers.size(); i++)
        {
            Customer tempCustomer = customers.get(i);
            if(tempCustomer.getUserName().equals(userName))
            {
                requiredCustomer = tempCustomer;
                break;
            }
        }
        
         Review review = new Review(hotelId, requiredCustomer.getId(), comment, stars );
       
         reviewsDbUtil.addReview(review);
       
        
        
        
        
    }

    private void signOut(HttpServletRequest request, HttpServletResponse response)
    {
        HttpSession session = request.getSession(true);
        session.invalidate();
    }
 static StringBuffer strongLevelPass(int n)
    {
        StringBuffer pass = new StringBuffer();
        int i , d;
        for (i = 0; i < n; i++)
        {
            Random r = new Random();
            d = r.nextInt(200) % 200;

            if (d >= 33 && d <= 123)
            {
                pass.append((char) d);
            }
            else
            {
                pass.append(d%10);
            }
        }
        return pass;
    }
}
