/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhotel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author Mahmoud Esmail
 */
public class BookingDbUtil {
    private DataSource dataSource;

    public BookingDbUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    void addBooking(List<Booking> bookings) throws SQLException 
    {
       Connection connection = null;
        Statement statement = null;
        
        
        // get a connection
        try
        {
            connection = dataSource.getConnection();
            String query = null;
            
            statement = connection.createStatement();
            for(int i = 0; i<bookings.size();i++)
            {
                
                Booking tempBooking = bookings.get(i);
                query = "INSERT INTO BOOKINGS(checkInDate,checkOutDate,hotel_id,room_id,customer_id,price)"
                    + "values('"+tempBooking.getCheckInDate()+"','"+tempBooking.getCheckOutDate()+"','"+tempBooking.getHotelId()+"','"+tempBooking.getRoomId()+"','"+tempBooking.getCustomerId()+"',"+tempBooking.getPrice()+");";
                statement.executeUpdate(query);
            }
           
        
        }
         finally{
            // close JDBC objects
            close(connection, statement);
        }
       
    }
    
    
     private void close(Connection connection, Statement statement, ResultSet RS) throws SQLException
    {
        try 
        {
            if(RS != null)
                RS.close();
            
            if (connection != null)
                connection.close();
            
            if(statement != null)
                statement.close();
            
        }catch(Exception exc)
        {
            exc.printStackTrace();
        }
        
    }
       private void close(Connection connection, Statement statement) throws SQLException{
        try 
        {
           
            
            if (connection != null)
                connection.close();
            
            if(statement != null)
                statement.close();
            
        }catch(Exception exc)
        {
            exc.printStackTrace();
        }
        
    }

    List<Booking> getAllBookings(int id) throws SQLException 
    {
        List<Booking> bookings = new ArrayList();
        
         Connection connection = null;
        Statement statement = null;
        ResultSet RS = null;
        // get a connection
        try
        {  
            connection = dataSource.getConnection();
            
            String query = "select * from bookings where customer_id= "+id;
        
            statement = connection.createStatement();
        
            RS = statement.executeQuery(query);
            
            while(RS.next())
            {
                int bookingId = RS.getInt("id");
                String checkInDate =RS.getString("checkInDate");
                String checkOutDate = RS.getString("checkOutDate");
                int hotelId = RS.getInt("hotel_id");
                int roomId = RS.getInt("room_id");
                int customerId = RS.getInt("customer_id");
                int price = RS.getInt("price");
                
                Booking tempBooking = new Booking(bookingId, checkInDate, checkOutDate, hotelId, roomId, customerId,price);
                
                bookings.add(tempBooking);
                
               
            }
        
        }
        finally{
            // close JDBC objects
            close(connection, statement, RS);
        }
        
        
        return bookings;
        
       
    }

    void deleteBookingById(int bookingID) throws SQLException
    {
         Connection connection = null;
        Statement statement = null;
        
       
        
        // get a connection
        try
        {  
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            
            String query = "Delete from bookings where id = "+bookingID;
            
            statement.executeUpdate(query);
            
            
            
          
        }
         finally{
            // close JDBC objects
            close(connection, statement);
        }
       
        
    }

    void updateBooking(int bookingId, String roomId) throws SQLException 
    {
        Connection connection = null;
        Statement statement = null;
        
       
        
        // get a connection
        try
        {  
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            
            String query = "UPDATE BOOKINGS SET room_id ="+roomId+"  where id = "+bookingId;
            
            statement.executeUpdate(query);
            
            
            
          
        }
         finally{
            // close JDBC objects
            close(connection, statement);
        }
        
    }

    List<Booking> getAllBookings() throws SQLException
    {
          List<Booking> bookings = new ArrayList();
        
         Connection connection = null;
        Statement statement = null;
        ResultSet RS = null;
        // get a connection
        try
        {  
            connection = dataSource.getConnection();
            
            String query = "select * from bookings";
        
            statement = connection.createStatement();
        
            RS = statement.executeQuery(query);
            
            while(RS.next())
            {
                int bookingId = RS.getInt("id");
                String checkInDate =RS.getString("checkInDate");
                String checkOutDate = RS.getString("checkOutDate");
                int hotelId = RS.getInt("hotel_id");
                int roomId = RS.getInt("room_id");
                int customerId = RS.getInt("customer_id");
                int price = RS.getInt("price");
                
                Booking tempBooking = new Booking(bookingId, checkInDate, checkOutDate, hotelId, roomId, customerId,price);
                
                bookings.add(tempBooking);
                
               
            }
        
        }
        finally{
            // close JDBC objects
            close(connection, statement, RS);
        }
        
        
        return bookings;
    }
}
