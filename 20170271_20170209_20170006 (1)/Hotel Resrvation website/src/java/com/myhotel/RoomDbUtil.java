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
public class RoomDbUtil 
{
    private DataSource dataSource;

    public RoomDbUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }
  public List<Room> getRoomsByHotelId(int hotelId) throws SQLException 
    {
         List<Room> rooms = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        ResultSet RS = null;
        // get a connection
        try
        {  
            connection = dataSource.getConnection();
            
            String query = "select * from rooms where hotel_id= "+hotelId+" and isBooked = 0";
        
            statement = connection.createStatement();
        
            RS = statement.executeQuery(query);
            
            while(RS.next())
            {
                int id = RS.getInt("id");
                String roomType = RS.getString("type");
                int price = RS.getInt("price");
                int roomCapacity = RS.getInt("capacity");
                boolean isBooked = RS.getBoolean("isBooked");
                
                Room tempRoom = new Room(id,  roomType, hotelId, price, roomCapacity, isBooked);
                
                
                rooms.add(tempRoom);
                
               
            }
        
        }
        finally{
            // close JDBC objects
            close(connection, statement, RS);
        }
      
        return rooms;
        
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
    
   
    
    public List<Room> getRooms() throws SQLException
    {
        List<Room> rooms = new ArrayList();
        
        Connection connection = null;
        Statement statement = null;
        ResultSet RS = null;
        // get a connection
        try
        {  
            connection = dataSource.getConnection();
            
            String query = "select * from rooms";
        
            statement = connection.createStatement();
        
            RS = statement.executeQuery(query);
            
            while(RS.next())
            {
                int id = RS.getInt("id");
                String roomType = RS.getString("type");
                int price = RS.getInt("price");
                int roomCapacity = RS.getInt("capacity");
                boolean isBooked = RS.getBoolean("isBooked");
                int hotelId = RS.getInt("hotel_id");
                
                Room tempRoom = new Room(id,  roomType, hotelId, price, roomCapacity, isBooked);
                
                rooms.add(tempRoom);
                
              
            
            }
        
        }
        finally{
            // close JDBC objects
            close(connection, statement, RS);
        }
        
        return rooms;
    }      

    void changeAvailabiltiy(List<Room> filteredRooms) throws SQLException 
    {
         Connection connection = null;
        Statement statement = null;
        
        
        // get a connection
        try
        {
            connection = dataSource.getConnection();
            String query = null;
            
            statement = connection.createStatement();
            for(int i = 0; i<filteredRooms.size();i++)
            {
                
                Room tempRoom = filteredRooms.get(i);
                query = "UPDATE rooms SET isBooked = "+1+" where id= "+tempRoom.getId();
                statement.executeUpdate(query);
            }
           
        
        }
         finally{
            // close JDBC objects
            close(connection, statement);
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
   


    void updateRoom(Room updatedRoom) throws SQLException 
    {
        Connection connection = null;
        Statement statement = null;
       
        
        try
        {  
            connection = dataSource.getConnection();
            
            String query = "UPDATE ROOMS SET type = '"+updatedRoom.getType()+"', isBooked ="+updatedRoom.isBooked()+", price ='"+updatedRoom.getPrice()+"', capacity ='"+updatedRoom.getCapacity()+"' Where id = "+updatedRoom.getId()+" ;";
        
            statement = connection.createStatement();
            
            statement.executeUpdate(query);
        
  
            
        }
        finally{
            // close JDBC objects
            close(connection, statement);
        }
    }
}
