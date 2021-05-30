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
public class ReviewsDbUtil
{
    private  DataSource dataSource;

    public ReviewsDbUtil(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    List<Review> getReviewsByHotelId(int hotelId) throws SQLException 
    {
        List<Review> reviews = new ArrayList();
        
         Connection connection = null;
        Statement statement = null;
        ResultSet RS = null;
        // get a connection
        try
        {  
            connection = dataSource.getConnection();
            
            String query = "select * from reviews where hotel_id= "+hotelId;
        
            statement = connection.createStatement();
        
            RS = statement.executeQuery(query);
            
            while(RS.next())
            {
              int id = RS.getInt("id");
              int hotel_id = RS.getInt("hotel_id");
              int customer_id = RS.getInt("customer_id");
              
              
              String review_comment = RS.getString("review_comment");
              
              String stars = RS.getString("stars");
              
              Review tempReview = new Review(id, hotel_id, customer_id, review_comment, stars);
              
              reviews.add(tempReview);
              
              
               
            }
        
        }
        finally{
            // close JDBC objects
            close(connection, statement, RS);
        }
        
        
        return reviews;
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


    void addReview(Review review) throws SQLException
    {
        Connection connection = null;
        Statement statement = null;
      
        // get a connection
        try
        {  
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            
            String query = "INSERT INTO reviews(hotel_id, customer_id, review_comment, stars)"
                    + " values("+review.getHotelId()+","+review.getCustomerId()+",'"+review.getComment()+"','"+review.getStars()+"');";
            
            statement.executeUpdate(query);
            
            
        }
         finally{
            // close JDBC objects
            close(connection, statement);
        }
       
        
    }
    
    
}
