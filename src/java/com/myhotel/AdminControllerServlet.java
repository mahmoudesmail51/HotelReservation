/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhotel;

import static com.myhotel.CustomerControllerServlet.getMySQLDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
@WebServlet(name = "AdminControllerServlet", urlPatterns = {"/AdminControllerServlet"})
public class AdminControllerServlet extends HttpServlet {

    private CustomerDbUtil customerDbUtil;
    
    private HotelDbUtil hotelDbUtil;
    
    private RoomDbUtil roomDbUtil;
    
    private BookingDbUtil bookingDbUtil;
    
    private ReviewsDbUtil reviewsDbUtil;
    
    
    
    private AdminDbUtil adminDbUtil;
    
    
    
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
            adminDbUtil = new AdminDbUtil(dataSource);
             
            
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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
              String command = request.getParameter("command");
              
              switch(command)
              {
                  case"sign in":
                      adminLogin(request,response);
                      break;
                      
                  case "searchCustomer":
                      searchCustoemr(request,response);
                      break;
                      
                  case "updateHotel":
                      updateHotel(request,response);
                      break;
                  
                      
                  case "updateRoom":
                      updateRoom(request,response);
                      break;
                      
                  case "getReviews":
                      getReviews(request,response);
                      break;
                      
                  case "viewReservation":
                      viewReservations(request,response);
                      break;
                  
                  case "cancelReservation":
                    cancelReservation(request,response);
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
            Logger.getLogger(AdminControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AdminControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
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

    private void adminLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException 
    {
             String userName = request.getParameter("username");
        
        String password = request.getParameter("password");
        
        
        
        PrintWriter out = response.getWriter();
        
        
        List<Admin> admins = adminDbUtil.getAdmins();
     
       
        boolean isFound = false;
        
        Admin loggedInAdmin = null;
        for (int i = 0; i < admins.size();i++)
        {
            if(admins.get(i).getUserName().equals( userName) && admins.get(i).getPassword().equals(password))
            {
                isFound = true;
                loggedInAdmin = admins.get(i);
                break;
            }
        }
        
        HttpSession session =request.getSession(true);
        
        session.setAttribute("session_name", loggedInAdmin.getName() );
        session.setAttribute("session_username", loggedInAdmin.getId() );
     
        
        if(isFound)
            out.print("1");
        else
            out.print("NOT FOUND");
        
    }

    private void searchCustoemr(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException
    {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        
        
        List<Customer> customers = customerDbUtil.getCustomers();
        
        
        boolean isFound = false;
        
        Customer requiredCustomer = null;
        
        for(int i = 0 ; i < customers.size(); i++)
        {
            if(customers.get(i).getId() == customerId)
            {
                isFound = true;
                requiredCustomer = customers.get(i);
                break;
            }
        }
        PrintWriter out = response.getWriter();
        if(isFound)
        {
            out.print("Customer Full Name: "+requiredCustomer.getFirstName()+" "+ requiredCustomer.getLastName()
                       +"Customer Email Address: "+requiredCustomer.getEmail()+" Customer Phone Number : "+requiredCustomer.getPhoneNumber());
            
        }
        else
            out.print("ID NOT VALID");
        
        
        
        
    }

    private void updateHotel(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException
    {
        int hotelId = Integer.parseInt(request.getParameter("hotelId"));
        
        String hotelName = request.getParameter("hotelName");
        String hotelRating = request.getParameter("hotelRating");
        String hotelAvailabillity = request.getParameter("hotelAvailabillity");
        int hotelPrice = Integer.parseInt(request.getParameter("expectedPrice"));
        
        String hotelPhotoUrl = request.getParameter("hotelPhoto");
        String hotelCity = request.getParameter("hotelCity");
        String hotelLocation = request.getParameter("hotelLocation");
        
        
       PrintWriter out = response.getWriter();
       
       List<Hotel> hotels = hotelDbUtil.getHotels();
       
      boolean isFound = false;
      
      for (int i = 0; i < hotels.size(); i++)
      {
          if(hotels.get(i).getId() == hotelId)
          {
              isFound = true;
              break;
          }
      }
      
      
      if(isFound)
      {
          Hotel updatedHotel = new Hotel(hotelId, hotelName, hotelAvailabillity, hotelPrice, hotelRating ,hotelCity, hotelPhotoUrl , hotelLocation );
          hotelDbUtil.updateHotel(updatedHotel);
          
          out.print("UPDATED SUCCESSFULLY");
      }
      else
          out.print("ENTER VALID HOTEL ID ");
       
       
       
      
        
        
        
        
    }

    private void updateRoom(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException
    {
        int roomId = Integer.parseInt(request.getParameter("roomId"));
        
        String roomType = request.getParameter("roomType");
        int roomPrice = Integer.parseInt(request.getParameter("roomPrice"));
        
        int roomCapacity = Integer.parseInt(request.getParameter("roomCapacity"));
        int isAvailable = Integer.parseInt(request.getParameter("isBooked"));
        boolean isBooked = false;
        if(isAvailable == 1)
        {
            isBooked = true;
        }
        
       List<Room> rooms = roomDbUtil.getRooms();
       
        PrintWriter out = response.getWriter();
       
       boolean isFound = false;
       int hotelId = 0;
       
       for(int i = 0 ; i < rooms.size(); i++)
       {
           if(rooms.get(i).getId() == roomId)
           {
               isFound = true;
               hotelId = rooms.get(i).getHotelID();
               break;
           }
       }
       
       if(isFound)
       {
           Room updatedRoom = new Room(roomId,roomType,hotelId,roomPrice, roomCapacity, isBooked);
           roomDbUtil.updateRoom(updatedRoom);
           
           out.print("UPDATED SUCCESSFULLY");
           
       }
       else
           out.print("ENTER VALID ROOM ID ");
       
       
       
    }

    private void getReviews(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException 
    {
        PrintWriter out = response.getWriter();
       int hotelId = Integer.parseInt(request.getParameter("hotelId"));
       
      
       
       
      List<Review> reviews = reviewsDbUtil.getReviewsByHotelId(hotelId);
      
        request.setAttribute("REVIEWS", reviews);
         
        
         
         
        RequestDispatcher dispatcher = request.getRequestDispatcher("/viewRatings.jsp");
        
        dispatcher.forward(request,response);
       
    }

    private void viewReservations(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException 
    {
       
        
        List<Booking> bookings = bookingDbUtil.getAllBookings();
                
        request.setAttribute("BOOKINGS", bookings);
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/adminViewReservations.jsp");
         
        dispatcher.forward(request,response);
    }

    private void cancelReservation(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException 
    {
         int bookingID = Integer.parseInt(request.getParameter("bookingID"));
        
        bookingDbUtil.deleteBookingById(bookingID);   
        PrintWriter out = response.getWriter();
        out.print("canceled");
       
    }
}
