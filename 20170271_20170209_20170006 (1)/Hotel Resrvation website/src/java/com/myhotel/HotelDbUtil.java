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
public class HotelDbUtil {
    private DataSource dataSource;

    public HotelDbUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
     public List<Hotel> getHotels(String destination) throws SQLException
    {
        List<Hotel> hotels = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        ResultSet RS = null;
        // get a connection
        try
        {  
            connection = dataSource.getConnection();
            
            String query = "select * from hotel where city= '"+destination+"' AND availability ='availlable';";
        
            statement = connection.createStatement();
        
            RS = statement.executeQuery(query);
            
            while(RS.next())
            {
                int id = RS.getInt("id");
                String hotelName = RS.getString("name");
                String availability = RS.getString("availability");
                float expectedPrice = RS.getFloat("expectedPrice");
                String rating = RS.getString("rating");
                String city = RS.getString("city");
                String imageUrl = RS.getString("image_url");
                String location = RS.getString("location");
               
                
                Hotel hotelTemp = new Hotel(id, hotelName, availability, expectedPrice, rating,city,imageUrl,location);
                
                hotels.add(hotelTemp);
                
               
            }
        
        }
        finally{
            // close JDBC objects
            close(connection, statement, RS);
        }
      
        return hotels;
    }
    
    
    
     public List<Hotel> getHotels() throws SQLException
    {
        List<Hotel> hotels = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        ResultSet RS = null;
        // get a connection
        try
        {  
            connection = dataSource.getConnection();
            
            String query = "select * from hotel;";
        
            statement = connection.createStatement();
        
            RS = statement.executeQuery(query);
            
            while(RS.next())
            {
                int id = RS.getInt("id");
                String hotelName = RS.getString("name");
                String availability = RS.getString("availability");
                float expectedPrice = RS.getFloat("expectedPrice");
                String rating = RS.getString("rating");
                String city = RS.getString("city");
                String imageUrl = RS.getString("image_url");
                String hotelLocation = RS.getString("location");
               
                
                Hotel hotelTemp = new Hotel(id, hotelName, availability, expectedPrice, rating,city,imageUrl, hotelLocation);
                
                hotels.add(hotelTemp);
                
               
            }
        
        }
        finally{
            // close JDBC objects
            close(connection, statement, RS);
        }
      
        return hotels;
    }
    
  private void close(Connection connection, Statement statement, ResultSet RS) throws SQLException{
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

    void updateHotel(Hotel updatedHotel) throws SQLException 
    {
           Connection connection = null;
        Statement statement = null;
       
        
        try
        {  
            connection = dataSource.getConnection();
            
            String query = "UPDATE HOTEL SET name = '"+updatedHotel.getHotelName()+"', availability ='"+updatedHotel.getAvailability()+"', expectedPrice ='"+updatedHotel.getExpectedPrice()+"', rating ='"+updatedHotel.getRating()+"', city = '"+updatedHotel.getCity()+"',image_url ='"+updatedHotel.getImageUrl()+"' Where id = "+updatedHotel.getId()+" ;";
        
            statement = connection.createStatement();
            
            statement.executeUpdate(query);
        
  
            
        }
        finally{
            // close JDBC objects
            close(connection, statement);
        }
    }

    void changeAvailability(List<Room> hotelRooms) throws SQLException
    {
        boolean isAvailable = false;
        
        for(int i = 0 ; i < hotelRooms.size(); i++)
        {
            if(hotelRooms.get(i).isBooked() == false)
            {
                isAvailable = true;
                break;
            }
            
        }
        
        if(!isAvailable)
        {
            Connection connection = null;
            Statement statement = null;
        
        // get a connection
        try
        {  
            connection = dataSource.getConnection();
            
            String query = "UPDATE HOTEL Set availability = 'Not Available' where id = " + hotelRooms.get(0).getHotelID();
        
            statement = connection.createStatement();
        
            
            statement.executeUpdate(query);
          
        
        }
        finally{
            // close JDBC objects
            close(connection, statement);
        }
            
        }
        
        
        
    }

   
   
}
