/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhotel;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.sql.DataSource;

/**
 *
 * @author Mahmoud Esmail
 */
public class main {
    
    public static void main(String[] args) throws SQLException, Exception
    {
       DataSource dataSource = getMySQLDataSource();
       
       HotelDbUtil hotelDbUtil = new HotelDbUtil(dataSource);
       
        
       boolean isAvailable = false;
       
       List<Room> hotelRooms = new ArrayList();
       hotelRooms.add(new Room(1,"Garden View",1,2500,3,false));
//       hotelRooms.add(new Room(4,"Sea View",2,2500,3,false));
       
       
       
       
       
   
        
        for(int i = 0 ; i < hotelRooms.size(); i++)
        {
            if(hotelRooms.get(i).isBooked() == false)
            {
                
                isAvailable = true;
                break;
            }
            
        }
       
        
        hotelDbUtil.changeAvailability(hotelRooms);
        
//        
    }
        
//        if(!isAvailable)
//        {
//            Connection connection = null;
//            Statement statement = null;
//        
//        // get a connection
//          
//            connection = dataSource.getConnection();
//            
//            String query = "UPDATE HOTEL Set availability = 'Not Available' where id = " + hotelRooms.get(0).getHotelID();
//        
//            statement = connection.createStatement();
//        
//            
//            statement.executeUpdate(query);
//        }
          
    
         
        
        
        
	
	

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
    static void strongLevelPass(int n)
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
        System.out.println(pass);
    }

    }