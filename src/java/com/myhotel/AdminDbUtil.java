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
public class AdminDbUtil {
    
    private DataSource dataSource;

    public AdminDbUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    List<Admin> getAdmins() throws SQLException 
    {
        List<Admin> admins = new ArrayList();
        
         
        
        Connection connection = null;
        Statement statement = null;
        ResultSet RS = null;
        // get a connection
        try
        {  
            connection = dataSource.getConnection();
            
            String query = "select * from admin";
        
            statement = connection.createStatement();
        
            RS = statement.executeQuery(query);
            
            while(RS.next())
            {
                int id = RS.getInt("id");
                String name = RS.getString("name");
                String userName = RS.getString("userName");
                String password = RS.getString("password");
                
                
                Admin tempAdmin = new Admin(id, name, userName, password);
                
                admins.add(tempAdmin);
            }
        
        }
        finally{
            // close JDBC objects
            close(connection, statement, RS);
        }
        
        
        return admins;
        
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
    
    
    
}
